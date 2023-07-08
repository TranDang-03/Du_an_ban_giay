/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.DongSp;
import Repository.DongSPRepository;

import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class DongSPService {
    private DongSPRepository DongSPRepo;

    public DongSPService() {
        this.DongSPRepo = new DongSPRepository();
    }

    public ArrayList<DongSp> all() {
        return this.DongSPRepo.all();
    }

    public boolean insert(DongSp dsp) {
        return this.DongSPRepo.insert(dsp);
    }

    public boolean update(DongSp dsp) {
        return this.DongSPRepo.update(dsp);
    }
}
