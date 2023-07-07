/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KieuDang;
import Repository.KieuDangRepository;
import java.util.List;

/**
 *
 * @author PC
 */
public class KieuDangService {
    
    private KieuDangRepository kieudang = new KieuDangRepository();
    
    public List<KieuDang> getAll(){
        return this.kieudang.getAll();
    }
    
    public KieuDang getOne(int id){
        return this.kieudang.getOne(id);
    }
    
    public boolean add(KieuDang kd){        
        return this.kieudang.addKieuDang(kd);
    }
    
    public boolean update(int id, KieuDang kd){
        return this.kieudang.updateKieuDang(id, kd);
    }
    
    public boolean delete(int id){
        return this.kieudang.deleteKieuDang(id);
    }
}
