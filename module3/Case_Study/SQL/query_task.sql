use furuma_resort;
-- Task 2: Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * from nhan_vien
where left(ten_nhan_vien,1) in ('H','K','T') and length(ten_nhan_vien)<=15;

-- Task 3 tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *,year(now())-year(ngay_sinh) as tuoi from khach_hang 
where dia_chi in('Da Nang','Quang Tri')
having (year(now())-year(ngay_sinh)) between 18 and 50;

/* task 4 Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
 Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/
 
 select kh.id_khach_hang, kh.ten_khach_hang,count(hd.id_hop_dong) as so_lan_dat from hop_dong hd 
 inner join khach_hang kh on hd.id_khach_hang =kh.id_khach_hang 
 right join loai_khach lk on kh.id_loai_khach=lk.id_loai_khach
 where lk.ten_loai_khach='Diamond'
 group by kh.id_khach_hang
 order by so_lan_dat;
 
 /* Task 5 Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, 
 TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
 cho tất cả các Khách hàng đã từng đặt phỏng. 
 (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/
 
 select kh.id_khach_hang,kh.ten_khach_hang,lk.ten_loai_khach, hd.id_hop_dong ,dv.ten_dich_vu,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,
sum(dv.chi_phi_thue+hdct.so_luong*dvdk.gia) as tong_tien
 from khach_hang kh left join hop_dong hd on kh.id_khach_hang=hd.id_khach_hang
left join loai_khach lk on kh.id_loai_khach=lk.id_loai_khach
left join chi_tiet_hop_dong hdct on hd.id_hop_dong=hdct.id_hop_dong
left join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
left join dich_vu dv on hd.id_dich_vu=dv.id_dich_vu
group by kh.id_khach_hang;
 
 /* 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các 
 loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).*/
 select dv.id_dich_vu,ten_dich_vu,chi_phi_thue,ldv.ten_loai_dich_vu from dich_vu dv 
 inner join loai_dich_vu ldv on dv.id_loai_dich_vu=ldv.id_loai_dich_vu
 inner join hop_dong hd on hd.id_dich_vu=dv.id_dich_vu
 where dv.id_dich_vu not in (select id_dich_vu from hop_dong where ngay_lam_hop_dong between '2019-01-01' and '2019-03-31')
 group by dv.id_dich_vu;

/*Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được 
Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.*/
 select dv.id_dich_vu,ten_dich_vu,dien_tich,so_nguoi_toi_da,chi_phi_thue,ldv.ten_loai_dich_vu from dich_vu dv 
 inner join loai_dich_vu ldv on dv.id_loai_dich_vu=ldv.id_loai_dich_vu
 inner join hop_dong hd on hd.id_dich_vu=dv.id_dich_vu
 where dv.id_dich_vu in (select id_dich_vu from hop_dong where year(ngay_lam_hop_dong)=2018) 
 and dv.id_dich_vu not in (select id_dich_vu from hop_dong where year(ngay_lam_hop_dong)=2019)
 group by dv.id_dich_vu;


/* task 8 Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên*/
select distinct ten_khach_hang from khach_hang
order by ten_khach_hang;

select ten_khach_hang from khach_hang
group by ten_khach_hang
order by ten_khach_hang;

/*9.	Thực hiện thống kê doanh thu theo tháng, 
nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/
select month(ngay_lam_hop_dong) as thang,count(id_hop_dong) as so_khach_dat from hop_dong
where year(ngay_lam_hop_dong)=2019
group by month(ngay_lam_hop_dong)
order by month(ngay_lam_hop_dong);

/*10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, 
SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).*/

select id_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,
(select count(id_chi_tiet_hop_dong) from chi_tiet_hop_dong where id_hop_dong=hop_dong.id_hop_dong) as so_dich_vu_di_kem 
from hop_dong;