-- orm 50
-- insert some values using an OID
--
insert into committee (committee_name, chair)
select 'Safety', ref(w)
from worker w
where upper(ename) = 'SMITH'
/
