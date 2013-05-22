-- orm 8
-- create an object table for instead of trigger example

create or replace view company as
select deptno, dname, ename, job, sal
from dept left join emp using(deptno)
/
