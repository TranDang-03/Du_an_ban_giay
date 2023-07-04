/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.KichCo;
import Model.KieuDang;
import Util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class KieuDangRepository {

    public List<KieuDang> getAll() {

        String query = "SELECT [idKieuDang]\n"
                + "      ,[maKieuDang]\n"
                + "      ,[tenKieuDang]\n"
                + "      ,[trangThai]\n"
                + "  FROM [dbo].[kieu_dang]";

        List<KieuDang> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KieuDang kd = new KieuDang(rs.getInt("idKieuDang"), rs.getString("maKieuDang"), rs.getString("tenKieuDang"), rs.getInt("trangThai"));
                list.add(kd);
            }
            return list;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public KieuDang getOne(int id) {

        String query = "SELECT [maKieuDang]\n"
                + "      ,[tenKieuDang]\n"
                + "      ,[trangThai]\n"
                + "  FROM [dbo].[kieu_dang] WHERE idKieuDang = ?";

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new KieuDang(rs.getString("maKieuDang"), rs.getString("tenKieuDang"), rs.getInt("trangThai"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean addKieuDang(KieuDang kieudang) {

        String query = "INSERT INTO [dbo].[kieu_dang]\n"
                + "           ([maKieuDang]\n"
                + "           ,[tenKieuDang]\n"
                + "           ,[trangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int check = 0;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, kieudang.getMaKD());
            ps.setObject(2, kieudang.getTenKD());
            ps.setObject(3, kieudang.getTrangThai());
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateKieuDang(int id, KieuDang kd) {

        String query = "UPDATE [dbo].[kieu_dang]\n"
                + "   SET [maKieuDang] = ?\n"
                + "      ,[tenKieuDang] = ?\n"
                + "      ,[trangThai] = ?\n"
                + " WHERE idKieuDang = ?";
        int check = 0;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, kd.getMaKD());
            ps.setObject(2, kd.getTenKD());
            ps.setObject(3, kd.getTrangThai());
            ps.setObject(4, id);

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean deleteKieuDang(int id) {

        String query = "UPDATE [dbo].[kieu_dang]\n"
                + "   SET [trangThai] = 0\n"
                + " WHERE idKieuDang = ?";
        int check = 0;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }
}
