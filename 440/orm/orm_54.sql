-- orm 54
-- creating an OID based on a primary key
--
create or replace view dept_ov of dept_ty
with object identifier(deptno) as
select deptno, dname, loc
from dept
/
