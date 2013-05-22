-- orm 35
-- insert dept info into department table
-- note we must instantiate the nested table entry for each row, or 
-- it will be null
--

insert into department (deptno, dname, loc, employees)
select deptno, dname, loc, worker_nt()
from dept
/
