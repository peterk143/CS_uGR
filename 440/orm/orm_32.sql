-- orm 32
-- selecting from a nested table
-- with large numbers, this can be prohibitively expensive

select ename
from department, table(employees)
where deptno = 10 and job = 'Sales'
/