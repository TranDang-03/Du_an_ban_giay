/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.MauSac;
import Repository.MauSacRepository;
import Repository.SanPhamRepository;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MauSacService {
      private MauSacRepository MauSacRepo;

    public MauSacService() {
        this.MauSacRepo = new MauSacRepository();
    }
    
    public ArrayList<MauSac> all() {
        return this.MauSacRepo.all();
    }
    
    public boolean insert(MauSac ms){
        return this.MauSacRepo.insert(ms);
    }
    public boolean update(MauSac ms){
        return this.MauSacRepo.update(ms);
    }
}
