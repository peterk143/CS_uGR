--table_joints--
create table Farm(id number(3) constraint farm_id_pk primary key,
	name varchar2(250),
	latitude number constraint latitude_ck check (30 < latitude AND latitude < 50),
	longitude number constraint longitude_ck check (70 < longitude AND longitude < 90),
	manager ref Person_ty constraint ref_person_ty references Personnel)
/
create table Crop_Info(crop_name varchar2(50) constraint crop_name_pk primary key,
	planned_bushel_per_acre number,
	kcal_per_bushel number,
	estimated_cost_to_plant_acre number(8,2),
	estimated_sales_value_per_acre number(8,2))
/
create table Plot(id char(8) constraint plot_id_pk primary key,
	farm_id number(3) constraint farm_id_fk references Farm(id),
	acreage number constraint acreage_ck check (acreage > 0),
	crop varchar2(50) constraint plot_crop_fk references Crop_Info(crop_name));
alter table Plot modify acreage constraint acreage_nn not null
/
create table Farm_animal_Info(animal_name varchar2(50) constraint animal_name_pk primary key,
	required_acreage_per_animal number constraint required_acreage_nn not null,
	estimated_year_end_sales_value number(8,2) constraint estimated_sales_nn not null,
	estimated_cost number(8,2) constraint estimated_cost_nn not null);
alter table Farm_animal_Info modify animal_name constraint animal_name_nn not null
/
create table Farm_Equipement(serial_num char(6) constraint serial_num_pk primary key,
	brand varchar2(40),
	type varchar2(50),
	description varchar2(400),
	current_plot char(8) constraint current_plot_fk references Plot(id))
/
create table Crop_Allocation(plot char(8) constraint crop_plot_fk references Plot(id),
	crop varchar2(50) constraint crop_allocation_fk references Crop_Info(crop_name),
	bushels number,  -- may not exceed capacity of plot
	constraint plot_crop_pk primary key (plot, crop))
/
create table Animal_Inventory(animal_id number(8) constraint animal_id_pk primary key,
	animal varchar2(50) constraint animal_fk references Farm_animal_Info(animal_name))
/
create table Personnel of Person_ty;
alter table Personnel add constraint person_ssn_pk primary key(ssn);
alter table Personnel add constraint web_id_uq unique(web_id)
/