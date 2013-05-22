-- pl/sql 3
-- cursors

declare
	cursor c1 is select empno, deptno from emp where deptno in (10,20);
	c1_rec c1%rowtype;
	v_increase number;
begin
	open c1;
	fetch c1 into c1_rec;
	while c1%found loop
		if c1_rec.deptno = 10 then
			v_increase := 1.05;
		else
			v_increase := 1.10;
		end if;
		update emp set sal = v_increase * sal where empno = c1_rec.empno;
		fetch c1 into c1_rec;
	end loop;
	close c1;
end;
/
