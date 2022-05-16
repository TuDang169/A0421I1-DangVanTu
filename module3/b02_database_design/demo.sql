create database StudentManager;
use StudentManager;

create table Student(
	id 			int 		auto_increment primary key,
    name 		varchar(50),
    birthday 	datetime,
    account 	varchar(50),
    foreign key (account) 	references Account(account),
    foreign key (class_id) 	references Class(id)
);

create table Account(
	account 	varchar(50) primary key,
    password 	varchar(50)
);

create table Class(
	id int auto_increment primary key,
    class_name varchar(50),
    class_type varchar(50),
    student_id varchar(20),
    foreign key (class_type_id) references class_type(id)
);

create table class_type(
	id int auto_increment primary key,
    type_class_name varchar(50)
);

create table Instructor(
	id int auto_increment primary key,
    name varchar(50),
    birthday datetime
);

create table instructor_teach_class(
	instructor_id int,
	class_id int,
    primary key(instructor_id,class_id),
    foreign key (instructor_id)references instructor(id),
	foreign key (class_id)references class(id)
);
