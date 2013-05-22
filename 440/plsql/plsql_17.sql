-- plsql_17
-- table for trigger example
drop table job_sal;
create table job_sal (job, salary)
as
select job, sum(sal)
from emp
where sal is not null
group by job
/
