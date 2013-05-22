-- orm 57
-- accessing using the underlying primary key
--
select deref(deptno).dname, ename, job from v_emp
/
