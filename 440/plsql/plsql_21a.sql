-- plsql 21a
-- package spec for mutating table example
-- we don't really need a body as there is nothing to implement
-- package gives us a vessel to hold instance of assoc.array
create or replace package trig as
	-- create associative array type	
	type emp_ty is table of emp%rowtype index by binary_integer;
	-- create instance of the type
	-- globally visible
	emp_tab emp_ty;
end trig;
/
