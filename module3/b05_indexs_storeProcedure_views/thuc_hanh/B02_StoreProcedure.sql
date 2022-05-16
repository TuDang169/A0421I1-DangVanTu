use classicmodels;

DELIMITER //
Create procedure findAllCustomers()
Begin
	select *
    from customers;
end //
DELIMITER ;

call findAllCustomers();

DELIMITER //
DROP PROCEDURE IF EXISTS `findAllCustomers`//

CREATE PROCEDURE findAllCustomers()

BEGIN

SELECT * FROM customers where customerNumber = 175;

END //