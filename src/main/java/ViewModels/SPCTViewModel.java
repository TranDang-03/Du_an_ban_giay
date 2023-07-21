package ViewModels;

/**
 *
 * @author Admin
 */
public class SPCTViewModel {

    private int id;
    private String anh;
    private String maSp;
    private String tenSp;
    private int soLuong;
    private String KichCo;
    private String MauSac;
    private String ThuongHieu;
    private String Dong;
    private String KieuDang;
    private String ChatLieu;
    private float giaNhap;
    private float giaBan;
    private String NSX;
    private int trangThai;

    public SPCTViewModel() {
    }

    public SPCTViewModel(int id, String anh, String maSp, String tenSp, int soLuong, String KichCo, String MauSac, String ThuongHieu, String Dong, String KieuDang, String ChatLieu, float giaNhap, float giaBan, String NSX, int trangThai) {
        this.id = id;
        this.anh = anh;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.KichCo = KichCo;
        this.MauSac = MauSac;
        this.ThuongHieu = ThuongHieu;
        this.Dong = Dong;
        this.KieuDang = KieuDang;
        this.ChatLieu = ChatLieu;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.NSX = NSX;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getKichCo() {
        return KichCo;
    }

    public void setKichCo(String KichCo) {
        this.KichCo = KichCo;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getThuongHieu() {
        return ThuongHieu;
    }

    public void setThuongHieu(String ThuongHieu) {
        this.ThuongHieu = ThuongHieu;
    }

    public String getDong() {
        return Dong;
    }

    public void setDong(String Dong) {
        this.Dong = Dong;
    }

    public String getKieuDang() {
        return KieuDang;
    }

    public void setKieuDang(String KieuDang) {
        this.KieuDang = KieuDang;
    }

    public String getChatLieu() {
        return ChatLieu;
    }

    public void setChatLieu(String ChatLieu) {
        this.ChatLieu = ChatLieu;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SPCTViewModel{" + "id=" + id + ", anh=" + anh + ", maSp=" + maSp + ", tenSp=" + tenSp + ", soLuong=" + soLuong + ", KichCo=" + KichCo + ", MauSac=" + MauSac + ", ThuongHieu=" + ThuongHieu + ", Dong=" + Dong + ", KieuDang=" + KieuDang + ", ChatLieu=" + ChatLieu + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", NSX=" + NSX + ", trangThai=" + trangThai + '}';
    }

    
    
}