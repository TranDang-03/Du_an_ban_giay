/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import view_model.ThongKeSanPhamViewModel;
import view_model.ThongKeViewModel;

/**
 *
 * @author PC
 */
public class ThongKeRepository {

    public List<ThongKeViewModel> thongKeDoanhThuTheoThang(int year) {
        String query = "DECLARE @selectedYear INT = ?;\n"
                + "\n"
                + "WITH Months AS (\n"
                + "    SELECT 1 AS month\n"
                + "    UNION ALL\n"
                + "    SELECT month + 1\n"
                + "    FROM Months\n"
                + "    WHERE month < 12\n"
                + ")\n"
                + "\n"
                + "SELECT \n"
                + "    m.month,\n"
                + "    ISNULL(SUM(hd.thanhTien), 0) AS totalRevenue\n"
                + "FROM \n"
                + "    Months m\n"
                + "LEFT JOIN hoa_don hd ON MONTH(hd.ngayTao) = m.month AND YEAR(hd.ngayTao) = @selectedYear AND hd.trangThai = 0\n"
                + "GROUP BY\n"
                + "    m.month\n"
                + "ORDER BY\n"
                + "    m.month;";
        List<ThongKeViewModel> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeViewModel tk = new ThongKeViewModel(rs.getInt("month"), rs.getFloat("totalRevenue"));
                list.add(tk);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<ThongKeSanPhamViewModel> thongKeSanPhamDaBan() {
        String query = "SELECT \n"
                + "    SUM(hdct.soLuong) AS TotalQuantitySold,\n"
                + "    sp.tenSanPham AS ProductName\n"
                + "FROM \n"
                + "    chi_tiet_san_pham cts\n"
                + "INNER JOIN \n"
                + "    san_pham sp ON cts.idSanPham = sp.idSanPham\n"
                + "INNER JOIN \n"
                + "    hoa_don_chi_tiet hdct ON cts.idChiTietSP = hdct.idChiTietSanPham\n"
                + "INNER JOIN \n"
                + "    hoa_don hd ON hdct.idHoaDon = hd.idHoaDon\n"
                + "WHERE \n"
                + "    hd.trangThai = 0\n"
                + "GROUP BY \n"
                + "    cts.maCTSP, sp.tenSanPham;";

        List<ThongKeSanPhamViewModel> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeSanPhamViewModel tk = new ThongKeSanPhamViewModel(rs.getInt("TotalQuantitySold"), rs.getString("ProductName"));
                list.add(tk);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int thongKeTongDoanhThu() {
        String query = "	SELECT \n"
                + "    SUM(thanhTien) AS TotalRevenue\n"
                + "FROM \n"
                + "    hoa_don\n"
                + "WHERE \n"
                + "    trangThai = 0;";
        int a = 0;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return a = rs.getInt("TotalRevenue");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public static void main(String[] args) {
        List<ThongKeViewModel> list = new ThongKeRepository().thongKeDoanhThuTheoThang(2023);
        for (ThongKeViewModel x : list) {
            System.out.println(x.toString());
        }
    }
}
