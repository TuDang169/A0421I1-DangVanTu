CREATE DATABASE my_database;
DROP DATABASE my_database;
CREATE SCHEMA `student_management` ;
CREATE TABLE `student_management`.`student` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
