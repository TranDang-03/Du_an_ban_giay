/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.KhuyenMai;
import Repository.KhuyenMaiRepository;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class KhuyenMaiService {
    private KhuyenMaiRepository KhuyenMaiRepo;

    public KhuyenMaiService() {
        this. KhuyenMaiRepo = new KhuyenMaiRepository();
    }
    
    public ArrayList<KhuyenMai> all() {
        return this. KhuyenMaiRepo.all();
    }
    
    public boolean insert(KhuyenMai km){
        return this. KhuyenMaiRepo.insert(km);
    }
    public boolean update(KhuyenMai km){
        return this. KhuyenMaiRepo.update(km);
    }
}
