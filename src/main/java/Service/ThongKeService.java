/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.ThongKeRepository;
import java.util.List;
import view_model.ThongKeSanPhamViewModel;
import view_model.ThongKeViewModel;

/**
 *
 * @author PC
 */
public class ThongKeService {
    
    public ThongKeRepository thongKe = new ThongKeRepository();
    
    public List<ThongKeViewModel> thongKeTheoThang(int year){
        return this.thongKe.thongKeDoanhThuTheoThang(year);
    }
    
    public List<ThongKeSanPhamViewModel> thongKeSanPhamDaBan(){
        return this.thongKe.thongKeSanPhamDaBan();
    }
    
    public int thongKeDoanhThuTong(){
        return this.thongKe.thongKeTongDoanhThu();
    }
}
