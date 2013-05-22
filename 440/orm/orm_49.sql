-- orm 49
-- we can use the OID
-- as an attribute in a table
--
create table committee
(committee_name varchar2(10),
chair ref worker_ty_2)
/
