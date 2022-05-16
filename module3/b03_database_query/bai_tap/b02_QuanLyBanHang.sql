use QuanLyBanHang;

insert into Customer
values 	(1,'Minh Quan',10),
		(2,'Ngoc Oanh',20),
        (3,'Hong Ha',50);
        
insert into tOrder
values 	(1,1,'2006-3-21',null),
		(2,2,'2006-3-23',null),
        (3,1,'2006-3-16',null);
        
insert into Product
values 	(1,'May Lanh',3),
		(2,'Tu Lanh',5),
        (3,'Dieu Hoa',7),
        (4,'Quat',1),
        (5,'Bep Dien',2);
        
insert into Order_Detail
values 	(1,1,3),
		(1,3,7),
        (1,4,2),
        (2,1,1),
        (3,1,8),
        (2,5,4),
        (2,3,3);

select oID, oDate, oTotalPrice
from tOrder;

select c.cname, p.pName as 'San Pham'
from customer c join torder o on c.cid = o.cid join order_detail od on o.oID = od.oID join Product p on od.pID = p.pID;

select c.cname
from customer c
where not exists (
	select cID 
    from tOrder o
    where o.cID = c.CID
);

select o.oId, o.oDate as 'Ngay Ban', o.oTotalPrice as 'Tong gia tien'
from torder o join order_detail od on o.oID = od.oID join Product p on od.pID = p.pID;