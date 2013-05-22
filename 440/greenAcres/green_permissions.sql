--types--
grant execute on Person_ty to tester;
grant execute on Address_ty to tester;
grant execute on Password_ty to tester;
grant execute on Animal_info_ty to tester;
grant execute on GreenAcres to tester;

--tables--
grant select, update, delete, insert on Farm to tester;
grant select, update, delete, insert on Crop_Info to tester;
grant select, update, delete, insert on Plot to tester;
grant select, update, delete, insert on Farm_animal_Info to tester;
grant select, update, delete, insert on Farm_Equipement to tester;
grant select, update, delete, insert on Crop_Allocation to tester;
grant select, update, delete, insert on Animal_Inventory to tester;
grant select, update, delete, insert on Personnel to tester;

