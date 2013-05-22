-- orm 6
-- how to create constraints in object relational tables

alter table employee
add constraint ename_uq
unique(emp_info.ename)
deferrable initially immediate
add constraint ename_chk
check (emp_info.ename is not null)
deferrable initially immediate
/
