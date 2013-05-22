-- orm 12
-- now lets use our member function to determine years of service for each employee
-- note the need for a correlation variable

select e.emp_info.ename, e.emp_info.years_of_service(e.emp_info.hiredate)
from employee e
/
