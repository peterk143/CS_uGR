begin
	execute immediate 'set constraint employees_mgr_fk deferred';


	for rec in (select * from emp) loop
		insert into
			table(select employees
				from department
				where deptno = rec.deptno)
		values
			(worker_ty(rec.empno, rec.ename, rec.job, rec.mgr, rec.hiredate, rec.sal, rec.comm));
	end loop;

	execute immediate 'set constraint employees_mgr_fk immediate';
end;
/
