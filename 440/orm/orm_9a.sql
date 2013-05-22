create or replace procedure alter_company_deptno(p_old IN number, p_new IN number) 
as
begin
    execute immediate('set constraint deptno_fk deferred');
    update company set deptno = p_new where deptno = p_old;
    execute immediate('set constraint deptno_fk immediate');
end alter_company_deptno;
/