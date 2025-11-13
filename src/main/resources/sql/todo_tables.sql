create database todo;
use todo;


create table user(
userid int auto_increment,
name varchar(30) not null,
email varchar(45) not null ,
password varchar(15) not null,
unique key (email),
primary key(userid)
);

create table task(
id int auto_increment,
userid int,
title varchar(200) not null,
status varchar(15) not null default 'pending',
primary key(id),
foreign key (userid) references user(userid)
on update cascade
on delete cascade
);


select* from todo.user;
select* from todo.task;
