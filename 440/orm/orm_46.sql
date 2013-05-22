-- orm 46
-- object table 
-- adding constraints
--
alter table worker
add constraint worker_pk
primary key (empno)
deferrable initially immediate
/
