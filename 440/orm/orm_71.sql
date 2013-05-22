create table mycommittee (
	commNo number(1),
	committeeName varchar2(30), 
	emps emp_object_refs)
	nested table emps 
	store as committee_emp_refs_table;
/
begin
	insert into mycommittee values (1,'Scholarship', emp_object_refs());
	insert into table(select emps from mycommittee where commno = 1) select ref(c) from emp_object_table c where empno in (7369,7499,7521, 7566);
	insert into mycommittee values (2, 'Recruitment', emp_object_refs());
	insert into table(select emps from mycommittee where commno = 2) select ref(c) from emp_object_table c where empno in (7844, 7876, 7900, 7902, 7934);
	insert into mycommittee values (3,'Ethics', emp_object_refs());
	insert into table(select emps from mycommittee where commno = 3) select ref(c) from emp_object_table c where empno in (7654, 7698, 7782,7788);
end;
/


