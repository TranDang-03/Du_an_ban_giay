/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ChiTietSP;
import Util.DBConnect;
import ViewModels.SPCTViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamCTRepository {

    public List<SPCTViewModel> all() {
        String sql = "SELECT dbo.chi_tiet_san_pham.idChiTietSP, dbo.chi_tiet_san_pham.anh, dbo.chi_tiet_san_pham.maCTSP, dbo.san_pham.tenSanPham, dbo.chi_tiet_san_pham.soLuongTon, dbo.kich_co.tenKichCo, dbo.mau_sac.tenMauSac, \n"
                + "                  dbo.thuong_hieu.tenThuongHieu, dbo.dong_sp.tenDongSP, dbo.kieu_dang.tenKieuDang, dbo.chat_lieu.daChinh, dbo.chi_tiet_san_pham.giaNhap, dbo.chi_tiet_san_pham.giaBan, dbo.NSX.tenNSX\n"
                + "FROM     dbo.chat_lieu INNER JOIN\n"
                + "                  dbo.chi_tiet_san_pham ON dbo.chat_lieu.idChatLieu = dbo.chi_tiet_san_pham.idChatLieu INNER JOIN\n"
                + "                  dbo.dong_sp ON dbo.chi_tiet_san_pham.idDongSP = dbo.dong_sp.idDongSP INNER JOIN\n"
                + "                  dbo.kich_co ON dbo.chi_tiet_san_pham.idKichCo = dbo.kich_co.idKichCo INNER JOIN\n"
                + "                  dbo.kieu_dang ON dbo.chi_tiet_san_pham.idKieuDang = dbo.kieu_dang.idKieuDang INNER JOIN\n"
                + "                  dbo.mau_sac ON dbo.chi_tiet_san_pham.idMauSac = dbo.mau_sac.idMauSac INNER JOIN\n"
                + "                  dbo.NSX ON dbo.chi_tiet_san_pham.idNSX = dbo.NSX.idNSX INNER JOIN\n"
                + "                  dbo.san_pham ON dbo.chi_tiet_san_pham.idSanPham = dbo.san_pham.idSanPham INNER JOIN\n"
                + "                  dbo.thuong_hieu ON dbo.chi_tiet_san_pham.idThuongHieu = dbo.thuong_hieu.idThuongHieu";

        List<SPCTViewModel> list = new ArrayList<>();
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SPCTViewModel ctsp = new SPCTViewModel(rs.getInt("idChiTietSP"),
                        rs.getString("anh"), rs.getString("maCTSP"), rs.getString("tenSanPham"), rs.getInt("soLuongTon"), rs.getString("tenKichCo"), rs.getString("tenMauSac"),
                        rs.getString("tenThuongHieu"), rs.getString("tenDongSP"), rs.getString("tenKieuDang"),
                        rs.getString("daChinh"), rs.getFloat("giaNhap"), rs.getFloat("giaBan"), rs.getString("tenNSX"));

                list.add(ctsp);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean add(ChiTietSP ctsp) {
        int check = 0;
        String query = """
                       INSERT INTO [dbo].[chi_tiet_san_pham]
                                  ([anh]
                                  ,[maCTSP]
                                  ,[idSanPham]
                                  ,[soLuongTon]
                                  ,[idKichCo]
                                  ,[idMauSac]
                                  ,[idThuongHieu]
                                  ,[idDongSP]
                                  ,[idKieuDang]
                                  ,[idChatLieu]
                                  ,[giaNhap]
                                  ,[giaBan]
                                  ,[idNSX])
                            VALUES
                                  (?,?,?,?,?,?,?,?,?,?,?,?,?)
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ctsp.getAnh());
            ps.setObject(2, ctsp.getMaCTSP());
            ps.setObject(3, ctsp.getIdSP());
            ps.setObject(4, ctsp.getSoLuongTon());
            ps.setObject(5, ctsp.getIdKC());
            ps.setObject(6, ctsp.getIdMS());
            ps.setObject(7, ctsp.getIdTH());
            ps.setObject(8, ctsp.getIdDong());
            ps.setObject(9, ctsp.getIdKD());
            ps.setObject(10, ctsp.getIdCL());
            ps.setObject(11, ctsp.getGiaNhap());
            ps.setObject(12, ctsp.getGiaBan());
            ps.setObject(13, ctsp.getIdNSX());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public int getSLTonByIDSPCT(String id) {
        String query = """
                         SELECT [soLuongTon]
                         FROM [dbo].[chi_tiet_san_pham]
                         WHERE [idChiTietSP] =  ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int sl = rs.getInt(1);
                return sl;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return -1;
    }
/////1
    public List<String> getListSP() {
        String query = """
                       SELECT [tenSanPham]
                         FROM [dbo].[san_pham]
                       Order By [maSanPham] asc
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String sp = rs.getString(1);
                lists.add(sp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getSPByID(String id) {
        String query = """
                       SELECT [tenSanPham]
                         FROM [dbo].[san_pham]
                       Where [idSanPham] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getIDBySP(String ten) {
        String query = """
                       SELECT [idSanPham]
                         FROM [dbo].[san_pham]
                       Where [tenSanPham] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
///2
    public List<String> getListNSX() {
        String query = """
                       SELECT [tenNSX]
                         FROM [dbo].[NSX]
                       Order By [maNSX] asc
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String nsx = rs.getString(1);
                lists.add(nsx);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getNSXByID(String id) {
        String query = """
                       SELECT [tenNSX]
                         FROM [dbo].[NSX]
                       Where [idNSX] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getIDByNSX(String ten) {
        String query = """
                       SELECT [idNSX]
                         FROM [dbo].[NSX]
                       Where [tenNSX] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
///3
    public List<String> getListMauSac() {
        String query = """
                       SELECT [tenMauSac]
                         FROM [dbo].[mau_sac]
                       Order By [maMauSac] asc
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String ms = rs.getString(1);
                lists.add(ms);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getMauSacByID(String id) {
        String query = """
                       SELECT [tenMauSac]
                         FROM [dbo].[mau_sac]
                       Where [idMauSac] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getIDByMauSac(String ten) {
        String query = """
                       SELECT [idMauSac]
                         FROM [dbo].[mau_sac]
                       Where [tenMauSac] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
////4
    public List<String> getListDongSP() {
        String query = """
                       SELECT [tenDongSP]
                         FROM [dbo].[dong_sp]
                       Order By [maDongSP] asc
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String dsp = rs.getString(1);
                lists.add(dsp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getDongSPByID(String id) {
        String query = """
                       SELECT [tenDongSP]
                         FROM [dbo].[dong_sp]
                       Where [idDongSP] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getIDByDongSP(String ten) {
        String query = """
                       SELECT [idDongSP]
                         FROM [dbo].[dong_sp]
                       Where [tenDongSP] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
/////5
    public List<String> getListKichCo() {
        String query = """
                       SELECT [tenKichCo]
                         FROM [dbo].[kich_co]
                       Order By [maKichCo] asc
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String dsp = rs.getString(1);
                lists.add(dsp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getKichCoByID(String id) {
        String query = """
                       SELECT [tenKichCo]
                         FROM [dbo].[kich_co]
                       Where [idKichCo] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getIDByKichCo(String ten) {
        String query = """
                       SELECT [idKichCo]
                         FROM [dbo].[kich_co]
                       Where [tenKichCo] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
   /////6
    public List<String> getListThuongHieu() {
        String query = """
                       SELECT [tenThuongHieu]
                         FROM [dbo].[thuong_hieu]
                       Order By [maThuongHieu] asc
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String dsp = rs.getString(1);
                lists.add(dsp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getThuongHieuByID(String id) {
        String query = """
                       SELECT [tenThuongHieu]
                         FROM [dbo].[thuong_hieu]
                       Where [idThuongHieu] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getIDByThuongHieu(String ten) {
        String query = """
                       SELECT [idThuongHieu]
                         FROM [dbo].[thuong_hieu]
                       Where [tenThuongHieu] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    /////7
    public List<String> getListKieuDang() {
        String query = """
                       SELECT [tenKieuDang]
                         FROM [dbo].[kieu_dang]
                       Order By [maKieuDang] asc
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String dsp = rs.getString(1);
                lists.add(dsp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getKieuDangByID(String id) {
        String query = """
                       SELECT [tenKieuDang]
                         FROM [dbo].[kieu_dang]
                       Where [idKieuDang] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getIDByKieuDang(String ten) {
        String query = """
                       SELECT [idKieuDang]
                         FROM [dbo].[kieu_dang]
                       Where [tenKieuDang] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    ////8
        public List<String> getListChatLieu() {
        String query = """
                       SELECT [daChinh]
                         FROM [dbo].[chat_lieu]
                       Order By [maChatLieu] asc
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<String> lists = new ArrayList<>();
            while (rs.next()) {
                String dsp = rs.getString(1);
                lists.add(dsp);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getChatLieuByID(String id) {
        String query = """
                       SELECT [daChinh]
                         FROM [dbo].[chat_lieu]
                       Where [idChatLieu] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getIDByChatLieu(String ten) {
        String query = """
                       SELECT [idChatLieu]
                         FROM [dbo].[chat_lieu]
                       Where [daChinh] = ?
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
