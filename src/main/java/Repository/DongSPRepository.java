/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import Model.DongSp;
import Util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class DongSPRepository {
    public ArrayList<DongSp> all() {
        ArrayList<DongSp> list = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM dong_sp";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idDongSP");
                String maDongSP = rs.getString("maDongSP");
                String tenDongSP = rs.getString("tenDongSP");
                int trangThai = rs.getInt("trangThai");

                DongSp dsp = new DongSp(id, maDongSP, tenDongSP, trangThai);
                list.add(dsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(DongSp dsp) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = " INSERT INTO dong_sp(maDongSP,tenDongSP,trangThai) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dsp.getMaDong());
            ps.setString(2, dsp.getTenDong());
            ps.setInt(3, dsp.getTrangThai());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(DongSp dsp) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "UPDATE dong_sp SET maDongSP =?,tenDongSP = ?,trangThai = ? WHERE idDongSP = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dsp.getMaDong());
            ps.setString(2, dsp.getTenDong());
            ps.setInt(3, dsp.getTrangThai());
            ps.setInt(4, dsp.getIdDong());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
