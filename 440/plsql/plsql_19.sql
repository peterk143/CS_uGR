-- plsql 19
-- row level before trigger

create or replace trigger r_before_emp
before insert
on emp
for each row
when (upper(new.job) like 'SALE%')
-- plsql
begin
	:new.comm := 0;
end r_before_emp;
/
