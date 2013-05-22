create or replace package GreenAcres as
	Improper_location exception;
	pragma exception_init(Improper_location, -1234);
	
	Illegal_Update exception;
	pragma exception_init(Illegal_Update, -1235);	
	
	Password_change_failure exception;
	pragma exception_init(Password_change_failure, -1236);

	Too_many_animals exception;
	pragma exception_init(Too_many_animals, -1237);

	procedure Change_Password(p_ssn char, P_newPW varchar2);
	procedure AssignManager(P_id number, p_ssn varchar2);
	function CheckPassword(p_ssn char, p_pw varchar2) return number;
end GreenAcres;
/