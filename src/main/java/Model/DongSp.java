/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class DongSp {

    private int idDong;
    private String maDong;
    private String tenDong;
    private int trangThai;

    public DongSp() {
    }

    public DongSp(int idDong, String maDong, String tenDong, int trangThai) {
        this.idDong = idDong;
        this.maDong = maDong;
        this.tenDong = tenDong;
        this.trangThai = trangThai;
    }

    public int getIdDong() {
        return idDong;
    }

    public void setIdDong(int idDong) {
        this.idDong = idDong;
    }

    public String getMaDong() {
        return maDong;
    }

    public void setMaDong(String maDong) {
        this.maDong = maDong;
    }

    public String getTenDong() {
        return tenDong;
    }

    public void setTenDong(String tenDong) {
        this.tenDong = tenDong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

   
}
