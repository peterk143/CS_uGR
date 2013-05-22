-- orm 39
-- introduction to using a nested table in sql
declare
	uninitialized_ref exception;
	pragma exception_init(uninitialized_ref, -6531);
		-- oracle's attribute value is null exception
	null_index_key exception;
	pragma exception_init (null_index_key, -6502);
		-- nested table with no records
	ndx integer;
begin
	for rec in (select employees from department) loop
		if rec.employees.count != 0 then
			ndx := rec.employees.first;
			while ndx < rec.employees.last loop
				dbms_output.put_line(rec.employees(ndx).ename);
				ndx := rec.employees.next(ndx);
			end loop;
		end if;
	end loop;
exception
	when uninitialized_ref then dbms_output.put_line('unitialized_ref');
	when null_index_key then dbms_output.put_line('null_index_key');
	when others then raise;
end;
/
