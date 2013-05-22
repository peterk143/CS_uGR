-- orm_76
-- create a new nested table type of empno's

create or replace type empno_nt as table of number(4);
/