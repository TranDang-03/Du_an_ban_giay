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
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class NhanVienRepository {

    public ArrayList<NhanVien> all() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM nhan_vien";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idNhanVien = rs.getInt("idNhanVien");
                String maNhanVien = rs.getString("maNhanVien");
                String tenNhanVien = rs.getString("tenNhanVien");
                Boolean gioiTinh = rs.getBoolean("gioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                String diaChi = rs.getString("diaChi");
                String sdt = rs.getString("sdt");
                int chucVu = rs.getInt("chucVu");
                Float luong = rs.getFloat("luong");
                int trangThai = rs.getInt("trangThai");
                String tenTaiKhoan = rs.getString("tenTaiKhoan");
                String matKhau = rs.getString("matKhau");

                NhanVien nv = new NhanVien(idNhanVien, maNhanVien, tenNhanVien, gioiTinh, ngaySinh, diaChi, sdt, chucVu, trangThai, luong, tenTaiKhoan, matKhau);
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(NhanVien nv) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = " INSERT INTO nhan_vien(maNhanVien, tenNhanVien, gioiTinh, ngaySinh, diaChi, sdt, chucVu,trangThai,luong,tenTaiKhoan,matKhau) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getTenNV());
            ps.setBoolean(3, nv.isGioiTinh());
            java.sql.Date ngaySinh = new java.sql.Date(nv.getNgSinh().getTime());
            ps.setDate(4, ngaySinh);
            ps.setString(5, nv.getDiaChi());
            ps.setString(6, nv.getSdt());
            ps.setInt(7, nv.getChucVu());
            ps.setInt(8, nv.getTrangThai());
            ps.setFloat(9, nv.getLuong());
            ps.setString(10, nv.getTaiKhoan());
            ps.setString(11, nv.getMatKhau());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(NhanVien nv) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "UPDATE nhan_vien SET tenNhanVien= ?, gioiTinh= ?, ngaySinh= ?, diaChi= ?, sdt= ?, chucVu= ?,trangThai= ?,luong= ?,tenTaiKhoan= ?,matKhau = ? WHERE maNhanVien = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(11, nv.getMaNV());
            ps.setString(1, nv.getTenNV());
            ps.setBoolean(2, nv.isGioiTinh());
            java.sql.Date ngaySinh = new java.sql.Date(nv.getNgSinh().getTime());
            ps.setDate(3, ngaySinh);
            ps.setString(4, nv.getDiaChi());
            ps.setString(5, nv.getSdt());
            ps.setInt(6, nv.getChucVu());
            ps.setInt(7, nv.getTrangThai());
            ps.setFloat(8, nv.getLuong());
            ps.setString(9, nv.getTaiKhoan());
            ps.setString(10, nv.getMatKhau());
//            ps.setInt(12, nv.getIdNV());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    

}
