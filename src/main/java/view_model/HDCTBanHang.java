/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view_model;

/**
 *
 * @author PC
 */
public class HDCTBanHang {

    int id;
    String tenSP;
    int soLuong;
    String loai;
    String hang;
    int size;
    float donGia;

    public HDCTBanHang() {
    }

    public HDCTBanHang(int id, String tenSP, int soLuong, String loai, String hang, int size, float donGia) {
        this.id = id;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.loai = loai;
        this.hang = hang;
        this.size = size;
        this.donGia = donGia;
    }

    public HDCTBanHang(String tenSP, int soLuong, String loai, String hang, int size, float donGia) {
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.loai = loai;
        this.hang = hang;
        this.size = size;
        this.donGia = donGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "HDCTBanHang{" + "id=" + id + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", loai=" + loai + ", hang=" + hang + ", size=" + size + ", donGia=" + donGia + '}';
    }

}
