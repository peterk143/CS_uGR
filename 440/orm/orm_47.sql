-- orm 47
-- object tables
-- another example of adding a field constraint
--
alter table worker
 modify deptno constraint worker_deptno_fk references dept(deptno)
 deferrable initially immediate
/
