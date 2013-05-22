-- plsql 15
-- associative array example
declare
	-- cursor of all emp records
	cursor emp_crs is
		select ename, job, sal, comm
		from emp
		order by job, sal desc;
	-- associative array type
	type c1_type is table of emp_crs%rowtype index by binary_integer;
	-- associative array of chosen records from emp_crs
	c1_tab c1_type;
	cntr integer := 0;
begin
	-- test each record -- has job been added?
	for rec in emp_crs loop
		if cntr = 0 or c1_tab(cntr).job != rec.job then
			cntr := cntr +1;
			c1_tab(cntr) := rec;
		end if;
	end loop;
	-- now insert chosen records
	for i in 1..cntr loop
		insert into bonus (ename, job, sal, comm) values (c1_tab(i).ename, c1_tab(i).job, c1_tab(i).sal, c1_tab(i).comm);
	end loop;
end;
/
