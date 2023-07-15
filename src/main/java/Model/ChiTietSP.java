/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class ChiTietSP {
    private int idChiTietSP;
    private String idNSX;
    private String idSP;
    private String idMS;
    private String idDong;
    private String idCL;
    private String idKC;
    private String idKD;
    private String idTH;
    private String maCTSP;
    private int soLuongTon;
    private float giaNhap;
    private float giaBan;
    private String anh;

    public ChiTietSP() {
    }

    public ChiTietSP(int idChiTietSP, String idNSX, String idSP, String idMS, String idDong, String idCL, String idKC, String idKD, String idTH, String maCTSP, int soLuongTon, float giaNhap, float giaBan, String anh) {
        this.idChiTietSP = idChiTietSP;
        this.idNSX = idNSX;
        this.idSP = idSP;
        this.idMS = idMS;
        this.idDong = idDong;
        this.idCL = idCL;
        this.idKC = idKC;
        this.idKD = idKD;
        this.idTH = idTH;
        this.maCTSP = maCTSP;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.anh = anh;
    }

    public int getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(int idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public String getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(String idNSX) {
        this.idNSX = idNSX;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdMS() {
        return idMS;
    }

    public void setIdMS(String idMS) {
        this.idMS = idMS;
    }

    public String getIdDong() {
        return idDong;
    }

    public void setIdDong(String idDong) {
        this.idDong = idDong;
    }

    public String getIdCL() {
        return idCL;
    }

    public void setIdCL(String idCL) {
        this.idCL = idCL;
    }

    public String getIdKC() {
        return idKC;
    }

    public void setIdKC(String idKC) {
        this.idKC = idKC;
    }

    public String getIdKD() {
        return idKD;
    }

    public void setIdKD(String idKD) {
        this.idKD = idKD;
    }

    public String getIdTH() {
        return idTH;
    }

    public void setIdTH(String idTH) {
        this.idTH = idTH;
    }

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @Override
    public String toString() {
        return "ChiTietSP{" + "idChiTietSP=" + idChiTietSP + ", idNSX=" + idNSX + ", idSP=" + idSP + ", idMS=" + idMS + ", idDong=" + idDong + ", idCL=" + idCL + ", idKC=" + idKC + ", idKD=" + idKD + ", idTH=" + idTH + ", maCTSP=" + maCTSP + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", anh=" + anh + '}';
    }
    
}