-- orm 51
-- deref function
-- given an OID how to look up its values
--
select committee_name,
deref(chair).ename
from committee
/
