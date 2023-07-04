/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class NSX {

    private int idNSX;
    private String maNSX;
    private String tenNSX;
    private int trangThai;

    public NSX() {
    }

    public NSX(int idNSX, String maNSX, String tenNSX, int trangThai) {
        this.idNSX = idNSX;
        this.maNSX = maNSX;
        this.tenNSX = tenNSX;
        this.trangThai = trangThai;
    }

    public NSX(String maNSX, String tenNSX, int trangThai) {
        this.maNSX = maNSX;
        this.tenNSX = tenNSX;
        this.trangThai = trangThai;
    }
    

    public int getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(int idNSX) {
        this.idNSX = idNSX;
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NSX{" + "idNSX=" + idNSX + ", maNSX=" + maNSX + ", tenNSX=" + tenNSX + ", trangThai=" + trangThai + '}';
    }
    
}
