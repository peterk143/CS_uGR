drop table employee;
drop view emp_ov;
drop type emp_ty;
drop type proj_va;
drop table department;
drop view company;
drop type worker_nt;
drop type worker_ty;

drop index emp_inx;
@@sup_part1
@@utlsampl
purge recyclebin;
--1.	Alter the dept table to have the following deferrable (initially immediate) 	constraints:
--
--	a.	deptno is the primary key
--
--	a.	dname is unique and not null
alter table dept
modify deptno constraint dept_pk primary key deferrable initially immediate
modify dname constraint dept_uq unique deferrable initially immediate constraint dept_nn not null  deferrable initially immediate ;
--2.	Alter the emp table to have the following deferrable (initially immediate) 	constraints:
--
--	a.	empno is the primary key
--
--	b.	ename is unique and not null
--
--	c.	mgr references the empno attribute in the table emp
--
--	d.	deptno references the deptno attribute in the table dept
--
--	e.	the sal attribute value should lie in the interval 500 to 10000
alter table emp
add constraint emp_pk primary key(empno) deferrable initially immediate
modify ename constraint emp_ename_uq unique deferrable initially immediate constraint emp_ename_nn not null deferrable initially immediate
modify mgr constraint mgr_fk references emp(empno) deferrable initially immediate
modify deptno constraint deptno_fk references dept(deptno) deferrable initially immediate
modify sal constraint sal_chk check (sal between 500 and 10000)  deferrable initially immediate;
--3.	Alter the table s to have the following deferrable (initially immediate) 	constraints:
--
--	a.	s# is the primary key
--
--	b.	sname is unique and not null
--
alter table s
modify s# constraint s_pk primary key deferrable initially immediate
modify sname constraint s_uq unique deferrable initially immediate constraint s_nn not null deferrable initially immediate;
--4.	Alter the table p to have the following deferrable (initially immediate) 	constraints:
--
--	a.	p# is the primary key
--
--	b.	pname is unique and not null
--
alter table p
modify p# constraint p_pk primary key deferrable initially immediate
modify pname constraint p_uq unique deferrable initially immediate constraint p_nn not null deferrable initially immediate;
--5.	Alter the table sp to have the following deferrable (initially immediate) 	constraints:
--
--	a.	the pair s# and p# is the primary key
--
--	b.	qty is either null or non-negative
--
--	c.	s# references the s# attribute of the table s and p# references the p# 			attribute of the	p table.
--
alter table sp
add constraint sp_pk primary key (s#, p#) deferrable initially immediate
modify qty constraint qty_chk check ( qty is not null or qty > 0)  deferrable initially immediate
modify s# constraint sp_s_fk references s(s#) deferrable initially immediate 
modify p# constraint sp_p_fk references p(p#) deferrable initially immediate;
--
--6.	Create an index on the deptno attribute of emp
--
create index emp_inx on emp(deptno);
--7.	Two hiredate values in the emp table are incorrect; identify the difficulty and 	correct it. You might want to use the add_months function with the prototype:
--
--		add_months(date, #months)
--
--	where the #months value can be either positive or negative.
--
--	Commit your results.
--
update emp set hiredate = add_months(hiredate, -60) where hiredate > '1-Jan-86';
commit;
--8.	List all indexes with table name and index name.
--
select index_name from user_indexes;
--9.	List all constraints with table name and constraint name.
select constraint_name from user_constraints;
@@orm_1
@@orm_2
@@orm_3
@@orm_5