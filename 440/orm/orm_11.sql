-- orm 11
-- here is the accompanying package body
-- there is a fatal error here
-- please identify

create or replace type body emp_ty
	as
member function years_of_service (hired_date date)
	return number
is
begin
	return trunc(months_between (sysdate, hired_date)/12);
end years_of_service;
end;
/
