-- trx 2
-- transactions and automaticity


create or replace procedure p_trx
as
begin
	insert into t values(1);
	insert into t values(-1);
end;
/
