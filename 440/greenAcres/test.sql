declare
	peterk Person_ty := Person_ty('PeterKirkpatrick', '123456789', Address_ty('123-123-1234', 'sumWhur', 'rightHur', 'WV', '25621'), '34508954', password_ty('pimpin'));
	
begin
	dbms_output.put_line('before passwd ' || peterk.getPassword());
	peterk.setPassword('superSekrt');
	peterk.setPassword('p@$2wErds4dAz3');
	peterk.setPassword('asdfasdf');
	peterk.setPassword('qwerty');
	peterk.setPassword('password');
	peterk.setPassword('cisco');
	peterk.setPassword('asdfasdfasdfasdfasdfasdf');
	peterk.setPassword('iloveyou');
	peterk.setPassword(null);
	peterk.setPassword('');
	peterk.setPassword('admin');
	dbms_output.put_line('is this shit working');
	dbms_output.put_line('dudes passwd ' || peterk.getPassword());
end;
/