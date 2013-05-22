select *
from table(select emps from mydept where deptno = 10) 
multiset intersect 
table (select emps from mycommittee where commno = 2)
/
