create or replace trigger cascade_update
after update of c1 on t1
  for each row
begin
	dbms_output.put_line( 'setting ' || :old.c1 || ' to ' || :new.c1 );
	update t2 set c2 = :new.c1  where c2 = :old.c1;
end;
/