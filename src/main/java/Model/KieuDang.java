/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class KieuDang {

    private int idKD;
    private String maKD;
    private String tenKD;
    private int trangThai;

    public KieuDang() {
    }

    public KieuDang(int idKD, String maKD, String tenKD, int trangThai) {
        this.idKD = idKD;
        this.maKD = maKD;
        this.tenKD = tenKD;
        this.trangThai = trangThai;
    }

    public KieuDang(String maKD, String tenKD, int trangThai) {
        this.maKD = maKD;
        this.tenKD = tenKD;
        this.trangThai = trangThai;
    }

    public int getIdKD() {
        return idKD;
    }

    public void setIdKD(int idKD) {
        this.idKD = idKD;
    }

    public String getMaKD() {
        return maKD;
    }

    public void setMaKD(String maKD) {
        this.maKD = maKD;
    }

    public String getTenKD() {
        return tenKD;
    }

    public void setTenKD(String tenKD) {
        this.tenKD = tenKD;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KieuDang{" + "idKD=" + idKD + ", maKD=" + maKD + ", tenKD=" + tenKD + ", trangThai=" + trangThai + '}';
    } 
    
}
