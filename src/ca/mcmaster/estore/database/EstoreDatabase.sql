/*Create a database*/
CREATE DATABASE estore;
USE estore;

/*create a table called users*/
CREATE TABLE users(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(40),
	PASSWORD VARCHAR(40),
	nickname VARCHAR(40),
	email VARCHAR(100),
	role VARCHAR(100),
	state INT,
	activecode VARCHAR(100),
	updatetime TIMESTAMP
);

/*create a table for products*/
CREATE TABLE products(
	id VARCHAR(100) PRIMARY KEY,
	NAME VARCHAR(40),
	price DOUBLE,
	category VARCHAR(40),
	pnum INT,
	imgurl VARCHAR(100),
	description VARCHAR(255)
);