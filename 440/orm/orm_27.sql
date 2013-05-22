-- orm 27
-- getting the size of a nested table
-- if none created, this will return null

select dname, cardinality(employees) from department
/
