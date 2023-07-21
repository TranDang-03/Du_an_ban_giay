/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NhanVien;
import Repository.NhanVienRepository;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class NhanVienService {

    private NhanVienRepository NhanVienRepo;

    public NhanVienService() {
        this.NhanVienRepo = new NhanVienRepository();
    }

    public ArrayList<NhanVien> all() {
        return this.NhanVienRepo.all();
    }

    public boolean insert(NhanVien nv) {
        return this.NhanVienRepo.insert(nv);
    }

    public boolean update(NhanVien nv) {
        return this.NhanVienRepo.update(nv);
    }

}
