-- orm_45
-- updating an object table
--
update worker
set sal = 4000
where upper(ename) = 'SCOTT'
/
