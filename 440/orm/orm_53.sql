-- orm 53
-- an object view
--	
create or replace type dept_ty as object(
deptno number(2),
dname varchar2(14),
loc varchar2(13));
/
