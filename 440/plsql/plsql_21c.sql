-- plsql 21c
-- mutating table error
-- after statement
create or replace trigger s_after_emp
after insert
on emp
-- plsql
begin
	for cntr in 1..trig.emp_tab.count loop
		update emp set comm = 0
			where empno = trig.emp_tab(cntr).empno;
	end loop;
	-- now lets clean out the associative array
	trig.emp_tab.delete;
-- what if we get some weird error?
exception
	when others then
		trig.emp_tab.delete;
	raise;
end;
/
