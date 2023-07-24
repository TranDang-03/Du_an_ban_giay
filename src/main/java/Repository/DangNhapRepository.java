/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.NhanVien;
import Util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class DangNhapRepository {

    public NhanVien getOne(String userName, String passWord) {
        String query = "select * from nhan_vien where tenTaiKhoan = ? and matKhau = ?";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, userName);
            ps.setObject(2, passWord);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getInt("idNhanVien"), rs.getString("maNhanVien"), rs.getString("tenNhanVien"),
                        rs.getBoolean("gioiTinh"), rs.getDate("ngaySinh"), rs.getString("diaChi"), rs.getString("sdt"),
                        rs.getInt("chucVu"), rs.getInt("trangThai"), rs.getFloat("luong"), rs.getString("tenTaiKhoan"),
                        rs.getString("matKhau"));
                return nv;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        DangNhapRepository dn = new DangNhapRepository();
//        NhanVien nv = dn.getOne("abc13", "abc");
//        System.out.println(nv.toString());
//    }
}
