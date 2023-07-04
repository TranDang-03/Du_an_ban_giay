/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.NSX;
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
public class NhaSanXuatRepository {

    public List<NSX> getAll() {

        String query = "SELECT [idNSX]\n"
                + "      ,[maNSX]\n"
                + "      ,[tenNSX]\n"
                + "      ,[trangThai]\n"
                + "  FROM [dbo].[NSX]";

        List<NSX> list = new ArrayList<>();

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NSX nsx = new NSX(rs.getInt("idNSX"), rs.getString("maNSX"), rs.getString("tenNSX"), rs.getInt("trangThai"));
                list.add(nsx);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public NSX getOne(int id) {

        String query = "SELECT [maNSX]\n"
                + "      ,[tenNSX]\n"
                + "      ,[trangThai]\n"
                + "  FROM [dbo].[NSX] WHERE idNSX = ?";

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new NSX(rs.getString("maNSX"), rs.getString("tenNSX"), rs.getInt("trangThai"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean addNSX(NSX nsx) {
        String query = "INSERT INTO [dbo].[NSX]\n"
                + "           ([maNSX]\n"
                + "           ,[tenNSX]\n"
                + "           ,[trangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?)";

        int check = 0;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nsx.getMaNSX());
            ps.setObject(2, nsx.getTenNSX());
            ps.setObject(3, nsx.getTrangThai());
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateNSX(int id, NSX nsx) {

        String query = "UPDATE [dbo].[NSX]\n"
                + "   SET [maNSX] = ?\n"
                + "      ,[tenNSX] = ?\n"
                + "      ,[trangThai] = ?\n"
                + " WHERE idNSX = ?";
        int check = 0;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nsx.getMaNSX());
            ps.setObject(2, nsx.getTenNSX());
            ps.setObject(3, nsx.getTrangThai());
            ps.setObject(4, id);

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean deleteNSX(int id) {

        String query = "UPDATE [dbo].[NSX]\n"
                + "   SET [trangThai] = 0\n"
                + " WHERE idNSX = ?";
        int check = 0;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        for (NSX list : new NhaSanXuatRepository().getAll()) {
            System.out.println(list.toString());
        }
    }
}
