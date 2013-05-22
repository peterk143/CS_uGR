-- orm 59
-- object tables/views in pl/sql
--
declare
	new_dept	dept_ty;
begin
	new_dept := dept_ty (50, 'Maintenance', 'Morgantown');
	insert into dept_ov values(new_dept);
end;
/
