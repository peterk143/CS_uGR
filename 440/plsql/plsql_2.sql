-- plsql 2
-- integrating DML statements

declare
	v_total_sal	emp.sal%type;
	v_increment	number default 1.05;
begin
	select sum(sal) into v_total_sal from emp;
	if v_total_sal <= 10000
		then v_increment := 1.10;
	end if;
	update emp set sal = sal * v_increment;
end;
/
