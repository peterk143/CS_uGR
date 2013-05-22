drop table e;

create table e (empno number , sal number);

begin
for x in 1..4 loop
insert into e values (x, x*1000);
end loop;
end;
/

select * from e;

declare
	l_sal     number;
        l_avg_sal number;
begin
        for x in ( select * from e )loop
            update e
               set sal = sal * 2
               where empno = x.empno
               returning sal into l_sal;
 
	select avg(sal)
            into l_avg_sal
            from e;
 
        dbms_output.put_line( 'Empno = ' || x.empno || ' old sal = ' || x.sal || ' new sal = ' || l_sal || ' avg_sal = ' || l_avg_sal );
        
	if ( l_sal/2 > l_avg_sal ) then
           raise_application_error( -20000, 'Error' );
        end if;
   end loop;
end;
/
