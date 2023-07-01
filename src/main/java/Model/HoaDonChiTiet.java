/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class HoaDonChiTiet {
    private int idHDCT;
    private int soLuong;
    private float donGia;
    private int idHD;
    private int idCTSP;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int idHDCT, int soLuong, float donGia, int idHD, int idCTSP) {
        this.idHDCT = idHDCT;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.idHD = idHD;
        this.idCTSP = idCTSP;
    }

    public int getIdHDCT() {
        return idHDCT;
    }

    public void setIdHDCT(int idHDCT) {
        this.idHDCT = idHDCT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(int idCTSP) {
        this.idCTSP = idCTSP;
    }
    
    
}
