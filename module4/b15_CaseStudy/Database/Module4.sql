create Database module4;
use module4;

INSERT INTO `module4`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('1', 'Diamond');
INSERT INTO `module4`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('2', 'Platinum');
INSERT INTO `module4`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('3', 'Gold');
INSERT INTO `module4`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('4', 'Silver');
INSERT INTO `module4`.`customer_type` (`customer_type_id`, `customer_type_name`) VALUES ('5', 'Member');

INSERT INTO `module4`.`education` (`education_id`, `education_name`) VALUES ('1', 'Trung Cấp');
INSERT INTO `module4`.`education` (`education_id`, `education_name`) VALUES ('2', 'Cao Đẳng');
INSERT INTO `module4`.`education` (`education_id`, `education_name`) VALUES ('3', 'Đại Học');
INSERT INTO `module4`.`education` (`education_id`, `education_name`) VALUES ('4', 'Sau Đại Học');

INSERT INTO `module4`.`division` (`division_id`, `division_name`) VALUES ('1', 'Sale – Marketing');
INSERT INTO `module4`.`division` (`division_id`, `division_name`) VALUES ('2', 'Hành Chính');
INSERT INTO `module4`.`division` (`division_id`, `division_name`) VALUES ('3', 'Phục vụ');
INSERT INTO `module4`.`division` (`division_id`, `division_name`) VALUES ('4', 'Quản lý');

INSERT INTO `module4`.`position` (`position_id`, `position_name`) VALUES ('1', 'Lễ Tân');
INSERT INTO `module4`.`position` (`position_id`, `position_name`) VALUES ('2', 'Phục Vụ');
INSERT INTO `module4`.`position` (`position_id`, `position_name`) VALUES ('3', 'Chuyên Viên');
INSERT INTO `module4`.`position` (`position_id`, `position_name`) VALUES ('4', 'Giám Sát');
INSERT INTO `module4`.`position` (`position_id`, `position_name`) VALUES ('5', 'Quản Lý');
INSERT INTO `module4`.`position` (`position_id`, `position_name`) VALUES ('6', 'Giám Đốc');

INSERT INTO `module4`.`customer` (`customer_id`, `customer_address`, `customer_birthday`, `customer_email`, `customer_gender`, `customer_id_card`, `customer_name`, `customer_phone`, `customer_type_id`) VALUES ('1', 'Korea', '2021-11-10', 'Han@codegym.vn', b'1', '1122', 'Han', '222222', '1');
INSERT INTO `module4`.`customer` (`customer_id`, `customer_address`, `customer_birthday`, `customer_email`, `customer_gender`, `customer_id_card`, `customer_name`, `customer_phone`, `customer_type_id`) VALUES ('2', 'JP', '2000-05-05', 'Yua@codegym.vn', b'0', '1122', 'Yua Mikami', '111111', '3');
INSERT INTO `module4`.`customer` (`customer_id`, `customer_address`, `customer_birthday`, `customer_email`, `customer_gender`, `customer_id_card`, `customer_name`, `customer_phone`, `customer_type_id`) VALUES ('3', 'USA', '1980-03-03', 'Nicole@codegym.vn', b'0', '1122', 'Nicole Aniston', '222222', '2');
INSERT INTO `module4`.`customer` (`customer_id`, `customer_address`, `customer_birthday`, `customer_email`, `customer_gender`, `customer_id_card`, `customer_name`, `customer_phone`, `customer_type_id`) VALUES ('4', 'Korea', '2021-11-10', 'Han@codegym.vn', b'1', '1122', 'Han', '222222', '5');
INSERT INTO `module4`.`customer` (`customer_id`, `customer_address`, `customer_birthday`, `customer_email`, `customer_gender`, `customer_id_card`, `customer_name`, `customer_phone`, `customer_type_id`) VALUES ('5', 'JP', '2000-05-05', 'Yua@codegym.vn', b'0', '1122', 'Yua Mikami', '111111', '4');
INSERT INTO `module4`.`customer` (`customer_id`, `customer_address`, `customer_birthday`, `customer_email`, `customer_gender`, `customer_id_card`, `customer_name`, `customer_phone`, `customer_type_id`) VALUES ('6', 'USA', '1980-03-03', 'Nicole@codegym.vn', b'0', '1122', 'Nicole Aniston', '222222', '3');