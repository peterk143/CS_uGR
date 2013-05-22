-- orm 25
-- another way to select from a nested table

select dname, e.* from department d, table(d.employees) e
/
