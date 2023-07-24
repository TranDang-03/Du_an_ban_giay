/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhachHang;
import Model.KhuyenMai;
import Model.KichCo;
import Model.MauSac;
import Model.NhanVien;
import Model.ThuongHieu;
import Repository.BanHangRepository;
import Repository.KhachHangRepository;
import Repository.KhuyenMaiRepository;
import Repository.KichCoRepository;
import Repository.MauSacRepository;
import Repository.NhanVienRepository;
import Repository.ThuongHieuRepository;
import java.util.List;
import view_model.CTSPBanHang;
import view_model.HDCTBanHang;
import view_model.HoaDonViewModel;

/**
 *
 * @author PC
 */
public class BanHangService {

    private MauSacRepository mauSac = new MauSacRepository();

    private KichCoRepository kichCo = new KichCoRepository();

    private ThuongHieuRepository thuongHieu = new ThuongHieuRepository();

    private BanHangRepository banHang = new BanHangRepository();

    private KhuyenMaiRepository khuyenMai = new KhuyenMaiRepository();

    private KhachHangRepository khachHang = new KhachHangRepository();

    private NhanVienRepository nhanVien = new NhanVienRepository();

    public List<MauSac> getAllMauSac() {
        return this.mauSac.all();
    }

    public List<KichCo> getAllKichCo() {
        return this.kichCo.all();
    }

    public List<ThuongHieu> getAllThuongHieu() {
        return this.thuongHieu.all();
    }

    public List<String> getAllKhuyenMai() {
        return this.banHang.getAllMaKhuyenMai();
    }

    public List<NhanVien> getAllNhanVien() {
        return this.nhanVien.all();
    }

    public List<KhachHang> getAllKhachHang() {
        return this.khachHang.getAll();
    }

    public List<String> getAllTenMauSac() {
        return this.banHang.getAllTenMau();
    }

    public List<String> getAllTenThuongHieu() {
        return this.banHang.getAllTenThuongHieu();
    }

    public List<Integer> getAllTenKichCo() {
        return this.banHang.getAllTenKichCo();
    }

    public List<String> getALLMaKhuyenMai() {
        return this.banHang.getAllMaKhuyenMai();
    }

    public List<CTSPBanHang> getAllCTSP() {
        return this.banHang.getAllCTSP();
    }

    public List<HoaDonViewModel> getAllHDChuaThanhToan() {
        return this.banHang.getAllHoaDonChuaThanhToan();
    }

    public List<HoaDonViewModel> getAllHDDaThanhToan() {
        return this.banHang.getAllHoaDonDaThanhToan();
    }

    public List<HoaDonViewModel> getAllHD() {
        return this.banHang.getAllHoaDon();
    }

    public List<CTSPBanHang> searchSP(String name) {
        return this.banHang.searchSPCT(name);
    }

    public List<CTSPBanHang> giaCaoXuongThap(List<CTSPBanHang> list) {
        list.sort((o1, o2) -> {
            int x1 = (int) Math.round(o1.getGiaBan());
            int x2 = (int) Math.round(o2.getGiaBan());
            return x1 - x2;
        });
        return list;
    }

    public List<String> getAllTenNhanVien() {
        return this.banHang.getAllTenNhanVien();
    }

    public List<HDCTBanHang> getAllHDCTTheoMaHD(String maHD) {
        return this.banHang.getAllHDCTTheoMaHD(maHD);
    }
    
    public boolean addHoaDon(String maKH){
        return this.banHang.addHoaDon(maKH);
    }
}
