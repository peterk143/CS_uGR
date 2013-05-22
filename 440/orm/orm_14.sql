-- orm 14
-- adding a varying array as an attribute for this object
-- we cannot change an object referenced in a table
--
-- note: we will need to change the constructor for emp_ty

drop table employee;
drop view emp_ov;
drop type emp_ty;
--  now we can create the type specification 
create or replace type emp_ty as object
(ename varchar2(10),
job varchar2(9),
mgr number(4),
hiredate date,
sal number(7,2),
comm number(7,2),
-- adding a varying array of type proj_va
projects proj_va,
member function years_of_service (hired_date date)
	return number
);
/
-- now we can recreate table employee
@@orm_2
-- populate it
insert into employee
(empno, emp_info, deptno)
select empno, emp_ty(ename, job, mgr, hiredate, sal, comm,proj_va()), deptno
from emp
/
-- and recreate view emp_ov

create or replace view emp_ov
	(empno, emp_info, deptno)
as
select empno, emp_ty(ename, job, mgr, hiredate, sal, comm, proj_va()), deptno
from emp;



