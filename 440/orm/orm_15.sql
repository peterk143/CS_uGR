-- orm 15
-- inserting a record into an object-relational table with a varying array as a component of the object

insert into employee (empno, emp_info, deptno)
values (1234, emp_ty('Gore','Salesman',7782, '1-Jan-82', 1500, null, proj_va('Task 1', 'Task 2')), 10);
/
