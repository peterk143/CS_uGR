-- orm 33
-- creating an index on hidden column
-- nested_table_id
-- essentially a fk


create index employees_nt_tab_ndx
on employees_nt_tab (nested_table_id)
/