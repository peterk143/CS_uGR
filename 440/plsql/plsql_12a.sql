-- plsql_12
-- procedures
create or replace procedure concatenate
	(p_str1 in out varchar2, p_str2 in varchar2)
-- no return type
is
-- no declare
begin
	if p_str1 is null then
		p_str1 := p_str2;
		return;
	end if;
	p_str1 := p_str1 || ', ' || p_str2;
end concatenate;
/
