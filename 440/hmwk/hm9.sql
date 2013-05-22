/*
	Peter Kirkpatrick [pkirkpat]
	April 16, 2012
	CS 440
*/
--set serveroutput on format wrapped

set echo on

drop table dept;
drop table classes;
drop table student;
drop type student_ty;
drop type classes_va;

--Problem 1
create or replace type classes_va as varray(7) of number;
/
--Problem 2
create or replace type student_ty as object(
	student_name varchar2(20),
	major varchar2(25),
	advisor varchar2(20),
	enrolled_va classes_va,
	member function classCount
		return number);
/
--Problem 3
create table dept(dept_code varchar2(7) constraint dept_code_pk primary key deferrable initially immediate,
	dept_name varchar2(25) constraint dept_name_nn not null deferrable initially immediate);
insert into dept(dept_code, dept_name) values('CS', 'Computer Science');
insert into dept(dept_code, dept_name) values('CpE', 'Computer Engineering');
insert into dept(dept_code, dept_name) values('EE', 'Electrical Engineering');
insert into dept(dept_code, dept_name) values('BIOM', 'Biometrics');
insert into dept(dept_code, dept_name) values('SENG', 'Safety Engineering');
insert into dept(dept_code, dept_name) values('MATH', 'Mathematics');
insert into dept(dept_code, dept_name) values('STAT', 'Statistics');
insert into dept(dept_code, dept_name) values('PHYSICS', 'Physics');
insert into dept(dept_code, dept_name) values('CHEM', 'Chemistry');
/
--Problem 4
create table classes(crn number constraint crn_pk primary key deferrable initially immediate,
	department varchar2(25),
	course_name varchar2(25));
insert into classes(crn, department, course_name) values(12345, 'Math', 'Topology');
insert into classes(crn, department, course_name) values(45673, 'Math', 'Linear Algebra');
insert into classes(crn, department, course_name) values(45312, 'Math', 'Calculus 1');
insert into classes(crn, department, course_name) values(45313, 'Math', 'Calculus 2');
insert into classes(crn, department, course_name) values(45314, 'Math', 'Calculus 3');
insert into classes(crn, department, course_name) values(45315, 'Math', 'Calculus 4');
insert into classes(crn, department, course_name) values(31245, 'CS', 'Data Structures');
insert into classes(crn, department, course_name) values(34128, 'CS', 'Databases');
insert into classes(crn, department, course_name) values(34228, 'CS', 'Java Programming');
insert into classes(crn, department, course_name) values(34129, 'CS', 'Normalization Theory');
/
--Problem 5
create table student(student_id varchar2(12) constraint student_id_pk primary key deferrable initially immediate,
	student_info student_ty);
/
drop table student;
--Problem 6
/*
declare
	no_valid_major exception;
begin
if student.student_info.major is null then
	raise no_valid_major;
else
	create table student(student_id varchar2(12) constraint student_id_pk primary key deferrable initially immediate,
		student_info student_ty);
end if;
exception
	when no_valid_major then
		dbms_output.put_line('somebodys major is null');
		rollback;
end;
/
*/
--Problem 7
/*
insert into student(student_id, student_info) values(
	'700-123-908', student_ty('Jones', 'MATH', 'VanScoy', 45673, 34228, 45315));
insert into student(student_id, student_info) values(
	'700-123-911', student_info('Smith', 'CS', 'Cukic', 45312, 45315));
insert into student(student_id, student_info) values(
	'700-123-912', student_info('Adams', 'BIOM', 'VanScoy'));
insert into student(student_id, student_info) values(
	'700-123-913', student_info('Grant', 'STAT', 'Graham', 34128));
insert into student(student_id, student_info) values(
	'700-123-918', student_info('Sherman', 'CS', 'Ross', 34128, 34129, 34228));
insert into student(student_id, student_info) values(
	'700-123-928', student_info('Hood', 'CS', 'VanScoy', 45673));
insert into student(student_id, student_info) values(
	'700-123-938', student_info('Lee', 'SENG', 'Menzies', 45673, 34228));
insert into student(student_id, student_info) values(
	'700-123-948', student_info('Hooker', 'CS', 'VanScoy', 45673, 34228, 45315, 34129));
/
*/
