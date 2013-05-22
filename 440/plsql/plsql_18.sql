-- plsql 18 
-- triggers

create or replace trigger s_after_emp
after insert or update of job, sal or delete
on emp
-- declarations if any
begin
	for emp_rec in (select job, sum(sal) total from emp group by job) loop
		update job_sal set salary = emp_rec.total where job = emp_rec.job;

		-- does the job value exist:
		-- Check to see if job value exists in job_sal
		-- If not, create a new job value in job_sal
		-- use the builtin cursor sql

		if sql%NotFound then
			-- add job to table job_sal
			insert into job_sal(job, salary) values
				(emp_rec.job, emp_rec.total);
		end if;
	end loop;

	-- Was the event a delete or an update?
	if deleting or updating then
		delete job_sal where job not in (select job from emp);
	end if;
end s_after_emp;
/
