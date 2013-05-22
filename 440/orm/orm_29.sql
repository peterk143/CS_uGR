-- orm 29
-- inserting into a preexisting nested table

insert into table (select employees 
			from department 
			where deptno = 10)
values
	(worker_ty(1114, 'Bush', 'Sales', null, to_date('01-Jan-1981','dd-Mon-yyyy'), 1000, null))

/