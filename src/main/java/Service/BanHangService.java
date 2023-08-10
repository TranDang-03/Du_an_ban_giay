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

    public boolean addHoaDon(String maKH,String maNV) {
        return this.banHang.addHoaDon(maKH,maNV);
    }

    public List<HDCTBanHang> checkTonTaiSP(String maHD, int idCTSP) {
        return this.banHang.checkTonTaiSP(maHD, idCTSP);
    }

    public boolean themSPVaoHDCT(int soLuong, float donGia, String maHD, int idCTSP) {
        return this.banHang.themSPVaoHDCT(soLuong, donGia, maHD, idCTSP);
    }

    public boolean suaSoLuong(int soLuong, int idCTSP, String maHD) {
        return this.banHang.suaSoLuong(soLuong, idCTSP, maHD);
    }

    public boolean suaSoLuongCTSP(int soLuong, int idCTSP) {
        return this.banHang.suaSoLuongCTSP(soLuong, idCTSP);
    }

    public Float getTongTienTheoMaHD(String maHD) {
        return this.banHang.tinhTongTienSanPhamTheoHoaDon(maHD);
    }

    public Integer laySoLuongSPTrongHDCT(String maHD, int idCTSP) {
        return this.banHang.laySoLuongSPTrongHDCT(maHD, idCTSP);
    }

    public boolean xoaSPHDCT(int idHDCT, String maHD) {
        return this.banHang.xoaSPDaCot(idHDCT, maHD);
    }

    public Integer layIDCTSPTheoMAHDvIdCTHD(int idCTHD, String maHD) {
        return this.banHang.layIDCTSPTheoMAHD(idCTHD, maHD);
    }

    public Integer laySLTonTheoIdCTSP(int idCTSP) {
        return this.banHang.laySLTonTheoidCTSP(idCTSP);
    }

    public Integer layIdHDCTTheoIdHDVaIdCTSP(int idCTSP, String maHD) {
        return this.banHang.layIdHDCTTheoIdHDVaIdCTSP(idCTSP, maHD);
    }

    public List<String> getAllMaNV() {
        return this.banHang.getAllMaNhanVien();
    }

    public boolean updateHD(String maKH, String maNV, String maHD) {
        return this.banHang.updateHoaDon(maKH, maNV, maHD);
    }

    public List<HoaDonViewModel> listGetAllHDPage(int rowoffset) {
        return this.banHang.getAllHDPage(rowoffset);
    }

    public List<String> getAllMaKMTheoGiaApDung(float giaApDung) {
        return this.banHang.getMaKMTheoGiaApDung(giaApDung);
    }

    public Integer loaiKM(String maKM) {
        return this.banHang.getLoaiKhuyenMai(maKM);
    }

    public Integer giaTriKM(String maKM) {
        return this.banHang.getGiaTriKM(maKM);
    }

    public Integer getTrangThaiKM(String maKM) {
        return this.banHang.getGiaTriKM(maKM);
    }
    
    public boolean thanhToanHD(String maKH, String maNV, float thanhTien, String maKM, String maHD){
        return this.banHang.thanhToanHD(maKH, maNV, thanhTien, maKM, maHD);
    }
}
