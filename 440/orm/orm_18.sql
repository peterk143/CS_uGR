-- orm 18
-- this shows how we can access varying arrays using the table function

select e.emp_info.ename, p.column_value
from employee e, table(e.emp_info.projects) p
where e.emp_info.projects is not null;
/
