/* plsql 6
    cursors "for update"
    Cursors must be defined explicitly to do this
    Cursor declaration causes all rows to be locked until committed
*/

declare
	cursor c1 is select empno, deptno from emp where deptno in (10,20) for update;
	v_increase number;
begin
	for c1_rec in c1 loop
		if c1_rec.deptno = 10 then
			v_increase := 1.05;
		else
			v_increase := 1.15;
		end if;
		update emp set sal = v_increase * sal where current of c1;
	end loop;
end;
/
