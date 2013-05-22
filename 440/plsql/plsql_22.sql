-- plSQL_22
--   Compound Trigger Example
--   New in Oracle 11g
--   Extremely useful for dealing with mutating triggers


CREATE OR REPLACE TRIGGER compound_example_trigger
  FOR insert 
  -- OR delete OR update [on fields]
  ON emp
  COMPOUND TRIGGER

  -- Global declaration.
  type emp_ty is table of emp%rowtype index by binary_integer;
  emp_tab emp_ty;

  BEFORE STATEMENT IS
  BEGIN
	NULL; -- Do something here.
  END BEFORE STATEMENT;

  BEFORE EACH ROW IS
  BEGIN
    NULL; -- Do something here.
  END BEFORE EACH ROW;

  AFTER EACH ROW IS
  BEGIN
    emp_tab(emp_tab.count+1).empno := :new.empno;
  END AFTER EACH ROW;

  AFTER STATEMENT IS
  BEGIN
	for cntr in 1..emp_tab.count loop
	    update emp set comm = 0
	    	   where empno = emp_tab(cntr).empno;
	end loop;
	-- now lets clean out the associative array
	emp_tab.delete;
  -- what if we get some weird error?
  exception
	when others then
		emp_tab.delete;
	raise;
  END AFTER STATEMENT;

END compound_example_trigger;
/