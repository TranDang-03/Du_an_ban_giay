/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NhanVien;
import Repository.DangNhapRepository;

/**
 *
 * @author PC
 */
public class DangNhapService {
    
    private DangNhapRepository repo = new DangNhapRepository();
    
    public NhanVien login(String userName, String passWord){
        return this.repo.getOne(userName, passWord);
    }
}
