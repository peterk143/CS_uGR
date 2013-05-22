
update e set sal = ( mod (empno + 2, 4)+1 )*1000;
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
