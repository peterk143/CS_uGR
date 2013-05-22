--exceptions--
declare 
	Improper_location	exception;
	pragma	exception_init(Improper_location -1234);
begin
	raise Improper_location;
exception
	when Improper_location then
		dbms_output.put_line('improper_location');
	when others then raise;
end;

declare 
	Illegal_Update	exception;
	pragma exception_init(Illegal_Update -1235);
begin
	raise Illegal_Update;
exception
	when Illegal_Update then
		dbms_output.put_line('illegal_update');
	when others then raise;
end;

declare
	Password_change_failure	exception;
	pragma	exception_init(Password_change_failure -1236);
begin
	raise Password_change_failure;
exception
	when Password_change_failure then
		dbms_output.put_line('password_change_failure');
	when others then raise;
end;

declare
	Too_many_animals	exception;
	pragma exception_init(Too_many_animals -1237);
begin
	raise Too_many_animals;
exception
	when Too_many_animals then
		dbms_output.put_line('too_many_animals');
	when others then raise;
end;