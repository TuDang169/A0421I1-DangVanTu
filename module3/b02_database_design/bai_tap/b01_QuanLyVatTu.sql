create database QuanLyDonHang;
use QuanLyDonHang;

create table SDT(
	SDT varchar(20) primary key,
	Ten varchar(50)
);

create table Nha_CC(
	Ma_Nha_CC 	varchar(20) primary key,
    Ten_Nha_CC 	varchar(50),
    Dia_Chi 	varchar(50),
    SDT 		varchar(20),
    foreign key (SDT) references SDT(SDT)
);

create table Don_DH(
	So_DH 	varchar(20) primary key,
    Ngay_DH date
);

create table Nha_CC_DonH(
	So_DH 		varchar(20),
    Ma_Nha_CC 	varchar(20),
    constraint 	pk_Nha_CC_DonH 	primary key(So_DH,Ma_Nha_CC),
    foreign key (So_DH) 		references Don_DH(So_DH),
    foreign key (Ma_Nha_CC) 	references Nha_CC(Ma_Nha_CC)
);

create table Vat_Tu(
	Ma_VTu 	varchar(20) primary key,
    ten_VTu varchar(50)
);

create table Phieu_Xuat(
	So_PX 		varchar(20) primary key,
    Ngay_Xuat 	date
);

create table Phieu_Xuat_VTu(
	So_PX 	varchar(20),
    Ma_VTu 	varchar(20),
    DG_Xuat int,
    SL_Xuat int,
    constraint 	pk_Phieu_Xuat_VTu 	primary key(So_PX,Ma_VTu),
    foreign key (So_PX) 			references PHieu_Xuat(So_PX),
    foreign key (Ma_VTu) 			references Vat_Tu(Ma_VTu)
);
create table Don_DH_VatTu(
	Ma_VTu 		varchar(20),
    Ma_Nha_CC 	varchar(20),
    constraint 	pk_Don_DH_VTu 	primary key(Ma_Nha_CC,Ma_VTu),
	foreign key (Ma_Nha_CC) 	references Nha_CC(Ma_Nha_CC),
    foreign key (Ma_VTu) 		references Vat_Tu(Ma_VTu)
);

create table Phieu_Nhap(
	So_PH  		varchar(20) primary key,
    Ngay_Nhap 	date
);

create table Pheu_Nhap_VTu(
	So_PH 	varchar(20),
    Ma_VTu 	varchar(20),
    DG_nhap int,
    SL_nhap int,
    constraint 	pk_Phieu_Nhap_VTu 	primary key(So_PH,Ma_VTu),
    foreign key (So_PH)  			references Phieu_Nhap(So_PH),
    foreign key (Ma_VTu) 			references Vat_Tu(Ma_VTu)
);