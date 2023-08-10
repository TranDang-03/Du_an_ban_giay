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
                + "    ISNULL(SUM(hdct.soLuong * hdct.donGia), 0) AS totalRevenue\n"
                + "FROM \n"
                + "    Months m\n"
                + "LEFT JOIN hoa_don hd ON MONTH(hd.ngayTao) = m.month AND YEAR(hd.ngayTao) = @selectedYear AND hd.trangThai = 0\n"
                + "LEFT JOIN hoa_don_chi_tiet hdct ON hd.idHoaDon = hdct.idHoaDon\n"
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

    public static void main(String[] args) {
        List<ThongKeViewModel> list = new ThongKeRepository().thongKeDoanhThuTheoThang(2023);
        for (ThongKeViewModel x : list) {
            System.out.println(x.toString());
        }
    }
}
