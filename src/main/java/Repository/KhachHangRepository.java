/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.KhachHang;
import Util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class KhachHangRepository {

    public List<KhachHang> getAll() {

        String query = "SELECT [idKhachhang]\n"
                + "      ,[maKhachhang]\n"
                + "      ,[tenKhachHang]\n"
                + "      ,[gioiTinh]\n"
                + "      ,[ngaySinh]\n"
                + "      ,[sdt]\n"
                + "      ,[diaChi]\n"
                + "      ,[trangThai]\n"
                + "  FROM [dbo].[khach_hang]";

        List<KhachHang> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getInt("idKhachHang"), rs.getString("maKhachHang"), rs.getString("tenKhachhang"),
                        rs.getBoolean("gioiTinh"), rs.getDate("ngaySinh"), rs.getString("sdt"), rs.getString("diaChi"), rs.getInt("trangThai"));
                list.add(kh);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public KhachHang getOne(int id) {

        String query = "SELECT [maKhachhang]\n"
                + "      ,[tenKhachHang]\n"
                + "      ,[gioiTinh]\n"
                + "      ,[ngaySinh]\n"
                + "      ,[sdt]\n"
                + "      ,[diaChi]\n"
                + "      ,[trangThai]\n"
                + "  FROM [dbo].[khach_hang] WHERE idKhachhang = ?";

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getBoolean("gioiTinh"),
                        rs.getDate("ngaySinh"), rs.getString("sdt"), rs.getString("diaChi"), rs.getInt("trangThai"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean addKhachhang(KhachHang kh) {
        String query = "INSERT INTO [dbo].[khach_hang]\n"
                + "           ([maKhachhang]\n"
                + "           ,[tenKhachHang]\n"
                + "           ,[gioiTinh]\n"
                + "           ,[ngaySinh]\n"
                + "           ,[sdt]\n"
                + "           ,[diaChi]\n"
                + "           ,[trangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        int check = 0;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, kh.getMaKH());
            ps.setObject(2, kh.getTenKH());
            ps.setObject(3, kh.isGioiTinh());
            ps.setObject(4, kh.getNgSinh());
            ps.setObject(5, kh.getSdt());
            ps.setObject(6, kh.getDiaChi());
            ps.setObject(7, kh.getTrangThai());

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean updateKhachHang(int id, KhachHang kh) {
        String query = "UPDATE [dbo].[khach_hang]\n"
                + "   SET [maKhachhang] = ?\n"
                + "      ,[tenKhachHang] = ?\n"
                + "      ,[gioiTinh] = ?\n"
                + "      ,[ngaySinh] = ?\n"
                + "      ,[sdt] = ?\n"
                + "      ,[diaChi] = ?\n"
                + "      ,[trangThai] = ?\n"
                + " WHERE idKhachHang = ?";
        int check = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, kh.getMaKH());
            ps.setObject(2, kh.getTenKH());
            ps.setObject(3, kh.isGioiTinh());
            ps.setObject(4, kh.getNgSinh());
            ps.setObject(5, kh.getSdt());
            ps.setObject(6, kh.getDiaChi());
            ps.setObject(7, kh.getTrangThai());
             ps.setObject(8, id);

            check = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    public boolean deleteKhachHang(int id) {
        String query = "UPDATE [dbo].[khach_hang]\n"
                + "   SET [trangThai] = 0\n"
                + " WHERE idKhachHang = ?";
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
//        for (KhachHang kh : new KhachHangRepository().getAll()) {
//            System.out.println(kh.toString());
//        }

//        new KhachHangRepository().deleteKhachHang(3);
//        System.out.println("den day roi");

        String ngaySinh = "2003-10-10";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localdate = LocalDate.parse(ngaySinh, formatter);
        java.sql.Date birth = java.sql.Date.valueOf(localdate);
        KhachHang kh = new KhachHang("KH005", "Nguyen Thi Hien", false, birth, "0816130199", "Hung Yen", 1);
        new KhachHangRepository().addKhachhang(kh);
        System.out.println("den day roi");
    }
}
