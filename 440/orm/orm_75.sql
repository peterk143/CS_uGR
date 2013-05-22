select deptno, dname, deref(column_value).empno, deref(column_value).ename
from mydept, table(emps)
where column_value
member of
((select emps from mydept where deptno = 10) multiset union
(select emps from mycommittee where commno = 2))
/
