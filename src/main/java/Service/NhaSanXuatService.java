/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NSX;
import Repository.NhaSanXuatRepository;
import java.util.List;

/**
 *
 * @author PC
 */
public class NhaSanXuatService {

    private NhaSanXuatRepository NSXRepo = new NhaSanXuatRepository();

    public List<NSX> getAll() {
        return this.NSXRepo.getAll();
    }

    public NSX getOne(int id) {
        return this.NSXRepo.getOne(id);
    }

    public boolean add(NSX nsx) {
        return this.NSXRepo.addNSX(nsx);
    }

    public boolean update(int id, NSX nsx) {
        return this.NSXRepo.updateNSX(id, nsx);
    }

    public boolean delete(int id) {
        return this.NSXRepo.deleteNSX(id);
    }
}
