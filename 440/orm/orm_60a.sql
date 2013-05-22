-- orm60a
-- Creating a subtype 
-- We need to reconfigure our parent object


drop table committee;
drop table worker;
drop type worker_ty_3;
drop type worker_ty_2;

create or replace type worker_ty_2 as object(
       empno number(4),
       ename varchar2(10),
       job varchar2(9),
       mgr number(4),
       hiredate date,
       sal number(7,2),
       comm number(7,2),
       deptno number(2)
-- we must explicitly allow this object to be subclassed
) not final;
/

@@orm_41
@@orm_42


create or replace type worker_ty_3 under worker_ty_2 (
Nickname varchar2(20))
/
