-- orm 9
-- instead of trigger

create or replace trigger r_instead_company
instead of update
on company
for each row  -- this line is optional
-- plsql
begin
	update emp set deptno = :new.deptno
	where deptno = :old.deptno;
	update dept set deptno = :new.deptno
	where deptno = :old.deptno;
end r_instead_company;
/
