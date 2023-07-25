/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.ThongTinHdRepository;
import ViewModels.ThongTinHD;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongTinHDService {
    private ThongTinHdRepository hoaDonRepo;
    
    public ThongTinHDService(){
        this.hoaDonRepo = new ThongTinHdRepository();
}
    
    public List<ThongTinHD> HdAll(){
        return this.hoaDonRepo.HdAll();
    }
     public List<ThongTinHD> getHDByTongTienCao(){
        return this.hoaDonRepo.getHDByTongTienCao();
    }
     public List<ThongTinHD> getHDByTongTienThap(){
        return this.hoaDonRepo.getHDByTongTienThap();
    }
}
