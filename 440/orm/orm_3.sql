-- orm 3
-- object constructors
--
insert into employee
(empno, emp_info, deptno)
select empno, emp_ty(ename, job, mgr, hiredate, sal, comm), deptno
from emp
/
