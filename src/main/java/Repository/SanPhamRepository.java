/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.SanPham;
import Util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SanPhamRepository {

    public ArrayList<SanPham> all() {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM san_pham";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idSanPham");
                String maSP = rs.getString("maSanPham");
                String tenSP = rs.getString("tenSanPham");
                int trangThai = rs.getInt("trangThai");

                SanPham sp = new SanPham(id, maSP, tenSP, trangThai);
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(SanPham sp) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = " INSERT INTO san_pham(maSanPham,tenSanPham,trangThai) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setInt(3, sp.getTrangThai());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(SanPham sp) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "UPDATE san_pham SET maSanPham =?,tenSanPham = ?,trangThai = ? WHERE idSanPham = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setInt(3, sp.getTrangThai());
            ps.setInt(4, sp.getIdSP());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

     public boolean delete(int id){
      try {
          Connection conn = DBConnect.getConnection();
          String sql = " DELETE FROM san_pham WHERE idSanPham = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, id);
          ps.execute();
          return true;
      } catch (Exception e) {
      e.printStackTrace();
      return false;
      }
  }
    
}
