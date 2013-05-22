-- plsql_1
-- control statements, dbms_output package

begin
	dbms_output.put_line('Loop Starting');
	for cntr in 2..20 loop
		if mod(cntr,2) = 0 then
			dbms_output.put_line('counter is '||cntr);
		end if;
	end loop;
	dbms_output.put_line('Loop ending');
end;
/
