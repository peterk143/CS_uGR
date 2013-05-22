-- plsql 20
-- after row level trigger
create or replace trigger r_after_emp
after insert on emp
for each row
when (upper(new.job) like 'SALE%')
-- plsql
begin
	update emp set comm = 0
		where empno = :new.empno;
end r_after_emp;
/
