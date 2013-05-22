-- orm 5
-- overlaying an orm view 
-- on a relational table
-- effectively acts as an orm table
create or replace view emp_ov
	(empno, emp_info, deptno)
as
select empno, emp_ty(ename, job, mgr, hiredate, sal, comm), deptno
from emp;
