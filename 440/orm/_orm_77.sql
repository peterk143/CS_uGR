-- orm_77
-- now we can turn the information from our emp_object_table into a nested table suitable for comparison

select cast(collect(empno) as empno_nt) from emp_object_table;
/