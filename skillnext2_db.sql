create database skillnext2_db;
use skillnext2_db;

create table employee (
	id int primary key auto_increment,
    name varchar(100),
    email varchar(100),
    salary double
);
use skillnext2_db;
show tables;
drop table students1;
create table students1(id int primary key auto_increment, name varchar(20),sem int ,dept varchar(10)); 
desc students1;
select * from students1;