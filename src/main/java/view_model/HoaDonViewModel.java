/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view_model;

import java.util.Date;

/**
 *
 * @author PC
 */
public class HoaDonViewModel {

    String maHD;
    String tenKH;
    String tenNV;
    String maKM;
    float thanhTien;
    Date ngayTao;
    int TrangThai;
    String maKhachHang;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String maHD, String tenKH, String tenNV, String maKM, float thanhTien, Date ngayTao) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.tenNV = tenNV;
        this.maKM = maKM;
        this.thanhTien = thanhTien;
        this.ngayTao = ngayTao;
    }

    public HoaDonViewModel(String maHD, String tenKH, String tenNV, String maKM, float thanhTien, Date ngayTao, int TrangThai) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.tenNV = tenNV;
        this.maKM = maKM;
        this.thanhTien = thanhTien;
        this.ngayTao = ngayTao;
        this.TrangThai = TrangThai;
    }

    public HoaDonViewModel(String maHD, String tenKH, String tenNV, String maKM, float thanhTien, Date ngayTao, int TrangThai, String maKhachHang) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.tenNV = tenNV;
        this.maKM = maKM;
        this.thanhTien = thanhTien;
        this.ngayTao = ngayTao;
        this.TrangThai = TrangThai;
        this.maKhachHang = maKhachHang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    @Override
    public String toString() {
        return "HoaDonViewModel{" + "maHD=" + maHD + ", tenKH=" + tenKH + ", tenNV=" + tenNV + ", maKM=" + maKM + ", thanhTien=" + thanhTien + ", ngayTao=" + ngayTao + ", TrangThai=" + TrangThai + ", maKhachHang=" + maKhachHang + '}';
    }
}
