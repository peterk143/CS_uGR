declare
   workers varchar2(1000);
   cnt number;
begin
   for x in (select * from dept) loop
       workers := 'insert into department (deptno, dname, loc, employees) values ('||x.deptno||','''||x.dname||''','''||x.loc||''',';
       select count(*) into cnt from emp where deptno = x.deptno;
       if cnt > 0 then
       	  workers := workers || 'worker_nt('; 
       	  for y in (select * from emp where deptno = x.deptno) loop
              workers := workers || 'worker_ty('||y.empno||','''||y.ename||''','''||y.job||''','||nvl('null',y.mgr)||','''||y.hiredate||''','||y.sal||','||nvl('null',y.comm)||'),';
       	  end loop;
          workers := substr(workers,0, length(workers) - 1) || '))'; 
       else 
       	    workers := workers || 'null)';     
       end if;
       dbms_output.put_line (workers);
       execute immediate (workers);
   end loop;
end;
/
