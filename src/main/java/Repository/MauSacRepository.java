/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;


import Model.MauSac;
import Util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MauSacRepository {
      public ArrayList<MauSac> all() {
        ArrayList<MauSac> list = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM mau_sac";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idMauSac");
                String maSP = rs.getString("maMauSac");
                String tenSP = rs.getString("tenMauSac");
                int trangThai = rs.getInt("trangThai");

                MauSac ms = new MauSac(id, maSP, tenSP, trangThai);
                list.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(MauSac ms) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = " INSERT INTO mau_sac(maMauSac,tenMauSac,trangThai) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ms.getMaMS());
            ps.setString(2, ms.getTenMS());
            ps.setInt(3, ms.getTrangThai());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(MauSac ms) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "UPDATE mau_sac SET maMauSac =?,tenMauSac = ?,trangThai = ? WHERE idMauSac = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ms.getMaMS());
            ps.setString(2, ms.getTenMS());
            ps.setInt(3, ms.getTrangThai());
            ps.setInt(4, ms.getIdMS());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
