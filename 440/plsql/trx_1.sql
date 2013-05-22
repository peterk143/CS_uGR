-- trx_1
-- triggers and atomaticity

drop table t2;
create table t2 ( cnt int );

insert into t2 values ( 0 );

drop table t;
create table t ( x int check ( x>0 ) );

create trigger t_trigger
before insert or delete on t 
for each row
begin
	if ( inserting ) then
  		update t2 set cnt = cnt + 1;
 	else
  		update t2 set cnt = cnt - 1;
	end if;
  	dbms_output.put_line('I fired and updated ' ||
          	sql%rowcount || ' rows');
end;
/