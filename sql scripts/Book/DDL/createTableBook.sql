create table Book(
	book_id int not null auto_increment,
	title varchar(255) not null,
	author varchar(255) not null,
	price decimal not null,
	primary key (book_id)
); 
