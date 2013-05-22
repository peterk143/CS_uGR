declare
	peterk Person_ty := Person_ty('PeterKirkpatrick', '123456789', Address_ty('123-123-1234', 'sumWhur', 'rightHur', 'WV', '25621'), '34508954', password_ty('pimpin'));
	--mordecai Person_ty := Person_ty('Mordecai', null, Address_ty(null, null, null, 'WV', null), null, Password_ty('dude'));
begin
	--peterk.setPassword('p@$2wErds4dAz3');
	--mordecai.setPassword('doucheFag');
	--peterk.setPassword('hangOver');

	insert into Personnel values(peterk);
	--insert into Personnel values(mordecai);
	
	dbms_output.put_line(peterk.name);
	change_password('123456789', 'newPassword');
	dbms_output.put_line('passwrd: ' || peterk.getPassword);
end;
/