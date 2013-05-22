-- plsql_14
-- package body

-- here terminology is package body name
create or replace package body sup_pack
is
	-- this procedure not in spec. Can only be used within package
	procedure concatenate
		(p_str1 in out varchar2, p_str2 in varchar2)
	is
	begin
		if p_str1 is null then
			p_str1 := p_str2;
			return;
		end if;
		p_str1 := p_str1 || ', ' || p_str2;
	end concatenate;

	-- here's the function listed in the spec
	function list_parts 
		(p_s# s.s#%type)
	return varchar2 is
	result varchar2(100) := null;
	begin
		for rec in (select pname from sp natural join p where s# = p_s#) loop
			concatenate (result, rec.pname);
		end loop;
		return result;
	end list_parts;
end sup_pack;
/
