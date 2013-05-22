--object_types--
create or replace type Animal_info_ty as object(animal varchar2(50),
	animal_id number,
	required_acreage number constraint required_acreage_fk references Farm_animal_Info(required_acreage_per_animal)) --number from farm_animal_info
/
create or replace type Address_ty as object(phone varchar2(15),
	street varchar2(20),
	city varchar2(20),
	state char(2),
	zip varchar2(10))
/
create or replace type Password_ty as varray(5) of varchar2(20)
/
create or replace type Person_ty as object(name varchar2(20),
	ssn char(9),
	address Address_ty,
	web_id varchar2(12),
	passwords Password_ty,
	map member function getPassword return varchar2,
	member procedure setPassword(new_passwd varchar2))
/
create or replace type body Person_ty as
	map member function getPassword return varchar2 is
	begin
		return passwords(passwords.last);
	end getPassword;	
	member procedure setPassword(new_passwd varchar2) is
		ndx number := passwords.count;
	begin	--LAST 5:: NOT SETS OF 5 AT A TIME
		if length(new_passwd) <= 20 then
			dbms_output.put_line('count ' || passwords.count || passwords(passwords.count));
			dbms_output.put_line('limit ' || passwords.limit);
			if passwords.count = passwords.limit then
				while passwords.count >1 loop
					passwords.trim;
				end loop;

				dbms_output.put_line('lastCount ' || passwords.count || passwords(passwords.last));
				passwords(passwords.count) := new_passwd;		
				dbms_output.put_line('lastCount ' || passwords.count || passwords(passwords.last));
			elsif passwords.count < passwords.limit then
				passwords.extend;
				passwords(passwords.count) := new_passwd;
				dbms_output.put_line('newCount ' || passwords.count || passwords(passwords.count));
				dbms_output.put_line('newLimit ' || passwords.limit);
			end if;
		end if;	
		dbms_output.put_line('hell yea');
	end setPassword;
end;
/