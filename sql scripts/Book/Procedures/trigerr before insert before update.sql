-- before insert
DELIMITER $$
CREATE TRIGGER `books_before_insert` BEFORE INSERT ON `book`
FOR EACH ROW
BEGIN
    CALL check_book(new.price,new.title, new.author);
END   
DELIMITER ; 
-- before update
DELIMITER $$
CREATE TRIGGER `book_before_update` BEFORE UPDATE ON `book`
FOR EACH ROW
BEGIN
    CALL check_book(new.price,new.title, new.author);
END   
DELIMITER ;