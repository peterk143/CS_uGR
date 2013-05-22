-- orm 19
-- how to modify an existing varying array

declare
	proj proj_va;
begin
	select e.emp_info.projects into proj
		from employee e
		where upper(e.emp_info.ename) = 'GORE';
	if proj is null then
		proj := proj_va('Task 1', 'Task 2');
	elsif proj.count > proj.limit - 1 then
		raise_application_error(-20001, 'Array Full');
	else
		proj.extend;
		proj(proj.count) := 'Task 1';
		proj.extend;
		proj(proj.count) := 'Task 2';
	end if;
	update employee e
		set e.emp_info.projects = proj
		where upper(e.emp_info.ename) = 'GORE';
end;
/
