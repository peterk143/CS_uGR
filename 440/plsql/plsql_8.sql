-- plsql 8
-- nested begin blocks

begin
	for emp_rec in (select ename, job, sal, comm from emp order by job, sal desc) loop
		begin
			insert into bonus ( ename, job, sal, comm) values (emp_rec.ename, emp_rec.job, emp_rec.sal, emp_rec.comm);
		exception
			when dup_val_on_index then
				null;
			when others then raise;
		end;
	end loop;
end;
/
