/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhachHang;
import Repository.KhachHangRepository;
import java.util.List;

/**
 *
 * @author PC
 */
public class KhachHangService {
    
    private KhachHangRepository khRepo = new KhachHangRepository();
    
    public List<KhachHang> getAll(){
        return this.khRepo.getAll();
    }
    
    public KhachHang getOne(int id){
        return this.khRepo.getOne(id);
    }
    
    public boolean add(KhachHang kh){
        return this.khRepo.addKhachhang(kh);
    }
    
    public boolean update(int id, KhachHang kh){
        return this.khRepo.updateKhachHang(id, kh);
    }
    
    public boolean delete(int id){
        return this.khRepo.deleteKhachHang(id);
    }
}
