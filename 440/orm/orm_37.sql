begin
	execute immediate 'truncate table department';
end;
/
	
@@orm_35
	
begin
	for rec in (select deptno from department) loop
		insert into table(select employees
					from department
					where deptno = rec.deptno)
		select empno, ename, job, mgr, hiredate, sal, comm from emp
					where deptno = rec.deptno;
	end loop;
end;
/
