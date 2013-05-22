-- orm 31
-- deleting a record from a nested table
--
delete table(select employees 
		from department 
		where deptno = 10) 
where upper(ename) = 'BUSH'
/
