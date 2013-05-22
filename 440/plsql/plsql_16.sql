-- plsql 16
-- associative array example
-- with attributes
declare
	-- cursor of all emp records
	cursor emp_crs is
		select ename, job, sal, comm
		from emp
		order by job, sal desc;
	--
	-- associative array type -- we need to change the index (key)
		-- type c1_type is table of emp_crs%rowtype index by binary_integer;
	type c1_type is table of emp_crs%rowtype index by bonus.job%type;
	--
	-- associative array of chosen records from emp_crs
	c1_tab c1_type;
	--
	-- cntr is out
		--cntr integer := 0;
	-- instead an associative array key
	ndx 	bonus.job%type;
begin
	-- revised loop
	for rec in emp_crs loop
		--	if cntr = 0 or c1_tab(cntr).job != rec.job then
		--		cntr := cntr +1;
		--		c1_tab(cntr) := rec;
		--	end if;
		if not c1_tab.exists(rec.job) then
			c1_tab(rec.job) := rec;
		end if;
	end loop;
	--
	-- set index to first key in c1_tab
	ndx := c1_tab.first;
	--
	-- we need to test for empty associative array because of loop (see below)
	if ndx is null then
		return;
	end if;
	--	
	-- revised loop
		--for ndx in 1..cntr loop
	loop
		insert into bonus (ename, job, sal, comm) values (c1_tab(ndx).ename, c1_tab(ndx).job, c1_tab(ndx).sal, c1_tab(ndx).comm);
		exit when ndx = c1_tab.last;
		ndx := c1_tab.next(ndx);
	end loop;
end;
/
