create or replace package body GreenAcres as
	--functions--
	function CheckPassword(p_ssn char, p_pw varchar2) return number is
		person Person_ty := null;
	begin
		dbms_output.put_line('CheckPassword function');
		select value(p) into person from Personnel p
			where p_ssn = ssn;
		if person.getPassword = p_pw then
			return 1;
		elsif person.getPassword != p_pw then
			return 0;
		elsif p_ssn is null then 
			return 0;
	end CheckPassword;
	--procedures--
	procedure Change_Password(p_ssn char, P_newPW varchar2) is
		person Person_ty := null;
	begin
		dbms_output.put_line('Change_Password');

		select value(p) into person from Personnel p
			where p_ssn = ssn;
	
		person.setPassword(P_newPW);
		dbms_output.put_line(person.getPassword);
	end Change_Password;

	procedure AssignManager(P_id number, p_ssn varchar2) is
	begin
		dbms_output.put_line('AssignManager');
		--assign manager to farm
	end AssignManager;
end;
/