/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view_model;

/**
 *
 * @author PC
 */
public class ThongKeSanPhamViewModel {

    int soLuongBan;
    String tenSP;

    public ThongKeSanPhamViewModel(int soLuongBan, String tenSP) {
        this.soLuongBan = soLuongBan;
        this.tenSP = tenSP;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    @Override
    public String toString() {
        return "ThongKeSanPhamViewModel{" + "soLuongBan=" + soLuongBan + ", tenSP=" + tenSP + '}';
    }

}
