-- orm 10
-- member function specification
-- we cannot change an object referenced in a table
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
member function years_of_service (hired_date date)
	return number
);
/
-- now we can recreate table employee
@@orm_2
-- populate it
@@orm_3
-- and recreate view emp_ov
@@orm_5


