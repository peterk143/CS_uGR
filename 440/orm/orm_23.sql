-- orm 23
-- nested tables
-- inserting a new record 

insert into department (deptno, dname, loc, employees)
values
(10, 'RESEARCH', 'DALLAS', worker_nt(
					worker_ty(1234, 'KING', 'PRESIDENT', null, to_date('01-Jan-1981','dd-Mon-yyyy'), 1000, null),
					worker_ty(6789, 'QUEEN', 'VP', null, '1-Feb-1982', 1200, null)
					)
)
/
