/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDon;
import Model.KhachHang;
import Model.NhanVien;
import Util.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import view_model.CTSPBanHang;
import view_model.HDCTBanHang;
import view_model.HoaDonViewModel;

/**
 *
 * @author PC
 */
public class BanHangRepository {

    // Hoa don
    public List<String> getAllMaHD() {
        String query = "SELECT [maHoaDon]\n"
                + "  FROM [dbo].[hoa_don]";
        List<String> list = new ArrayList();

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("maHoaDon"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getIDHD(String maHD) {
        String query = "SELECT [idHoaDon]\n"
                + "  FROM [dbo].[hoa_don] WHERE maHoaDon = ?";
        int a;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return a = rs.getInt("idHoaDon");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public String maHD() {
        HoaDon hd = new HoaDon();
        List<String> hdl = getAllMaHD();
        List<Integer> hds = new ArrayList<>();
        for (String hoaDon : hdl) {
            int soHD = Integer.valueOf(hoaDon.substring(2)) + 1;
            hds.add(soHD);
        }
        int j = 0;
        for (Integer integer : hds) {
            int i = integer;
            if (j < i) {
                j = i;
            }
        }
        return "HD" + j;
    }

    public List<String> getAllMaKhuyenMai() {
        String query = "SELECT [tenKhuyenMai]\n"
                + "  FROM [dbo].[khuyen_mai] where trangThai = 0";
        List<String> list = new ArrayList<>();

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tenKhuyenMai"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getIDKhuyenMai(String maKM) {
        String query = "SELECT [idKhuyenMai]\n"
                + "  FROM [dbo].[khuyen_mai] WHERE tenKhuyenMai = ?";
        int a;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maKM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return a = rs.getInt("idKhuyenMai");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<String> getAllMaKhachHang() {
        String query = "SELECT [tenKhuyenMai]\n"
                + "  FROM [dbo].[khuyen_mai]";
        List<String> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tenKhuyenMai"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getIDKhachHang(String maKH) {
        String query = "SELECT [idKhachhang]\n"
                + "  FROM [dbo].[khach_hang] WHERE maKhachhang = ?";
        int a;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maKH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return a = rs.getInt("idKhachHang");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<String> getAllMaNhanVien() {
        String query = "SELECT [maNhanVien]\n"
                + "  FROM [dbo].[nhan_vien]";
        List<String> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("maNhanVien"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getIDNhanVien(String maNV) {
        String query = "SELECT [idNhanVien]\n"
                + "  FROM [dbo].[nhan_vien] WHERE maNhanVien = ?";
        int a;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return a = rs.getInt("idNhanVien");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    // WHERE trangThai = 0
    public List<String> getAllTenMau() {
        String query = "SELECT [tenMauSac]\n"
                + "  FROM [dbo].[mau_sac]";
        List<String> list = new ArrayList<>();

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tenMauSac"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Integer> getAllTenKichCo() {
        String query = "SELECT [tenKichCo]\n"
                + "  FROM [dbo].[kich_co] ORDER BY tenKichCo ASC";
        List<Integer> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt("tenKichCo"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<String> getAllTenThuongHieu() {
        String query = "SELECT[tenThuongHieu]\n"
                + "  FROM [dbo].[thuong_hieu]";
        List<String> list = new ArrayList<>();

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tenThuongHieu"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public boolean addHoaDon(String maKH) {
        String query = "INSERT INTO [dbo].[hoa_don]\n"
                + "           ([idKhachHang]\n"
                + "           ,[maHoaDon]\n"
                + "           ,[ngayTao]\n"
                + "           ,[thanhTien]\n"
                + "           ,[trangThai])\n"
                + "     VALUES\n"
                + "           (?,?,GETDATE(),0,1)";
        int check = 0;
        String maHD = maHD();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, getIDKhachHang(maKH));
            ps.setObject(2, maHD);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean deleteHDCT(int idHDCT, String maHD) {
        String query = "DELETE FROM [dbo].[hoa_don_chi_tiet]\n"
                + "      WHERE idHoaDonChiTiet = ? AND idHoaDon = ?";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHDCT);
            ps.setObject(2, getIDHD(maHD));
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public List<CTSPBanHang> getAllCTSP() {
        String query = "select idChiTietSP,tenSanPham,tenDongSP,tenThuongHieu,tenKichCo,giaBan,soLuongTon,tenMauSac\n"
                + "from chi_tiet_san_pham join san_pham on chi_tiet_san_pham.idSanPham = san_pham.idSanPham\n"
                + "join dong_sp on chi_tiet_san_pham.idDongSP = dong_sp.idDongSP\n"
                + "join thuong_hieu on chi_tiet_san_pham.idThuongHieu = thuong_hieu.idThuongHieu\n"
                + "join kich_co on chi_tiet_san_pham.idKichCo = kich_co.idKichCo\n"
                + "join mau_sac on chi_tiet_san_pham.idMauSac = mau_sac.idMauSac";

        List<CTSPBanHang> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTSPBanHang ctsp = new CTSPBanHang(rs.getInt("idChiTietSP"),
                        rs.getString("tenSanPham"), rs.getString("tenDongSP"),
                        rs.getString("tenThuongHieu"), rs.getInt("tenKichCo"),
                        rs.getFloat("giaBan"), rs.getInt("soLuongTon"), rs.getString("tenMausac"));

                list.add(ctsp);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<HoaDonViewModel> getAllHoaDonChuaThanhToan() {
        String query = "select maHoaDon,tenNhanVien,tenKhachHang,tenKhuyenMai,thanhTien,ngayTao,hoa_don.trangThai\n"
                + "                from hoa_don left join nhan_vien on hoa_don.idNhanVien = nhan_vien.idNhanVien\n"
                + "                left join khach_hang on hoa_don.idKhachHang = khach_hang.idKhachhang\n"
                + "                left join khuyen_mai on hoa_don.idKhuyenMai = khuyen_mai.idKhuyenMai\n"
                + "                where hoa_don.trangThai = 1 order by idHoaDon desc";
        List<HoaDonViewModel> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModel hd = new HoaDonViewModel(rs.getString("maHoaDon"),
                        rs.getString("tenKhachhang"), rs.getString("tenNhanVien"),
                        rs.getString("tenKhuyenMai"), rs.getFloat("thanhTien"), rs.getDate("ngayTao"),
                        rs.getInt("trangThai"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<HoaDonViewModel> getAllHoaDonDaThanhToan() {
        String query = "select maHoaDon,tenNhanVien,tenKhachHang,tenKhuyenMai,thanhTien,ngayTao,hoa_don.trangThai\n"
                + "                from hoa_don left join nhan_vien on hoa_don.idNhanVien = nhan_vien.idNhanVien\n"
                + "                left join khach_hang on hoa_don.idKhachHang = khach_hang.idKhachhang\n"
                + "                left join khuyen_mai on hoa_don.idKhuyenMai = khuyen_mai.idKhuyenMai\n"
                + "                where hoa_don.trangThai = 0 order by idHoaDon desc";
        List<HoaDonViewModel> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModel hd = new HoaDonViewModel(rs.getString("maHoaDon"),
                        rs.getString("tenKhachhang"), rs.getString("tenNhanVien"),
                        rs.getString("tenKhuyenMai"), rs.getFloat("thanhTien"), rs.getDate("ngayTao"),
                        rs.getInt("trangThai"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<HoaDonViewModel> getAllHoaDon() {
        String query = "select maHoaDon,tenNhanVien,tenKhachHang,tenKhuyenMai,thanhTien,ngayTao,hoa_don.trangThai\n"
                + "from hoa_don left join nhan_vien on hoa_don.idNhanVien = nhan_vien.idNhanVien\n"
                + "left join khach_hang on hoa_don.idKhachHang = khach_hang.idKhachhang\n"
                + "left join khuyen_mai on hoa_don.idKhuyenMai = khuyen_mai.idKhuyenMai order by idHoaDon desc";
        List<HoaDonViewModel> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModel hd = new HoaDonViewModel(rs.getString("maHoaDon"),
                        rs.getString("tenKhachhang"), rs.getString("tenNhanVien"),
                        rs.getString("tenKhuyenMai"), rs.getFloat("thanhTien"), rs.getDate("ngayTao"),
                        rs.getInt("trangThai"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<CTSPBanHang> searchSPCT(String name) {
        String query = "select idChiTietSP,tenSanPham,tenDongSP,tenThuongHieu,tenKichCo,giaBan,soLuongTon,tenMauSac\n"
                + "from chi_tiet_san_pham join san_pham on chi_tiet_san_pham.idSanPham = san_pham.idSanPham\n"
                + "join dong_sp on chi_tiet_san_pham.idDongSP = dong_sp.idDongSP\n"
                + "join thuong_hieu on chi_tiet_san_pham.idThuongHieu = thuong_hieu.idThuongHieu\n"
                + "join kich_co on chi_tiet_san_pham.idKichCo = kich_co.idKichCo\n"
                + "join mau_sac on chi_tiet_san_pham.idMauSac = mau_sac.idMauSac\n"
                + "where san_pham.tenSanPham like ? \n"
                + "group by idChiTietSP,tenSanPham,tenDongSP,tenThuongHieu,tenKichCo,giaBan,soLuongTon,tenMauSac";
        List<CTSPBanHang> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            String ten = "%" + name + "%";
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTSPBanHang bh = new CTSPBanHang(rs.getInt("idChiTietSP"), rs.getString("tenSanPham"),
                        rs.getString("tenDongSP"), rs.getString("tenThuongHieu"),
                        rs.getInt("tenKichCo"), rs.getFloat("giaBan"),
                        rs.getInt("soLuongTon"), rs.getString("tenMauSac"));
                list.add(bh);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<KhachHang> getAllKhachHang() {
        String query = "select maKhachhang,tenKhachHang,gioiTinh,ngaySinh,sdt,diaChi,trangThai from khach_hang where trangThai = 0";
        List<KhachHang> list = new ArrayList<>();

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"),
                        rs.getBoolean("gioiTinh"),
                        rs.getDate("ngaySinh"), rs.getString("sdt"), rs.getString("diaChi"), rs.getInt("trangThai"));
                list.add(kh);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<String> getAllTenNhanVien() {
        String query = "select tenNhanVien from nhan_vien where trangThai = 0";
        List<String> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tenNhanVien"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<HDCTBanHang> getAllHDCTTheoMaHD(String maHD) {
        String query = "select idChiTietSanPham,tenSanPham,soLuong,tenDongSP,tenNSX,tenKichCo,donGia \n"
                + "from hoa_don_chi_tiet join chi_tiet_san_pham on hoa_don_chi_tiet.idChiTietSanPham = chi_tiet_san_pham.idChiTietSP\n"
                + "join dong_sp on chi_tiet_san_pham.idDongSP = dong_sp.idDongSP\n"
                + "join NSX on chi_tiet_san_pham.idNSX = NSX.idNSX\n"
                + "join kich_co on chi_tiet_san_pham.idKichCo = kich_co.idKichCo\n"
                + "join san_pham on chi_tiet_san_pham.idSanPham = san_pham.idSanPham\n"
                + "join hoa_don on hoa_don_chi_tiet.idHoaDon = hoa_don.idHoaDon\n"
                + "where maHoaDon = ?";
        List<HDCTBanHang> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HDCTBanHang hdct = new HDCTBanHang(rs.getInt("idChiTietSanPham"), rs.getString("tenSanPham"),
                        rs.getInt("soLuong"),
                        rs.getString("tenDongSP"), rs.getString("tenNSX"), rs.getInt("tenKichCo"),
                        rs.getFloat("donGia"));
                list.add(hdct);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean xoaSPDaCot(int idHDCT, String maHD) {
        String query = "DELETE FROM [dbo].[hoa_don_chi_tiet]\n"
                + "     WHERE idHoaDonChiTiet = ? and idHoaDon = ?";
        int check = 0;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHDCT);
            ps.setObject(2, getIDHD(maHD));
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean themSPVaoHDCT(int soLuong, float donGia, String maHD, int idHDCT) {
        String query = "INSERT INTO [dbo].[hoa_don_chi_tiet]\n"
                + "           ([soLuong]\n"
                + "           ,[donGia]\n"
                + "           ,[idHoaDon]\n"
                + "           ,[idChiTietSanPham])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, soLuong);
            ps.setObject(2, donGia);
            ps.setObject(3, getIDHD(maHD));
            ps.setObject(4, idHDCT);

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateSoLuongSP(int soLuong, int idHDCT, String maHD) {
        String query = "UPDATE [dbo].[hoa_don_chi_tiet]\n"
                + "   SET [soLuong] = ?\n"
                + " WHERE idHoaDonChiTiet = ? and idHoaDon = ?";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, soLuong);
            ps.setObject(2, idHDCT);
            ps.setObject(3, getIDHD(maHD));
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public List<HDCTBanHang> checkTrungSP(int idCTSP, String maHD) {
        String query = "select idChiTietSanPham from hoa_don_chi_tiet join hoa_don on hoa_don_chi_tiet.idHoaDon = hoa_don.idHoaDon\n"
                + "where idChiTietSanPham = ? and hoa_don.idHoaDon = ?";
        List<HDCTBanHang> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idCTSP);
            ps.setObject(2, getIDHD(maHD));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<HDCTBanHang> checkTonTaiSP(String maHD, int idCTSP) {
        String query = "SELECT idChiTietSanPham,tenSanPham,soLuong,tenDongSP,tenNSX,tenKichCo,donGia\n"
                + "from hoa_don_chi_tiet hdct join chi_tiet_san_pham ctsp on hdct.idChiTietSanPham = ctsp.idChiTietSP \n"
                + "join dong_sp on ctsp.idDongSP = dong_sp.idDongSP \n"
                + "join NSX on ctsp.idNSX = NSX.idNSX \n"
                + "join kich_co on ctsp.idKichCo = kich_co.idKichCo \n"
                + "join san_pham on ctsp.idSanPham = san_pham.idSanPham \n"
                + "join hoa_don on hdct.idHoaDon = hoa_don.idHoaDon\n"
                + "WHERE hdct.idHoaDon = ?\n"
                + "AND ctsp.idChiTietSP = ?\n"
                + "AND EXISTS (\n"
                + "    SELECT 1\n"
                + "    FROM hoa_don_chi_tiet hdc2\n"
                + "    WHERE hdct.idHoaDon = hdc2.idHoaDon AND hdct.idChiTietSanPham = hdc2.idChiTietSanPham\n"
                + "    GROUP BY hdc2.idHoaDon, hdc2.idChiTietSanPham\n"
                + "    HAVING COUNT(*) >= 1\n"
                + ")\n"
                + "ORDER BY hdct.idHoaDon";
        List<HDCTBanHang> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, getIDHD(maHD));
            ps.setObject(2, idCTSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HDCTBanHang hd = new HDCTBanHang(rs.getInt("idChiTietSanPham"), rs.getString("tenSanPham"),
                        rs.getInt("soLuong"), rs.getString("tenDongSP"), rs.getString("tenNSX"),
                        rs.getInt("tenKichCo"),
                        rs.getFloat("donGia"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean suaSoLuong(int soLuong, int idCTSP, String maHD) {
        String query = "UPDATE [dbo].[hoa_don_chi_tiet]\n"
                + "   SET [soLuong] = ?  \n"
                + " WHERE idChiTietSanPham = ? and idHoaDon = ?";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, soLuong);
            ps.setObject(2, idCTSP);
            ps.setObject(3, getIDHD(maHD));
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean suaSoLuongCTSP(int soLuong, int idCTSP) {
        String query = "UPDATE [dbo].[chi_tiet_san_pham]\n"
                + "   SET \n"
                + "	[soLuongTon] = ?\n"
                + "\n"
                + " WHERE idChiTietSP = ?";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, soLuong);
            ps.setObject(2, idCTSP);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public float tinhTongTienSanPhamTheoHoaDon(String maHD) {
        String query = "SELECT \n"
                + "    SUM(hdct.soLuong * hdct.donGia) AS TongTien\n"
                + "FROM\n"
                + "    hoa_don hd\n"
                + "INNER JOIN\n"
                + "    hoa_don_chi_tiet hdct ON hd.idHoaDon = hdct.idHoaDon\n"
                + "	where hd.idHoaDon = ?\n"
                + "GROUP BY\n"
                + "    hd.idHoaDon,\n"
                + "    hd.maHoaDon,\n"
                + "    hd.ngayTao;";
        float a = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, getIDHD(maHD));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return a = rs.getFloat("TongTien");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public Integer laySoLuongSPTrongHDCT(String maHD, int idCTSP) {
        String query = "SELECT \n"
                + "    soLuong\n"
                + "FROM\n"
                + "    hoa_don_chi_tiet\n"
                + "WHERE\n"
                + "    idHoaDon = ?\n"
                + "    AND idChiTietSanPham = ?;";
        int a = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, getIDHD(maHD));
            ps.setObject(2, idCTSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return a = rs.getInt("soLuong");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public Integer layIDCTSPTheoMAHD(int idHDCT, String maHD) {
        String query = "SELECT idChiTietSanPham\n"
                + "FROM\n"
                + "    hoa_don_chi_tiet\n"
                + "WHERE\n"
                + "    idHoaDonChiTiet = ? and idHoaDon = ?";
        int a = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHDCT);
            ps.setObject(2, getIDHD(maHD));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return a = rs.getInt("idChiTietSanPham");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public Integer laySLTonTheoidCTSP(int idCTSP) {
        String query = "SELECT \n"
                + "    soLuongTon\n"
                + "FROM\n"
                + "    chi_tiet_san_pham\n"
                + "WHERE\n"
                + "    idChiTietSP = ?";
        int a = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idCTSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return a = rs.getInt("soLuongTon");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public Integer layIdHDCTTheoIdHDVaIdCTSP(int idCTSP, String maHD) {
        String query = "SELECT \n"
                + "    idHoaDonChiTiet\n"
                + "FROM\n"
                + "    hoa_don_chi_tiet\n"
                + "WHERE\n"
                + "    idChiTietSanPham = ?\n"
                + "    AND idHoaDon = ?";
        int a = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idCTSP);
            ps.setObject(2, getIDHD(maHD));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return a = rs.getInt("idHoaDonChiTiet");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public static void main(String[] args) {
        // List<String> list = new BanHangRepository().getAllMaHD();
        // for (String string : list) {
        // System.out.println(list);
        // }
        // int a = new BanHangRepository().getIDHD("HD01");
        // System.out.println(a);

        float a = new BanHangRepository().tinhTongTienSanPhamTheoHoaDon("HD01");
        System.out.println(a);
    }
}
