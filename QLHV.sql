create database QLHV;
USE QLHV;

CREATE TABLE `account` (
  `user_id` int auto_increment,
  `password` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `account`
VALUES(1, 'admin', 'administrator', 'admin@gmail.com');