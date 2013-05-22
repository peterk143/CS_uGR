-- plsql_13
-- package specification


-- package and package_name only
-- anything you put here is public
create or replace package sup_pack
is
	-- simply list functions, procedures, and their specs (params, return types)

	function list_parts(p_s# s.s#%type)
		return varchar2;
end sup_pack;
/
