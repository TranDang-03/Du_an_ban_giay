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
public class KhachHang {

    private int idKH;
    private String maKH;
    private String tenKH;
    private boolean gioiTinh;
    private Date ngSinh;
    private String sdt;
    private String diaChi;
    private int trangThai;

    public KhachHang(int idKH, String maKH, String tenKH, boolean gioiTinh, Date ngSinh, String sdt, String diaChi, int trangThai) {
        this.idKH = idKH;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.ngSinh = ngSinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public KhachHang(String maKH, String tenKH, boolean gioiTinh, Date ngSinh, String sdt, String diaChi, int trangThai) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.ngSinh = ngSinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public KhachHang() {
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "idKH=" + idKH + ", maKH=" + maKH + ", tenKH=" + tenKH + ", gioiTinh=" + gioiTinh + ", ngSinh=" + ngSinh + ", sdt=" + sdt + ", diaChi=" + diaChi + ", trangThai=" + trangThai + '}';
    }

}
