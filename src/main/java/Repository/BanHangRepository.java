/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDon;
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
public class BanHangRepository {

    // Hoa don
    public List<String> getAllMaHD() {
        String query = "SELECT [maHoaDon]\n"
                + "  FROM [dbo].[hoa_don]";
        List<String> list = new ArrayList();

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("maHoaDon"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getIDHD(String maHD) {
        String query = "SELECT [idHoaDon]\n"
                + "  FROM [dbo].[hoa_don] WHERE maHoaDon = ?";
        int a;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return a = rs.getInt("idHoaDon");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public String maHD() {
        HoaDon hd = new HoaDon();
        List<String> hdl = getAllMaHD();
        List<Integer> hds = new ArrayList<>();
        for (String hoaDon : hdl) {
            int soHD = Integer.valueOf(hoaDon.substring(2)) + 1;
            hds.add(soHD);
        }
        int j = 0;
        for (Integer integer : hds) {
            int i = integer;
            if (j < i) {
                j = i;
            }
        }
        return "HD" + j;
    }

    public List<String> getAllMaKhuyenMai() {
        String query = "SELECT [tenKhuyenMai]\n"
                + "  FROM [dbo].[khuyen_mai]";
        List<String> list = new ArrayList<>();

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tenKhuyenMai"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getIDKhuyenMai(String maKM) {
        String query = "SELECT [idKhuyenMai]\n"
                + "  FROM [dbo].[khuyen_mai] WHERE tenKhuyenMai = ?";
        int a;
        try(Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);){
            ps.setObject(1, maKM);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return a = rs.getInt("idKhuyenMai");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }

    public List<String> getAllMaKhachHang() {
        String query = "SELECT [tenKhuyenMai]\n"
                + "  FROM [dbo].[khuyen_mai]";
        List<String> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tenKhuyenMai"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getIDKhachHang(String maKH) {
        String query = "SELECT [idKhachhang]\n"
                + "  FROM [dbo].[khach_hang] WHERE maKhachhang = ?";
        int a;

        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maKH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return a = rs.getInt("idKhachHang");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<String> getAllMaNhanVien() {
        String query = "SELECT [maNhanVien]\n"
                + "  FROM [dbo].[nhan_vien]";
        List<String> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("maNhanVien"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getIDNhanVien(String maNV) {
        String query = "SELECT [idNhanVien]\n"
                + "  FROM [dbo].[nhan_vien] WHERE maNhanVien = ?";
        int a;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return a = rs.getInt("idNhanVien");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
//        List<String> list = new BanHangRepository().getAllMaHD();
//        for (String string : list) {
//            System.out.println(list);
//        }

//        int a = new BanHangRepository().getIDHD("HD01");
//        System.out.println(a);
    }
}
