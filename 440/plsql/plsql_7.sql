 -- plsql 7
-- exceptions

declare
	row_count	integer;
	big_sals	exception;
begin
	select count(*) into row_count from emp where sal > 4000;
	if row_count > 0 then
		raise big_sals;
	end if;
	update emp set sal = 1.05 * sal;
exception
	when big_sals then
		update emp set sal = 1.10 * sal where sal > 4000;
	when others then raise;
end;
/
