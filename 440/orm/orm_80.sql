-- orm 80
-- nested table of nested tables


drop table school;
drop type advisor_nt;
drop type advisor_ty;
drop type student_nt;
drop type student_ty;

create or replace type student_ty as object(
name varchar2(20),
student_id number(4),
major varchar2(20))
/
create or replace type student_nt as table of student_ty
/
create or replace type advisor_ty as object(
name varchar2(20),
ssn number(9),
department varchar2(30),
students student_nt)
/
create or replace type advisor_nt as table of advisor_ty
/
create table school (
department_id number(3),
department_name varchar2(30),
faculty advisor_nt)
nested table faculty 
store as faculty_nt_tab
(nested table students
store as students_nt_tab)
/