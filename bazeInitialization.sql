CREATE DATABASE imenikBaza;
CREATE TABLE users (
id INTEGER UNIQUE PRIMARY KEY AUTO_INCREMENT,
name TEXT,
surname TEXT,
password TEXT);
CREATE TABLE contacts (
id INTEGER,
name TEXT,
surname TEXT,
phonenumber TEXT
);