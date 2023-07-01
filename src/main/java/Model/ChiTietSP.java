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
    private int idNSX;
    private int idSP;
    private int idMS;
    private int idDong;
    private int idCL;
    private int idKC;
    private int idKD;
    private int idTH;
    private String maCTSP;
    private int soLuongTon;
    private float giaNhap;
    private float giaBan;
    private String anh;

    public ChiTietSP() {
    }

    public ChiTietSP(int idChiTietSP, int idNSX, int idSP, int idMS, int idDong, int idCL, int idKC, int idKD, int idTH, String maCTSP, int soLuongTon, float giaNhap, float giaBan, String anh) {
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

    public int getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(int idNSX) {
        this.idNSX = idNSX;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public int getIdMS() {
        return idMS;
    }

    public void setIdMS(int idMS) {
        this.idMS = idMS;
    }

    public int getIdDong() {
        return idDong;
    }

    public void setIdDong(int idDong) {
        this.idDong = idDong;
    }

    public int getIdCL() {
        return idCL;
    }

    public void setIdCL(int idCL) {
        this.idCL = idCL;
    }

    public int getIdKC() {
        return idKC;
    }

    public void setIdKC(int idKC) {
        this.idKC = idKC;
    }

    public int getIdKD() {
        return idKD;
    }

    public void setIdKD(int idKD) {
        this.idKD = idKD;
    }

    public int getIdTH() {
        return idTH;
    }

    public void setIdTH(int idTH) {
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
    

}
