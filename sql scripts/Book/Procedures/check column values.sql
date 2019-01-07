DELIMITER $$
 
CREATE PROCEDURE `check_book`(IN price DECIMAL, IN title VARCHAR (255), IN author VARCHAR(255) )
BEGIN
    IF price < 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'check constraint on book.price failed';
    END IF;
    
    IF title = '' THEN
 		SIGNAL SQLSTATE '45001'
 			SET MESSAGE_TEXT = 'check constraint on book.title failed';
    END IF;
    
    IF author = ''  THEN
 		SIGNAL SQLSTATE '45002'
            SET MESSAGE_TEXT = 'check constraint on book.author failed';
    END IF;
 
END
 
DELIMITER ;