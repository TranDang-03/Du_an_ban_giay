create database BEESHOE

go
use BEESHOE
go

create table mau_sac(
	idMauSac bigint IDENTITY(1,1) primary key not null,
	maMauSac nvarchar(10) null,
	tenMauSac nvarchar(50) null,
	trangThai int null
)

insert into mau_sac(maMauSac,tenMauSac,trangThai) values
('MS1','xanh',1),
('MS2','do',0),
('MS3','cam',1)

create table san_pham(
	idSanPham bigint IDENTITY(1,1) primary key not null,
	maSanPham nvarchar(10) null,
	tenSanPham nvarchar(50) null,
	trangThai int null
)
insert into san_pham(maSanPham,tenSanPham,trangThai) values
('SP1','giay nhap ngoai',1),
('SP2','giay hang noi',0),
('SP3','giay doc quyen',1)

create table chat_lieu(
	idChatLieu bigint IDENTITY(1,1) primary key not null,
	maChatLieu nvarchar(10) null,
	daChinh nvarchar(50) null,
	daPhu nvarchar(50) null,
	daNgoai nvarchar(50) null,
	lopLotTrong nvarchar(50) null,
	trangThai int null
)
insert into chat_lieu(maChatLieu,daChinh,daPhu,daNgoai,lopLotTrong,trangThai) values
('CL1','da ca sau','da bo','da ca sau','mem',1),
('CL2','da bo','da ca sau','da bo','cung',0),
('CL3','da ca sau','da ca sau','da ca sau','mem',1)

create table dong_sp(
	idDongSP bigint IDENTITY(1,1) primary key not null,
	maDongSP nvarchar(10) null,
	tenDongSP nvarchar(50) null,
	trangThai int null
)
insert into dong_sp(maDongSP,tenDongSP,trangThai) values
('DongSP1','giay xin',1),
('DongSP2','giay vip',0),
('DongSP3','giay thuong',1)

create table kich_co(
	idKichCo bigint IDENTITY(1,1) primary key not null,
	maKichCo nvarchar(10) null,
	tenKichCo int null,
	trangThai int null
)
insert into kich_co(maKichCo,tenKichCo,trangThai) values
('KC1',39,1),
('KC2',40,0),
('KC3',41,1)

create table kieu_dang(
	idKieuDang bigint IDENTITY(1,1) primary key not null,
	maKieuDang nvarchar(10) null,
	tenKieuDang nvarchar(50) null,
	trangThai int null
)
insert into kieu_dang(maKieuDang,tenKieuDang,trangThai) values
('KD1','Sang trong',1),
('KD2','Quy phai',0),
('KD3','Thanh lich',1)

create table NSX(
	idNSX bigint IDENTITY(1,1) primary key not null,
	maNSX nvarchar(10) null,
	tenNSX nvarchar(50) null,
	trangThai int null
)
insert into NSX(maNSX,tenNSX,trangThai) values
('NSX1','Nike',1),
('NSX2','Adidas',0),
('NSX3','Puma',1)

create table thuong_hieu(
	idThuongHieu bigint IDENTITY(1,1) primary key not null,
	maThuongHieu nvarchar(10) null,
	tenThuongHieu nvarchar(50) null,
	trangThai int null
)
insert into thuong_hieu(maThuongHieu,tenThuongHieu,trangThai) values
('TH1','thuong hieu 1',1),
('TH2','thuong hieu 2',0),
('TH3','thuong hieu 3',1)

create table khach_hang(
	idKhachhang bigint IDENTITY(1,1) primary key not null,
	maKhachhang nvarchar(10) null,
	tenKhachHang nvarchar(100) null,
	gioiTinh bit,
	ngaySinh date,
	sdt varchar(10) null,
	diaChi nvarchar(200) null,
	trangThai int null
)
insert into khach_hang(maKhachhang,tenKhachHang,gioiTinh,ngaySinh,sdt,diaChi,trangThai) values
('KH1','Tran Hai Dang',1,'2003-06-30','0816130199','Hung Yen',1),
('KH2','Duong Van Tam',1,'2003-06-20','0816130199','Hung Yen',0),
('KH3','Ngo Thi Thu Hang',0,'2003-06-20','0816130199','Hung Yen',1)

create table nhan_vien(
	idNhanVien bigint IDENTITY(1,1) primary key not null,
	maNhanVien nvarchar(10) null,
	tenNhanVien nvarchar(500) null,
	gioiTinh bit,
	ngaySinh date,
	diachi nvarchar(500) null,
	sdt varchar(10) null,
	chucVu int null,
	trangThai int null,
	luong float null,
	tenTaiKhoan nvarchar(10) null,
	matKhau nvarchar(100) null
)
insert into nhan_vien(maNhanVien,tenNhanVien,gioiTinh,ngaySinh,diachi,sdt,chucVu,trangThai,luong,tenTaiKhoan,matKhau) values
('NV01','Le Van Long',1,'2003-07-07','Hung Yen','0485927465',0,1,10000,'abc1','abc'),
('NV02','Le Thi Hoa',0,'2003-07-07','Hung Yen','0485927465',1,1,10000,'abc1','abc'),
('NV03','Le Van Trung',1,'2003-07-07','Hung Yen','0485927465',0,0,10000,'abc1','abc')

create table khuyen_mai(
	idKhuyenMai bigint IDENTITY(1,1) primary key not null,
	tenKhuyenMai nvarchar(500) null,
	giaTriKM int null,
	ngayBatDau date,
	ngayKetThuc date,
	trangThai int null,
	loaiKhuyenMai int null,
	moTa nvarchar(1000) null
)
insert into khuyen_mai(tenKhuyenMai,giaTriKM,ngayBatDau,ngayKetThuc,trangThai,loaiKhuyenMai,moTa) values
('KM1',50000,'2022-10-10','2023-12-12',1,1,'Giam gia cho don hang tren 100k'),
('KM2',10,'2022-10-10','2023-12-12',1,0,'Giam gia cho don hang tren 200k'),
('KM3',20000,'2022-10-10','2023-12-12',0,1,'Giam gia cho don hang tren 150k')

create table chi_tiet_san_pham(
	idChiTietSP bigint IDENTITY(1,1) primary key not null,
	idNSX bigint not null,
	idSanPham bigint not null,
	idMauSac bigint not null,
	idDongSP bigint not null,
	idChatLieu bigint not null,
	idKichCo bigint not null,
	idKieuDang bigint not null,
	idThuongHieu bigint not null,
	maCTSP nvarchar(1000) not null,
	soLuongTon int null,
	giaNhap float,
	giaBan float,
	anh nvarchar(2000) null

	foreign key(idSanPham) references san_pham(idSanPham),
	foreign key(idNSX) references NSX(idNSX),
	foreign key(idMauSac) references mau_sac(idMauSac),
	foreign key(idDongSP) references dong_sp(idDongSP),
	foreign key(idChatLieu) references chat_lieu(idChatLieu),
	foreign key(idKichCo) references kich_co(idKichCo),
	foreign key(idKieuDang) references kieu_dang(idKieuDang),
	foreign key(idThuongHieu) references thuong_hieu(idThuongHieu)
)

insert into chi_tiet_san_pham(idNSX,idSanPham,idMauSac,idDongSP,idChatLieu,idKichCo,idKieuDang,idThuongHieu,maCTSP,soLuongTon,giaNhap,giaBan,anh) values
(1,1,1,1,1,1,1,1,'CTSP1',100,100000,150000,'anh1.jpg'),
(2,2,2,2,2,2,2,2,'CTSP2',0,120000,170000,'anh2.jpg'),
(3,3,3,3,3,3,3,3,'CTSP3',200,200000,250000,'anh3.jpg')

 sp_rename 'chi_tiet_san_pham.moTa', 'maCTSP' , 'COLUMN';

create table hoa_don(
	idHoaDon bigint IDENTITY(1,1) primary key not null,
	idKhachHang bigint null,
	idNhanVien bigint null,
	maHoaDon nvarchar(10) null,
	ngayTao date null,
	ngayThanhToan date null,
	thanhTien float null,
	idKhuyenMai bigint null,
	trangThai int null

	foreign key(idKhachHang) references khach_hang(idKhachHang),
	foreign key(idNhanVien) references nhan_vien(idNhanVien)
)
insert into hoa_don(idKhachHang,idNhanVien,maHoaDon,ngayTao,ngayThanhToan,thanhTien,idKhuyenMai,trangThai) values
(1,1,'HD01',GETDATE(),GETDATE(),300000,1,0),
(2,2,'HD02',GETDATE(),GETDATE(),400000,1,1),
(3,3,'HD03',GETDATE(),GETDATE(),500000,1,1)

create table hoa_don_chi_tiet(
	idHoaDonChiTiet bigint IDENTITY(1,1) primary key not null,
	soLuong int null,
	donGia float null,
	idHoaDon bigint null,
	idChiTietSanPham bigint null

	foreign key(idHoaDon) references hoa_don(idHoaDon),
	foreign key(idChiTietSanPham) references chi_tiet_san_pham(idChiTietSP)
)
insert into hoa_don_chi_tiet(soLuong,donGia,idHoaDon,idChiTietSanPham) values
(2,150000,1,3),
(1,170000,2,4),
(3,250000,3,5)

alter table hoa_don_chi_tiet
add trangThai int