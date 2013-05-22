-- orm 34
-- adding constraints to a nested table
-- cannot modify fields or create null constraint
--

alter table employees_nt_tab
add constraint employees_empno_pk primary key (empno) deferrable initially immediate
add constraint employees_empno_nn check (empno is not null) deferrable initially immediate
add constraint employees_mgr_fk foreign key (mgr) references employees_nt_tab (empno) deferrable initially immediate
/
