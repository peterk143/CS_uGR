-- orm 30
-- how to update a component of a nested table

update table(select employees
		from department
		where deptno = 10)
set job = 'Analyst'
where upper(ename) = 'BUSH'
/
