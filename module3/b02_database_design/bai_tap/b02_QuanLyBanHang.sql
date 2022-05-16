create database QuanLyBanHang;
use QuanLyBanHang;

create table Customer(
	cID int primary key,
    cName varchar(50),
    cAge int
);

create table tOrder(
	oID int primary key,
    cID int,
    oDate datetime,
    oTotalPrice int,
    foreign key (cID) references Customer(cID)
);

create table Product(
	pID int primary key,
    pName varchar(50),
    pPrice int
);

create table Order_Detail(
	oID int,
    pID int,
    odQTY int,
    primary key (oID,pID),
    foreign key (oID) references tOrder(oID),
    foreign key (pID) references Product(pID)
);
