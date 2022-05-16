create database product_manager;
use product_manager;

create table category(
	category_id		int auto_increment primary key,
    category_name	varchar(45)		
);


create table product(
	product_id 			int auto_increment primary key,
    product_name		varchar(45),
    product_pride		double,
    product_quantity	int,
    product_color		varchar(45),
	category_id			int,
foreign key(category_id) references category(category_id)
);

