-- plsql 21b
-- mutating table example
-- storing information row level

create or replace trigger r_after_emp
after insert
on emp
for each row
when (upper (new.job) like 'SALE%')
-- plsql
begin
	trig.emp_tab(trig.emp_tab.count+1).empno := :new.empno;
end r_after_emp;
/
