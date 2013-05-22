-- orm 58
-- object tables in plsql
--
declare
	v_dept dept_ty;
begin
       	select value(d) into v_dept
               	from dept_ov d
  		where deptno = 10;
	dbms_output.put_line(v_dept.dname || '  ' || v_dept.loc);
end;
/
