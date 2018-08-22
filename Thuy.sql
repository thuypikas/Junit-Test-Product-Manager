Create database Thuyntt
Go
drop database Thuyntt
go
Use Thuyntt
Go

Create Table Account
(
	username varchar(10) primary key not null,
	pass varchar(10) not null,
	fullname nvarchar(50) not null,
	email varchar(50) not null,
	phone varchar(11) not null,
)
Go

Create Table Product
(
	id varchar(10) primary key,
	name varchar(50) not null,
	amount nvarchar(50) not null,
	price varchar(50) not null,
	brand varchar(11) not null,
)
Go

--insert
insert into Account values ('thuyntt','123','Nguyễn Thị Thu Thủy','thuyntt@gmail.com','0962140533')

insert into Product values ('1','Iphone7','1','10000000','Apple')


