select dname, e.ename
from department, table (employees) e
where upper(e.job) = 'CLERK'
/
