-- orm 21
-- how to create a nested table of type worker_nt

create or replace type worker_nt
as table of worker_ty;
/
