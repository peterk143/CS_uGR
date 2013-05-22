-- orm 28
-- cardinality function
-- returns null if employees has not bee created for this row

select cardinality(employees)
from department
where deptno = 20
/
