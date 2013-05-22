-- plsql 10
-- directly accessing Oracle errors

begin
	insert into emp (empno, ename, sal) values (1234, 'Joe', 1000000);
exception
	when others then 
		if SQLCODE = -1438  then
			dbms_output.put_line(SQLERRM);
		else
			raise;
		end if;
end;
/
