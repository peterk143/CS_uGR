-- orm 56
-- the make_ref function
--
create or replace view v_emp as
select empno, ename, job, mgr, sal, comm, make_ref(dept_ov, deptno) deptno from emp
/
