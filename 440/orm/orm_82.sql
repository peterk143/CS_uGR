insert into table(select students from table(select faculty from school where department_name = 'CSEE') where name = 'Tanner') (name, student_id, major) values ('Jackson',7445, 'EE');