/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class ChatLieu {
    private int idCL;
    private String maCL;
    private String daChinh;
    private String daPhu;
    private String daNgoai;
    private String lopLot;
    private int trangThai;

    public ChatLieu() {
    }

    public ChatLieu(int idCL, String maCL, String daChinh, String daPhu, String daNgoai, String lopLot, int trangThai) {
        this.idCL = idCL;
        this.maCL = maCL;
        this.daChinh = daChinh;
        this.daPhu = daPhu;
        this.daNgoai = daNgoai;
        this.lopLot = lopLot;
        this.trangThai = trangThai;
    }

    public int getIdCL() {
        return idCL;
    }

    public void setIdCL(int idCL) {
        this.idCL = idCL;
    }

    public String getMaCL() {
        return maCL;
    }

    public void setMaCL(String maCL) {
        this.maCL = maCL;
    }

    public String getDaChinh() {
        return daChinh;
    }

    public void setDaChinh(String daChinh) {
        this.daChinh = daChinh;
    }

    public String getDaPhu() {
        return daPhu;
    }

    public void setDaPhu(String daPhu) {
        this.daPhu = daPhu;
    }

    public String getDaNgoai() {
        return daNgoai;
    }

    public void setDaNgoai(String daNgoai) {
        this.daNgoai = daNgoai;
    }

    public String getLopLot() {
        return lopLot;
    }

    public void setLopLot(String lopLot) {
        this.lopLot = lopLot;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
    
}
