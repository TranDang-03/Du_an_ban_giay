/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ThuongHieu;
import Util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ThuongHieuRepository {
      public ArrayList<ThuongHieu> all() {
        ArrayList<ThuongHieu> list = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM thuong_hieu";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idThuongHieu");
                String maSP = rs.getString("maThuongHieu");
                String tenSP = rs.getString("tenThuongHieu");
                int trangThai = rs.getInt("trangThai");

               ThuongHieu th = new ThuongHieu(id, maSP, tenSP, trangThai);
                list.add(th);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(ThuongHieu th) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = " INSERT INTO thuong_hieu(maThuongHieu,tenThuongHieu,trangThai) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, th.getMaTH());
            ps.setString(2, th.getTenTH());
            ps.setInt(3, th.getTrangThai());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(ThuongHieu th) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "UPDATE thuong_hieu SET maThuongHieu =?,tenThuongHieu = ?,trangThai = ? WHERE idThuongHieu = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, th.getMaTH());
            ps.setString(2, th.getTenTH());
            ps.setInt(3, th.getTrangThai());
            ps.setInt(4, th.getIdTH());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
