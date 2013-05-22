-- orm 40
-- object for nested table example
--
create or replace type worker_ty_2 as object (
empno number(4),
ename varchar2(10),
job varchar2(9),
mgr number(4),
hiredate date,
sal number(7,2),
comm number(7,2),
deptno number(2)
) 
/
