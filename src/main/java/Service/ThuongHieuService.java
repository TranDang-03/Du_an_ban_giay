/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ThuongHieu;
import Repository.MauSacRepository;
import Repository.ThuongHieuRepository;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ThuongHieuService {
          private ThuongHieuRepository ThuongHieuRepo;

    public ThuongHieuService() {
        this.ThuongHieuRepo = new ThuongHieuRepository();
    }
    
    public ArrayList<ThuongHieu> all() {
        return this.ThuongHieuRepo.all();
    }
    
    public boolean insert(ThuongHieu th){
        return this.ThuongHieuRepo.insert(th);
    }
    public boolean update(ThuongHieu th){
        return this.ThuongHieuRepo.update(th);
    }
}
