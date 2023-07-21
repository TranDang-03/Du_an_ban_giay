/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class ThongTinHD {
    private String maHD;
    private String tenNV;
    private Date ngayTao;
    private String tenKhachHang;
    private float thanhTien;
    private String khuyenMai;
    private int trangThai;

    public ThongTinHD() {
    }

    public ThongTinHD(String maHD, String tenNV, Date ngayTao, String tenKhachHang, float thanhTien, String khuyenMai, int trangThai) {
        this.maHD = maHD;
        this.tenNV = tenNV;
        this.ngayTao = ngayTao;
        this.tenKhachHang = tenKhachHang;
        this.thanhTien = thanhTien;
        this.khuyenMai = khuyenMai;
        this.trangThai = trangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ThongTinHD{" + "maHD=" + maHD + ", tenNV=" + tenNV + ", ngayTao=" + ngayTao + ", tenKhachHang=" + tenKhachHang + ", thanhTien=" + thanhTien + ", khuyenMai=" + khuyenMai + ", trangThai=" + trangThai + '}';
    }
    
}
