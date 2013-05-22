begin
	insert into mydept select deptno, dname, loc, emp_object_refs() from dept;
	for k in (select deptno from mydept) loop
		insert into table(select emps from mydept where deptno = k.deptno) select ref(c) from emp_object_table c where deptno = k.deptno;
	end loop;
end;
/
