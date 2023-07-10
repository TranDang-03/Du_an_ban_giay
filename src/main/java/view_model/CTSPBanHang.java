/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view_model;

/**
 *
 * @author PC
 */
public class CTSPBanHang {

    int idCTSP;
    String tenSP;
    String dongSP;
    String thuongHieu;
    int size;
    float giaBan;
    int soLuongTon;
    String tenMau;

    public CTSPBanHang(int idCTSP, String tenSP, String dongSP, String thuongHieu, int size, float giaBan, int soLuongTon, String tenMau) {
        this.idCTSP = idCTSP;
        this.tenSP = tenSP;
        this.dongSP = dongSP;
        this.thuongHieu = thuongHieu;
        this.size = size;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
        this.tenMau = tenMau;
    }

    public CTSPBanHang(String tenSP, String dongSP, String thuongHieu, int size, float giaBan, int soLuongTon, String tenMau) {
        this.tenSP = tenSP;
        this.dongSP = dongSP;
        this.thuongHieu = thuongHieu;
        this.size = size;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
        this.tenMau = tenMau;
    }

    public CTSPBanHang() {
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public int getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(int idCTSP) {
        this.idCTSP = idCTSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getDongSP() {
        return dongSP;
    }

    public void setDongSP(String dongSP) {
        this.dongSP = dongSP;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    @Override
    public String toString() {
        return "CTSPBanHang{" + "idCTSP=" + idCTSP + ", tenSP=" + tenSP + ", dongSP=" + dongSP + ", thuongHieu=" + thuongHieu + ", size=" + size + ", giaBan=" + giaBan + ", soLuongTon=" + soLuongTon + ", tenMau=" + tenMau + '}';
    }

}
