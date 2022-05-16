create database furama_resort;
use furama_resort;

create table em_position(
	position_id 	int auto_increment primary key,
    position_name	varchar(45)
);

create table education_degree(
	education_degree_id		int auto_increment primary key,
    education_degree_name	varchar(45)
);

create table division(
	division_id		int auto_increment primary key,
    division_name	varchar(45)
);

create table user(
	username	varchar(255) primary key,
    password	varchar(255)
);

create table role(
	role_id		int auto_increment primary key,
    role_name	varchar(255)
);

create table user_role(
	role_id		int,
    username	varchar(255),
constraint	pk_user_role 	primary key(role_id, username),
foreign key (role_id)		references role(role_id),
foreign key (username)		references user(username)    
);

create table employee(
	employee_id 		int auto_increment primary key,
    employee_name		varchar(45),
    employee_birthday	date,
    employee_id_card	varchar(45),
    employee_salary		double,
    employee_phone		varchar(45),
    employee_email		varchar(45),
    employee_address	varchar(45),
    position_id			int,
    education_degree_id	int,
    division_id			int,
    username			varchar(255),
foreign key(position_id) 		 references em_position(position_id),
foreign key(education_degree_id) references education_degree(education_degree_id),
foreign key(division_id)		 references division(division_id),
foreign key(username)			 references user(username)
);

create table customer_type(
	customer_type_id	int auto_increment primary key,
    customer_type_name	varchar(45)
);

create table customer(
	customer_id			int auto_increment primary key,
    customer_type_id	int,
    customer_name		varchar(45),
    customer_birthday	date,
    customer_gender		boolean,
    customer_id_card	varchar(45),
    customer_phone		varchar(45),
    customer_email		varchar(45),
    customer_address	varchar(45),
foreign key(customer_type_id) references customer_type(customer_type_id)
);

create table service_type(
	service_type_id		int auto_increment primary key,
    service_type_name	varchar(45)
);

create table rent_type(
	rent_type_id	int auto_increment primary key,
    rent_type_name	varchar(45),
    rent_type_cost	double
);

create table service(
	service_id			int auto_increment primary key,
    service_name		varchar(45),
    service_erea		int,
    service_cost		double,
    service_max_people	int,
    rent_type_id		int,
    service_type_id		int,
    standard_room		varchar(45),
    description_other_convinience varchar(45),
    pool_area			double,
    number_of_floors	int,
foreign key(rent_type_id)	 references rent_type(rent_type_id),
foreign key(service_type_id) references service_type(service_type_id)
);

create table contract(
	contract_id			int auto_increment primary key,
    contract_start_date datetime,
    contract_end_date	datetime,
    contract_deposit	double,
    employee_id			int,
    customer_id			int,
    service_id			int,
foreign key(employee_id) references employee(employee_id),
foreign key(customer_id) references customer(customer_id),
foreign key(service_id)	 references service(service_id)
);

create table attach_service(
	attach_service_id		int auto_increment primary key,
    attach_service_name		varchar(45),
    attach_service_cost		double,
    attach_service_unit		int,
    attach_service_status	varchar(45)
);

create table contract_detail(
	contract_detail_id	int auto_increment primary key,
    contract_id			int,
    attach_service_id	int,
    quantity			int,
foreign key(contract_id)		references contract(contract_id),
foreign key(attach_service_id)	references attach_service(attach_service_id)
);
select * from customer;
INSERT INTO `furama_resort`.`customer` (`customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) 
VALUES ('Michael', '1998-02-23', '1','5','112233','Michaeli@gmail.com', 'USA');

insert into `customer`(customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) 
values 	("Michael JackSon", "2000-02-23", 1, 5, 112233, "Michael@gmail.com", "USA"),
		("Han San", "2000-02-23", 1, 5, 112233, "Han@gmail.com", "JP");
	
INSERT INTO `furama_resort`.`user` (`username`, `password`) VALUES ('garen', '1111');
INSERT INTO `furama_resort`.`user` (`username`, `password`) VALUES ('lux', '1111');
INSERT INTO `furama_resort`.`user` (`username`, `password`) VALUES ('darius', '1111');

INSERT INTO `furama_resort`.`employee` (`employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `username`) VALUES ('Garen', '1989-02-23', '1', '50', '1122', 'Garen@gmail.com', 'Demacia', 'garen');
INSERT INTO `furama_resort`.`employee` (`employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `username`) VALUES ('Lux', '1989-02-24', '3', '60', '2211', 'Lux@gmail.com', 'Demacia', 'lux');
INSERT INTO `furama_resort`.`employee` (`employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `username`) VALUES ('Darius', '1989-01-24', '1', '50', '1133', 'Darius@gmail.com', 'Noxus', 'darius');

insert into customer_type(customer_type_name)
values	("Diamond"),
		("Platinum"),
        ("Gold"),
        ("Silver"),
        ("Member");
        
insert into education_degree(education_degree_name)
values	("Trung cấp"),
		("Cao đẳng"),
        ("Đại Học"),
        ("Sau Đại Học");

insert into em_position(position_name)
values	("Lễ Tân"),
		("Phục vụ"),
        ("Chuyên Viên"),
        ("Giám sát"),
        ("Quản Lý"),
        ("Giám đốc");

insert into division(customer_type_name)
values	("Sale"),
		("Hành Chính"),
        ("Phục vụ"),
        ("Quản Lý");
