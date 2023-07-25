/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Util.DBConnect;
import ViewModels.ThongTinHD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongTinHdRepository {

    public List<ThongTinHD> HdAll() {
        String sql = "SELECT hd.maHoaDon, nv.tenNhanVien, hd.ngayTao, kh.tenKhachHang, hd.thanhTien, km.tenKhuyenMai, hd.trangThai\n"
                + "FROM dbo.hoa_don AS hd\n"
                + "INNER JOIN dbo.khach_hang AS kh ON hd.idKhachHang = kh.idKhachhang\n"
                + "INNER JOIN dbo.nhan_vien AS nv ON hd.idNhanVien = nv.idNhanVien\n"
                + "LEFT JOIN dbo.khuyen_mai AS km ON hd.idKhuyenMai = km.idKhuyenMai";

        List<ThongTinHD> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongTinHD hd = new ThongTinHD(rs.getString("maHoaDon"), rs.getString("tenNhanVien"),
                        rs.getDate("ngayTao"), rs.getString("tenKhachHang"), rs.getFloat("thanhTien"), rs.getString("tenKhuyenMai"), rs.getInt("trangThai"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<ThongTinHD> getHDByTongTienCao() {
        String sql = "SELECT hd.maHoaDon, nv.tenNhanVien, hd.ngayTao, kh.tenKhachHang, hd.thanhTien, km.tenKhuyenMai, hd.trangThai\n"
                + "FROM dbo.hoa_don AS hd\n"
                + "INNER JOIN dbo.khach_hang AS kh ON hd.idKhachHang = kh.idKhachhang\n"
                + "INNER JOIN dbo.nhan_vien AS nv ON hd.idNhanVien = nv.idNhanVien\n"
                + "LEFT JOIN dbo.khuyen_mai AS km ON hd.idKhuyenMai = km.idKhuyenMai\n"
                + "ORDER BY hd.thanhTien DESC";

        List<ThongTinHD> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongTinHD hd = new ThongTinHD(rs.getString("maHoaDon"), rs.getString("tenNhanVien"),
                        rs.getDate("ngayTao"), rs.getString("tenKhachHang"), rs.getFloat("thanhTien"), rs.getString("tenKhuyenMai"), rs.getInt("trangThai"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
     public List<ThongTinHD> getHDByTongTienThap() {
        String sql = "SELECT hd.maHoaDon, nv.tenNhanVien, hd.ngayTao, kh.tenKhachHang, hd.thanhTien, km.tenKhuyenMai, hd.trangThai\n"
                + "FROM dbo.hoa_don AS hd\n"
                + "INNER JOIN dbo.khach_hang AS kh ON hd.idKhachHang = kh.idKhachhang\n"
                + "INNER JOIN dbo.nhan_vien AS nv ON hd.idNhanVien = nv.idNhanVien\n"
                + "LEFT JOIN dbo.khuyen_mai AS km ON hd.idKhuyenMai = km.idKhuyenMai\n"
                + "ORDER BY hd.thanhTien ASC";

        List<ThongTinHD> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongTinHD hd = new ThongTinHD(rs.getString("maHoaDon"), rs.getString("tenNhanVien"),
                        rs.getDate("ngayTao"), rs.getString("tenKhachHang"), rs.getFloat("thanhTien"), rs.getString("tenKhuyenMai"), rs.getInt("trangThai"));
                list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
