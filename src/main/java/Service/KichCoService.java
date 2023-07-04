/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KichCo;
import Repository.KichCoRepository;
import Repository.ThuongHieuRepository;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class KichCoService {

    private KichCoRepository KichCoRepo;

    public KichCoService() {
        this.KichCoRepo = new KichCoRepository();
    }

    public ArrayList<KichCo> all() {
        return this.KichCoRepo.all();
    }

    public boolean insert(KichCo kc) {
        return this.KichCoRepo.insert(kc);
    }

    public boolean update(KichCo kc) {
        return this.KichCoRepo.update(kc);
    }
}
