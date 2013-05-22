-- plsql 9
-- pragma exception_init

declare
	val_too_large	exception;
	pragma exception_init ( val_too_large, -1438 );
begin
	insert into emp (empno, ename, sal) values (1234, 'Joe', 1000000);
exception
	when val_too_large then
		dbms_output.put_line('value too large');
	when others then raise;
end;
/
