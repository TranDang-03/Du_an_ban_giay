/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.SanPham;
import Repository.SanPhamRepository;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SanPhamService {
    private SanPhamRepository SanPhamRepo;

    public SanPhamService() {
        this.SanPhamRepo = new SanPhamRepository();
    }
    
    public ArrayList<SanPham> all() {
        return this.SanPhamRepo.all();
    }
    
    public boolean insert(SanPham sp){
        return this.SanPhamRepo.insert(sp);
    }
    public boolean update(SanPham sp){
        return this.SanPhamRepo.update(sp);
    }
     public boolean delete(int id){
        return this.SanPhamRepo.delete(id);
    }
}
