/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ChiTietSP;
import Repository.SanPhamCTRepository;
import ViewModels.SPCTViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamCTService {

    private SanPhamCTRepository SanPhamCTRepo;

    public SanPhamCTService() {
        this.SanPhamCTRepo = new SanPhamCTRepository();
    }

    public List<SPCTViewModel> all() {
        return this.SanPhamCTRepo.all();
    }

    public boolean add(ChiTietSP add) {
        return this.SanPhamCTRepo.add(add);
    }

    public List<String> getListSP() {
        return SanPhamCTRepo.getListSP();
    }

    public List<String> getListNSX() {
        return SanPhamCTRepo.getListNSX();
    }

    public List<String> getListMauSac() {
        return SanPhamCTRepo.getListMauSac();
    }

    public List<String> getListDongSP() {
        return SanPhamCTRepo.getListDongSP();
    }

    public List<String> getlistKichCo() {
        return SanPhamCTRepo.getListKichCo();
    }

    public List<String> getListKieuDang() {
        return SanPhamCTRepo.getListKieuDang();
    }

    public List<String> getListChatLieu() {
        return SanPhamCTRepo.getListChatLieu();
    }

    public List<String> getListThuongHieu() {
        return SanPhamCTRepo.getListThuongHieu();
    }

    public String getSPByID(String id) {
        return SanPhamCTRepo.getSPByID(id);
    }

    public String getIDBySP(String ten) {
        return SanPhamCTRepo.getIDBySP(ten);
    }

    public String getNSXByID(String id) {
        return SanPhamCTRepo.getNSXByID(id);
    }

    public String getIDByNSX(String ten) {
        return SanPhamCTRepo.getIDByNSX(ten);
    }

    public String getMauSacByID(String id) {
        return SanPhamCTRepo.getMauSacByID(id);
    }

    public String getIDByMauSac(String ten) {
        return SanPhamCTRepo.getIDByMauSac(ten);
    }

    public String getDongSPByID(String id) {
        return SanPhamCTRepo.getDongSPByID(id);
    }

    public String getIDByDongSP(String ten) {
        return SanPhamCTRepo.getIDByDongSP(ten);
    }
    
    public String getKichCoByID(String id) {
        return SanPhamCTRepo.getKichCoByID(id);
    }

    public String getIDByKichCo(String ten) {
        return SanPhamCTRepo.getIDByKichCo(ten);
    }
    
    public String getKieuDangByID(String id) {
        return SanPhamCTRepo.getKieuDangByID(id);
    }

    public String getIDByKieuDang(String ten) {
        return SanPhamCTRepo.getIDByKieuDang(ten);
    }
    
    public String getChatLieuByID(String id) {
        return SanPhamCTRepo.getChatLieuByID(id);
    }

    public String getIDByChatLieu(String ten) {
        return SanPhamCTRepo.getIDByChatLieu(ten);
    }
    
    public String getThuongHieuByID(String id) {
        return SanPhamCTRepo.getThuongHieuByID(id);
    }

    public String getIDByThuongHieu(String ten) {
        return SanPhamCTRepo.getIDByThuongHieu(ten);
    }
}
