/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhanVien {

    private int idNV;
    private String maNV;
    private String tenNV;
    private boolean gioiTinh;
    private Date ngSinh;
    private String diaChi;
    private String sdt;
    private int chucVu;
    private int trangThai;
    private float luong;
    private String taiKhoan;
    private String matKhau;

    public NhanVien() {
    }

    public NhanVien(int idNV, String maNV, String tenNV, boolean gioiTinh, Date ngSinh, String diaChi, String sdt, int chucVu, int trangThai, float luong, String taiKhoan, String matKhau) {
        this.idNV = idNV;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.ngSinh = ngSinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
        this.luong = luong;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgSinh() {
        return ngSinh;
    }

    public void setNgSinh(Date ngSinh) {
        this.ngSinh = ngSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getChucVu() {
        return chucVu;
    }

    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "idNV=" + idNV + ", maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", ngSinh=" + ngSinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", chucVu=" + chucVu + ", trangThai=" + trangThai + ", luong=" + luong + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + '}';
    }

}
