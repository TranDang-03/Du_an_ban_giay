/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view_model;

/**
 *
 * @author PC
 */
public class ThongKeViewModel {

    int month;
    float tongDoanhThu;

    public ThongKeViewModel() {
    }

    public ThongKeViewModel(int month, float tongDoanhThu) {
        this.month = month;
        this.tongDoanhThu = tongDoanhThu;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public float getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(float tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

    @Override
    public String toString() {
        return "ThongKeViewModel{" + "month=" + month + ", tongDoanhThu=" + tongDoanhThu + '}';
    }

}
