/*
	Peter Kirkpatrick [pkirkpat]
	April 16, 2012
	CS 440
*/
--set serveroutput on format wrapped

set echo on

drop type student_ty;
drop type classes_va;
drop table student_plus;
drop type classes_ref_ty;
drop table classes;
drop table classes_ot;
drop type classes_ty;

--Problem 1
create or replace type classes_ty as object(
	crn varchar2(5),
	department varchar2(8),
	courseTitle varchar2(25));
/
--Problem 2
create table classes_ot of classes_ty;
--Problem 3
create table classes(crn varchar2(5) constraint crn_pk primary key deferrable initially immediate,
	department varchar2(8),
	courseTitle varchar2(25));
insert into classes(crn, department, courseTitle) values('12345', 'Math', 'Topology');
insert into classes(crn, department, courseTitle) values('45673', 'Math', 'Linear Algebra');
insert into classes(crn, department, courseTitle) values('45312', 'Math', 'Calculus 1');
insert into classes(crn, department, courseTitle) values('45313', 'Math', 'Calculus 2');
insert into classes(crn, department, courseTitle) values('45314', 'Math', 'Calculus 3');
insert into classes(crn, department, courseTitle) values('45315', 'Math', 'Calculus 4');
insert into classes(crn, department, courseTitle) values('31245', 'CS', 'Data Structures');
insert into classes(crn, department, courseTitle) values('34128', 'CS', 'Databases');
insert into classes(crn, department, courseTitle) values('34228', 'CS', 'Java Programming');
insert into classes(crn, department, courseTitle) values('34129', 'CS', 'Normalization Theory');

insert into classes_ot(select * from classes);

--Problem 4 [not done]
create or replace type classes_ref_ty
	as table of ref classes_ty;
/
--Problem 5
create table student_plus(student# varchar2(11) constraint student#_pk primary key deferrable initially immediate,
	student_name varchar2(10) constraint student_name_nn not null,
	major varchar2(8) constraint major_nn not null,
	advisor varchar2(10),
	enrolled classes_ref_ty)
nested table enrolled store as enrolled_nt_tab;
--Problem 6
create or replace type classes_va as varray(7) of number;
create or replace type student_ty as object(
	student_name varchar2(20),
	major varchar2(25),
	advisor varchar2(20),
	enrolled_va classes_va,
	member function classCount
		return number);
/
create table student(student_id varchar2(12) constraint student_id_pk primary key deferrable initially immediate,
	student_info student_ty);
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
insert into student(student#, student_info) values(
	'700-123-938', student_info('Lee', 'SENG', 'Menzies', 45673, 34228));
insert into student(student#, student_info) values(
	'700-123-948', student_info('Hooker', 'CS', 'VanScoy', 45673, 34228, 45315, 34129));
/
insert into student_plus(select * from student);
--Problem 7
--Problem 8
