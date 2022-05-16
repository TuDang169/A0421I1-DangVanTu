CREATE TABLE `student_management`.`class` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `student_management`.`teacher` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
