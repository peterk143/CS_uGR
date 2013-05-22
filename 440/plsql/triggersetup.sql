drop table t2;
drop table t1;

create  table t1(
c1 number primary key deferrable initially deferred);

create table t2(
c1 number primary key deferrable initially deferred, 
c2 number references t1(c1));


insert into t1 values(2);
insert into t1 values(1);
insert into t2 values(100, 1);
insert into t2 values(101, 2);