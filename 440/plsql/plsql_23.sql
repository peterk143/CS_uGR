-- plsql 25
-- row level trigger demonstrating deferral of constraints with statement level trigger

create or replace trigger r_update_dept
after update of deptno on emp
for each row
begin 
	update emp 
	set deptno = :new.deptno
	where deptno = :old.deptno;
end;
