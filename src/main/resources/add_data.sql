create table IF NOT EXISTS `userslist`.test (
id int(8) NOT NULL AUTO_INCREMENT,
name varchar(25) DEFAULT NULL,
age int DEFAULT NULL,
isAdmin bit DEFAULT NULL,
createdDate timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (id));
insert into test values(1, 'John', '21', 0, default);
insert into test values(2, 'Silver', '22', 1, default);
insert into test values(3, 'Petr', '23', 0, default);
insert into test values(4, 'Vova', '24', 1, default);
insert into test values(5, 'Alex', '25', 1, default);
insert into test values(6, 'Jerar', '26', 0, default);
insert into test values(7, 'Senior', '27', 0, default);
insert into test values(8, 'Junior', '28', 1, default);
insert into test values(9, 'Java', '29', 1, default);
insert into test values(10, 'Developer', '20', 0, default);
insert into test values(11, 'Post', '19', 1, default);
insert into test values(12, 'Get', '18', 0, default);
