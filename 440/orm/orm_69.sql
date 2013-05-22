create table mydept (
deptno number(2),
dname varchar2(14),
loc varchar2(13),
emps emp_object_refs)
nested table emps
store as dept_emp_refs_table
/
