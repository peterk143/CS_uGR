/*
	Peter Kirkpatrick [pkirkpat]
	March 5, 2012
	CS 440
*/
--set serveroutput on format wrapped

create or replace procedure Salary_Report is
	v_date varchar2(40) := to_char(SYSDATE, 'DAY, MONTH DD, YYYY');
	v_money_f varchar2(17) := 'FML99,999,999.00';

	v_dept_acc number := 0;
	v_dept_avg number := 0;
	v_co_acc number := 0;
	v_co_avg number := 0;
begin
	-- header
	dbms_output.put_line(lpad(v_date, 32));
	dbms_output.put_line(null);
	dbms_output.put_line(lpad('Regal Lager', 22));
	dbms_output.put_line('More than a Great Brew - A Palindrome');
	dbms_output.put_line(null);
	dbms_output.put_line(lpad('Departmental Salary Report', 30));
	dbms_output.put_line(null);

	-- main loop structure
	for c2_rec in (select deptno, dname from dept) loop
		dbms_output.put_line('DEPARTMENT:  ' || c2_rec.dname);

		for c1_rec in (select ename, sal, deptno from emp) loop
			if c1_rec.deptno = c2_rec.deptno then
				dbms_output.put_line(lpad(c1_rec.ename, 10)|| lpad(to_char(c1_rec.sal, v_money_f), 15));
			end if;
		end loop;

		select sum(emp.sal) into v_dept_acc from emp where emp.deptno = c2_rec.deptno;
		dbms_output.put_line('Total '|| c2_rec.dname ||' Salary:'|| lpad(to_char(v_dept_acc, v_money_f), 15));
		select avg(emp.sal) into v_dept_avg from emp where emp.deptno = c2_rec.deptno;
		dbms_output.put_line('Average '|| c2_rec.dname ||' Salary:'|| lpad(to_char(v_dept_avg, v_money_f), 13));
		dbms_output.put_line(null);
	end loop;
	
	select sum(emp.sal) into v_co_acc from emp;
	dbms_output.put_line('Total Regal Lager Salary:'|| lpad(to_char(v_co_acc, v_money_f), 15));
	select avg(emp.sal) into v_co_avg from emp;	
	dbms_output.put_line('Average Regal Lager Salary:'|| lpad(to_char(v_co_avg, v_money_f), 13));
	dbms_output.put_line(null);
	dbms_output.put_line(lpad('End of Report', 22));
end Salary_Report;
/