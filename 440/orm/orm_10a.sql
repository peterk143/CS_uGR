-- orm 10a
-- member function specification
-- we cannot change an object referenced in a table
-- we can however use the alter object syntax

alter type emp_ty 
REPLACE 
as object
(ename varchar2(10),
job varchar2(9),
mgr number(4),
hiredate date,
sal number(7,2),
comm number(7,2),
member function years_of_service (hired_date date)
	return number
);
/




