-- plsql 5
-- inline cursors

declare
	v_increase number;
begin
	for c1_rec in (select empno, deptno from emp where deptno in (10,20)) loop
		if c1_rec.deptno = 10 then
			v_increase := 1.05;
		else
			v_increase := 1.15;
		end if;
		update emp set sal = v_increase * sal where empno = c1_rec.empno;
	end loop;
end;
/
