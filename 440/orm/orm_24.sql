-- orm 24
-- using the table function to access the entire nested table
-- must use the 'cartesian product' syntax


select dname, e.ename, e.job
from department d, table (d.employees) e
/
