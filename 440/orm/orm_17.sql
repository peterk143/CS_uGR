-- orm 17
-- this shows how we can access varying arrays in an anonymous block

declare
	proj proj_va;
begin
	select e.emp_info.projects into proj from employee e where upper(e.emp_info.ename) = 'GORE';
	if proj is not null then
		for cnt in 1..proj.count loop
			dbms_output.put_line(proj(cnt));
		end loop;
	end if;
end;
/
