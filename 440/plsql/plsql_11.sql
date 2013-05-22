-- plsql_11
-- function
create or replace function list_parts 
	-- parameters comma separated
	(p_s# s.s#%type)
	-- functions must indicate return type
	return varchar2 is
	-- no "declare"
	result varchar2(100) := null;
begin
	-- get all part names
	for rec in (select pname from sp natural join p where s# = p_s#) loop
		if result = null then
			result := rec.pname;
		else 
			result := result || ', ' || rec.pname;
		end if;
	end loop;
	-- functions must have a return statement
	return result;
-- nice option to add function name to end
end list_parts;
/
