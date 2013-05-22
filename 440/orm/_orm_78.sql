-- orm_77
-- now we can turn the information from our emp_object_table into a nested table suitable for comparison

select column_value
from 
table(cast(collect(empno) as empno_nt) from emp_object_table)
where column_value
member of
((select cast(collect(deref(column_value).empno) as empno_nt) from table(select emps from mydept where deptno = 10))
multiset union
(select cast(collect(deref(column_value).empno) as empno_nt) from table(select emps from mycommittee where commno = 2)))
/