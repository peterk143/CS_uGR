-- orm 16
-- how to update a varying array
-- Notes:  we are replacing the object
-- note the correlation variable

update employee e
set e.emp_info.projects = proj_va('Task 7', 'Task 8', 'Task 9')
where upper(e.emp_info.ename) = 'GORE';
/
