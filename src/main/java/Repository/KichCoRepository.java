/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.KichCo;
import Util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class KichCoRepository {

    public ArrayList<KichCo> all() {
        ArrayList<KichCo> list = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM kich_co";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idKichCo");
                String maSP = rs.getString("maKichCo");
                String tenSP = rs.getString("tenKichCo");
                int trangThai = rs.getInt("trangThai");

                KichCo kc = new KichCo(id, maSP, tenSP, trangThai);
                list.add(kc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(KichCo kc) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = " INSERT INTO kich_co(maKichCo,tenKichCo,trangThai) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kc.getMaKC());
            ps.setString(2, kc.getTenKC());
            ps.setInt(3, kc.getTrangThai());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(KichCo kc) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "UPDATE kich_co SET maKichCo =?,tenKichCo = ?,trangThai = ? WHERE idKichCo = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kc.getMaKC());
            ps.setString(2, kc.getTenKC());
            ps.setInt(3, kc.getTrangThai());
            ps.setInt(4, kc.getIdKC());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
