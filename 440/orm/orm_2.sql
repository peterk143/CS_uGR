-- orm 2
-- our first table with ADT
--
drop table employee;
--
create table employee
(empno number(4) constraint employee_pk primary key deferrable initially immediate,
emp_info emp_ty,
deptno number(2))
/
