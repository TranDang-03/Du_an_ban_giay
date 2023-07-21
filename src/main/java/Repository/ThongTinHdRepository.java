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
        String sql = "SELECT dbo.hoa_don.maHoaDon, dbo.nhan_vien.tenNhanVien, dbo.hoa_don.ngayTao, dbo.khach_hang.tenKhachHang, dbo.hoa_don.thanhTien, dbo.khuyen_mai.tenKhuyenMai, dbo.hoa_don.trangThai\n"
                + "FROM     dbo.hoa_don INNER JOIN\n"
                + "                  dbo.khach_hang ON dbo.hoa_don.idKhachHang = dbo.khach_hang.idKhachhang INNER JOIN\n"
                + "                  dbo.nhan_vien ON dbo.hoa_don.idNhanVien = dbo.nhan_vien.idNhanVien CROSS JOIN\n"
                + "                  dbo.khuyen_mai";

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
