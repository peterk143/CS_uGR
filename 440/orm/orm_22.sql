-- orm 22
-- how to use a nested table as an attribute of table

create table department (
deptno number(2),
dname varchar2(14),
loc varchar2(13),
employees worker_nt)
nested table employees
store as employees_nt_tab
/
