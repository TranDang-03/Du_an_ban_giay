/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import Model.KhuyenMai;
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
public class KhuyenMaiRepository {
    public ArrayList<KhuyenMai> all() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM khuyen_mai";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idKhuyenMai = rs.getInt("idKhuyenMai");
                String tenKhuyenMai = rs.getString("tenkhuyenMai");
                int giaTriKM  = rs.getInt("giaTriKM");
                Date ngayBatDau = rs.getDate("ngayBatDau");
                Date ngayKrtThuc = rs.getDate("ngayKetThuc");
                
                int trangThai = rs.getInt("trangThai");
                int loaiKhuyenMai = rs.getInt("loaiKhuyenMai");
                String moTa = rs.getString("moTa");

                 KhuyenMai km = new KhuyenMai(idKhuyenMai, tenKhuyenMai, giaTriKM, ngayBatDau, ngayKrtThuc, trangThai, loaiKhuyenMai, moTa);
                list.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(KhuyenMai km) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = " INSERT INTO khuyen_mai(tenKhuyenMai, giaTriKM, ngayBatDau, ngayKetThuc, trangThai, loaiKhuyenMai, moTa) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, km.getTenKM());
            ps.setInt(2, km.getGiaTri());
            java.sql.Date ngayBatDau = new java.sql.Date(km.getNgayBatDau().getTime());
            ps.setDate(3, ngayBatDau);
            
            
            java.sql.Date ngayKetThuc = new java.sql.Date(km.getNgayKetThuc().getTime());
            ps.setDate(4, ngayKetThuc);
            ps.setInt(5, km.getTrangThai());
            ps.setInt(6, km.getLoaiKM());
            ps.setString(7, km.getMoTa());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(KhuyenMai km) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "UPDATE khuyen_mai SET tenKhuyenMai = ?, giaTriKM = ?, ngayBatDau = ?, ngayKetThuc = ?, trangThai = ?, loaiKhuyenMai = ?, moTa = ? WHERE idKhuyenMai = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, km.getTenKM());
            ps.setInt(2, km.getGiaTri());
            java.sql.Date ngayBatDau = new java.sql.Date(km.getNgayBatDau().getTime());
            ps.setDate(3, ngayBatDau);
            
            
            java.sql.Date ngayKetThuc = new java.sql.Date(km.getNgayKetThuc().getTime());
            ps.setDate(4, ngayKetThuc);
            ps.setInt(5, km.getTrangThai());
            ps.setInt(6, km.getLoaiKM());
            ps.setString(7, km.getMoTa());
            ps.setInt(8, km.getIdKM());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

   
}
