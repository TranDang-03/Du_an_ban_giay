/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Constrant.UserInfor;
import Model.HoaDon;
import Repository.BanHangRepository;
import Service.BanHangService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.poi.ss.usermodel.ExcelStyleDateFormatter;
import view_model.CTSPBanHang;
import view_model.HDCTBanHang;
import view_model.HoaDonViewModel;

/**
 *
 * @author Admin
 */
public class GiaoDich extends javax.swing.JFrame {

    /**
     * Creates new form GiaoDich
     */
    private DefaultComboBoxModel dcbmMauSac = new DefaultComboBoxModel();

    private List<String> listMauSac = new ArrayList<>();

    private DefaultComboBoxModel dcbmThuongHieu = new DefaultComboBoxModel();

    private List<String> listThuongHieu = new ArrayList<>();

    private DefaultComboBoxModel dcbmKichCo = new DefaultComboBoxModel();

    private List<Integer> listKichCo = new ArrayList<>();

    private DefaultComboBoxModel dcbmNhanVien = new DefaultComboBoxModel();

    private List<String> listNhanVien = new ArrayList<>();

    private DefaultComboBoxModel dcbmKhachHang = new DefaultComboBoxModel();

    private DefaultComboBoxModel dcbmKhuyenMai = new DefaultComboBoxModel();

    private List<String> listKhuyenMai = new ArrayList<>();

    private DefaultTableModel dtmHoaDon = new DefaultTableModel();

    private List<HoaDonViewModel> listGetAllHD = new ArrayList<>();

    private DefaultTableModel dtmCTSP = new DefaultTableModel();

    private List<CTSPBanHang> listCTSP = new ArrayList<>();

    private DefaultTableModel dtmHDCT = new DefaultTableModel();

    private List<HDCTBanHang> listHDCT = new ArrayList<>();

    private BanHangService banHangService = new BanHangService();

    public GiaoDich() {
        initComponents();
        tblHoaDon.setModel(dtmHoaDon);

        tblHDCT.setModel(dtmHDCT);

        tblSanPhamCT.setModel(dtmCTSP);

        ccbMauSac.setModel(dcbmMauSac);

        ccbThuongHieu.setModel(dcbmThuongHieu);

        ccbSize.setModel(dcbmKichCo);

        ccbKhuyenMai.setModel(dcbmKhuyenMai);

        ccbNhanVien.setModel(dcbmNhanVien);

        String headerHoaDon[] = {"Mã HD", "Tên KH", "Tên NV", "Mã Khuyến Mãi", "Thành Tiền", "Ngày Tạo", "Trạng Thái"};
        dtmHoaDon.setColumnIdentifiers(headerHoaDon);

        String headerHDCT[] = {"Tên SP", "Số lượng", "Dòng SP", "Hãng", "Size", "Đơn giá"};
        dtmHDCT.setColumnIdentifiers(headerHDCT);

        String headerCTSP[] = {"Tên SP", "Loại", "Thương Hiệu", "Size", "Giá", "Số lượng tồn", "Màu Sắc"};
        dtmCTSP.setColumnIdentifiers(headerCTSP);

        listNhanVien = banHangService.getAllMaNV();
        dcbmNhanVien.addAll(listNhanVien);

        listMauSac = banHangService.getAllTenMauSac();
        listMauSac.add("All");
        dcbmMauSac.addAll(listMauSac);

        listThuongHieu = banHangService.getAllTenThuongHieu();
        listThuongHieu.add("All");
        dcbmThuongHieu.addAll(listThuongHieu);

        listKichCo = banHangService.getAllTenKichCo();
        listKichCo.add(0);
        dcbmKichCo.addAll(listKichCo);

        listKhuyenMai = banHangService.getALLMaKhuyenMai();
        listKhuyenMai.add("Không");
        dcbmKhuyenMai.addAll(listKhuyenMai);

        ccbNhanVien.setSelectedIndex(0);

        ccbMauSac.setSelectedIndex(listMauSac.size() - 1);

        ccbThuongHieu.setSelectedIndex(listThuongHieu.size() - 1);

        ccbSize.setSelectedIndex(listKichCo.size() - 1);

        ccbKhuyenMai.setSelectedIndex(listKhuyenMai.size() - 1);

        txtMaHD.setEditable(false);

        listCTSP = banHangService.getAllCTSP();
        displayProductFilter(listCTSP);

        ccbMauSac.addActionListener(filterListener);
        ccbSize.addActionListener(filterListener);
        ccbThuongHieu.addActionListener(filterListener);

        ccbTrangThaiHoaDon.setSelectedIndex(1);

        ccbTrangThaiHoaDon.setEnabled(false);

        txtTenKH.setEditable(false);

        txtNgayTao.setDate(new java.util.Date());

        btnSuaHD.setEnabled(false);

        btnThanhToan.setEnabled(false);

        btnHuyDon.setEnabled(false);

        txtNgayTao.setEnabled(true);

        txtTienKM.setEditable(false);

        btnXoaSP.setEnabled(false);

        txtTenKH.setText("Khach Ban Le");
        txtMaKH.setText("KH00");

        String employee = String.valueOf(UserInfor.user.keySet());
        String replaceAll = employee.replaceAll("[\\[\\]\\{\\}()]", "");
        ccbNhanVien.setSelectedItem(replaceAll);

        String employeeName = String.valueOf(UserInfor.user.values());
        String replaceAllName = employeeName.replaceAll("[\\[\\]\\{\\}()]", "");
        txtTenNV.setText(replaceAllName);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();
        btnXoaSP = new javax.swing.JButton();
        btnSuaSL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPhamCT = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        ccbMauSac = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        ccbSize = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        ccbThuongHieu = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTienKhachTra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        btnHuyDon = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnTaoHD = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        ccbKhuyenMai = new javax.swing.JComboBox<>();
        txtNgayTao = new com.toedter.calendar.JDateChooser();
        ccbNhanVien = new javax.swing.JComboBox<>();
        btnSuaHD = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtHoaDonChon = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ccbTrangThaiHoaDon = new javax.swing.JComboBox<>();
        DateTimNgay = new com.toedter.calendar.JDateChooser();
        txtMaKH = new javax.swing.JLabel();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnHead = new javax.swing.JButton();
        txtTenKH = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnLayTTKH = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtTienKM = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lí Giao Dịch");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên SP", "Số lượng", "Loại", "Hãng", "Size", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(tblHDCT);

        btnXoaSP.setText("Xóa SP");
        btnXoaSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaSPMouseClicked(evt);
            }
        });

        btnSuaSL.setText("Sửa SL");
        btnSuaSL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaSLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuaSL)
                        .addGap(33, 33, 33)
                        .addComponent(btnXoaSP))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaSP)
                    .addComponent(btnSuaSL))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tìm kiếm :");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        tblSanPhamCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên SP", "Loại", "Hãng", "Size", "Giá", "Số lượng tồn"
            }
        ));
        tblSanPhamCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPhamCT);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Size:");

        ccbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Màu SP:");

        ccbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Thương hiệu:");

        ccbThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(15, 15, 15))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ccbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ccbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ccbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ccbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(ccbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(ccbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel3.setText("Mã HÐ:");

        jLabel4.setText("Mã NV:");

        jLabel5.setText("Ngày tạo:");

        jLabel6.setText("Tên KH:");

        jLabel7.setText("Thành tiền:");

        txtThanhTien.setEditable(false);
        txtThanhTien.setForeground(new java.awt.Color(255, 0, 0));
        txtThanhTien.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setText("Tiền khách trả:");

        jLabel9.setText("Tiền thừa: ");

        jTextField8.setEditable(false);
        jTextField8.setForeground(new java.awt.Color(255, 0, 0));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnHuyDon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHuyDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnHuyDon.setText("Hủy đơn");

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Price list.png"))); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTaoHD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTaoHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnTaoHD.setText("Tạo đơn");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã ĐH", "Tên KH ", "Tên NV", "Thành tiền"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        jLabel13.setText("Khuyến Mãi:");

        ccbKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtNgayTao.setDateFormatString("yyyy-MM-dd");

        ccbNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSuaHD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSuaHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSuaHD.setText("Sửa đơn");
        btnSuaHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaHDMouseClicked(evt);
            }
        });

        jLabel14.setText("Hóa Đơn:");

        txtHoaDonChon.setText("null");

        jButton1.setForeground(new java.awt.Color(0, 255, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ccbTrangThaiHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chờ thanh toán", "Tất cả" }));
        ccbTrangThaiHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccbTrangThaiHoaDonActionPerformed(evt);
            }
        });

        DateTimNgay.setDateFormatString("yyyy-MM-dd");
        DateTimNgay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DateTimNgayKeyReleased(evt);
            }
        });

        txtMaKH.setText("Null");

        btnLast.setText(">|");

        btnNext.setText(">>");

        btnPrevious.setText("<<");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnHead.setText("|<");

        jLabel15.setText("Mã KH:");

        btnLayTTKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Accept.png"))); // NOI18N
        btnLayTTKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLayTTKHMouseClicked(evt);
            }
        });

        jLabel16.setText("Tiền khuyến mãi:");

        txtTenNV.setText("null");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoaDonChon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(ccbTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(DateTimNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btnHead)
                .addGap(77, 77, 77)
                .addComponent(btnPrevious)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext)
                .addGap(72, 72, 72)
                .addComponent(btnLast)
                .addGap(104, 104, 104))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(btnTaoHD)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnSuaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThanhToan)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuyDon)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(txtTenKH))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ccbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtTienKM, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLayTTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ccbKhuyenMai, 0, 157, Short.MAX_VALUE)
                                    .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)))))
                        .addGap(37, 37, 37))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txtTenNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ccbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMaKH)
                                .addComponent(jLabel15))
                            .addComponent(btnLayTTKH))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ccbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHuyDon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnTaoHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSuaHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtHoaDonChon)
                        .addComponent(ccbTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DateTimNgay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLast)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious)
                    .addComponent(btnHead))
                .addGap(102, 102, 102))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(376, 376, 376))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblSanPhamCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamCTMouseClicked
        // TODO add your handling code here:
        int number;

        if (txtHoaDonChon.getText().equalsIgnoreCase("null")) {

            JOptionPane.showMessageDialog(this, "Hãy chọn hóa đơn!!!!");

        } else {
            String soLuongMua = JOptionPane.showInputDialog(this, "Nhập số lượng bạn muốn mua: ");

            if (!soLuongMua.matches("^[1-9][0-9]*$")) {

                JOptionPane.showMessageDialog(this, "Hãy nhập lại số lượng!!!");

            } else {

                int row = tblSanPhamCT.getSelectedRow();
                String maHD = txtHoaDonChon.getText();
                int idCTSP = listCTSP.get(row).getIdCTSP();
                int soLuongTon = listCTSP.get(row).getSoLuongTon();
                number = Integer.valueOf(soLuongMua);
                if (number > soLuongTon) {
                    JOptionPane.showMessageDialog(this, "Sản phẩm không còn đủ số lượng theo yêu cầu, hãy chọn lại số lượng!!!");
                } else {
                    if (banHangService.checkTonTaiSP(maHD, idCTSP).isEmpty()) {

                        number = Integer.valueOf(soLuongMua);
                        float donGia = listCTSP.get(row).getGiaBan();

                        if (banHangService.themSPVaoHDCT(number, donGia, maHD, idCTSP)) {
                            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!!!!");
                            soLuongTon = soLuongTon - number;
                            banHangService.suaSoLuongCTSP(soLuongTon, idCTSP);
                            resetTableCTSP();
                            resetTableHDCT();
                            resetTableHoaDon();
                            Float total = this.banHangService.getTongTienTheoMaHD(maHD);
                            txtThanhTien.setText(String.valueOf(total));
                        } else {

                            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại!!!");
                        }

                    } else {
                        int quantity = this.banHangService.laySoLuongSPTrongHDCT(maHD, idCTSP);
                        number = Integer.valueOf(soLuongMua);
                        if (banHangService.suaSoLuong(number, idCTSP, maHD)) {
                            JOptionPane.showMessageDialog(this, "Cập nhật số lượng thành công!!!");
                            System.out.println(quantity);
                            int soLuongTonKho = soLuongTon + quantity;
                            System.out.println(soLuongTon);
                            System.out.println(soLuongTonKho);
                            System.out.println(number);
                            this.banHangService.suaSoLuongCTSP(soLuongTonKho, idCTSP);
                            soLuongTon = soLuongTonKho - number;
                            this.banHangService.suaSoLuongCTSP(soLuongTon, idCTSP);
                            resetTableCTSP();
                            resetTableHDCT();
                            resetTableHoaDon();
                            Float total = this.banHangService.getTongTienTheoMaHD(maHD);
                            txtThanhTien.setText(String.valueOf(total));
                        } else {
                            JOptionPane.showMessageDialog(this, "Cập nhật số lượng thất bại!!!!");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_tblSanPhamCTMouseClicked

    private void btnXoaSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaSPMouseClicked
        // TODO add your handling code here:
        int row = tblHDCT.getSelectedRow();
        String maHD = txtHoaDonChon.getText();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn sản phẩm muốn xóa!!!");
        } else {
            int idCTSP = listHDCT.get(row).getId();
            int soLuongMua = listHDCT.get(row).getSoLuong();
//      int idCTSP = this.banHangService.layIDCTSPTheoMAHDvIdCTHD(idHDCT, maHD);
            int soLuongTon = this.banHangService.laySLTonTheoIdCTSP(idCTSP);
            int idHDCT = this.banHangService.layIdHDCTTheoIdHDVaIdCTSP(idCTSP, maHD);

            if (this.banHangService.xoaSPHDCT(idHDCT, maHD)) {
                int quantity = soLuongMua + soLuongTon;
                this.banHangService.suaSoLuongCTSP(quantity, idCTSP);
                JOptionPane.showMessageDialog(this, "Xóa thành công!!!!");
                resetTableCTSP();
                resetTableHDCT();
                resetTableHoaDon();
                Float total = this.banHangService.getTongTienTheoMaHD(maHD);
                txtThanhTien.setText(String.valueOf(total));
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!!!!");
            }
        }
    }//GEN-LAST:event_btnXoaSPMouseClicked

    private void btnSuaSLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaSLMouseClicked
        // TODO add your handling code here:
        int row = tblHDCT.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn sản phẩm muốn chỉnh số lượng!!!!");
        } else {
            int idCTSP = listHDCT.get(row).getId();
            String maHD = txtHoaDonChon.getText();
            String soLuongMua = JOptionPane.showInputDialog(this, "Nhập số lượng mới: ");
            if (!soLuongMua.matches("^[1-9][0-9]*$")) {
                JOptionPane.showMessageDialog(this, "Hãy nhập lại số lượng!!!");
            } else {
                int number = Integer.valueOf(soLuongMua);
                int soLuongTon = this.banHangService.laySLTonTheoIdCTSP(idCTSP);
                System.out.println(soLuongTon);
                int soLuongDaMua = this.banHangService.laySoLuongSPTrongHDCT(maHD, idCTSP);
                System.out.println(soLuongDaMua);
                int quantity = soLuongTon + soLuongDaMua;
                this.banHangService.suaSoLuongCTSP(quantity, idCTSP);
                this.banHangService.suaSoLuong(number, idCTSP, maHD);
                quantity = quantity - number;
                this.banHangService.suaSoLuongCTSP(quantity, idCTSP);
                resetTableCTSP();
                resetTableHDCT();
                resetTableHoaDon();
                Float total = this.banHangService.getTongTienTheoMaHD(maHD);
                txtThanhTien.setText(String.valueOf(total));
                JOptionPane.showMessageDialog(this, "Chỉnh sửa số lượng thành công!!!");
            }
        }
    }//GEN-LAST:event_btnSuaSLMouseClicked

    private void btnSuaHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaHDMouseClicked
        // TODO add your handling code here:
       String maNV = txtTenNV.getText();
       String maKH = txtMaKH.getText();
       
    }//GEN-LAST:event_btnSuaHDMouseClicked

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTaoHDActionPerformed
        // TODO add your handling code here:
        java.util.Date ngayTao = txtNgayTao.getDate();
        System.out.println(ngayTao);
        if (ngayTao != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(ngayTao);
            try {
                java.util.Date parsedDate = dateFormat.parse(formattedDate);
                java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
                System.out.println(sqlDate);
            } catch (Exception ex) {
                // Logger.getLogger(GiaoDich.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ngày tạo không hợp lệ");
        }

        String maKH = txtMaKH.getText();

        boolean check = this.banHangService.addHoaDon(maKH);
        if (check) {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thất bại");
        }

        listGetAllHD = this.banHangService.getAllHD();
        showDataHD(listGetAllHD);
    }// GEN-LAST:event_btnTaoHDActionPerformed

    private void ccbTrangThaiHoaDonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ccbTrangThaiHoaDonActionPerformed
        // TODO add your handling code here:
        switch (ccbTrangThaiHoaDon.getSelectedIndex()) {
            case 0 -> {
                listGetAllHD = banHangService.getAllHDDaThanhToan();
                showDataHD(listGetAllHD);
            }
            case 1 -> {
                listGetAllHD = banHangService.getAllHDChuaThanhToan();
                showDataHD(listGetAllHD);
            }
            default -> {
                listGetAllHD = banHangService.getAllHD();
                showDataHD(listGetAllHD);
            }
        }
    }// GEN-LAST:event_ccbTrangThaiHoaDonActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tblHoaDon.getSelectedRow();

        btnXoaSP.setEnabled(true);

        txtMaHD.setText(listGetAllHD.get(row).getMaHD());

        java.util.Date ngayTao = listGetAllHD.get(row).getNgayTao();
        txtNgayTao.setDate(ngayTao);

        txtTenKH.setText(listGetAllHD.get(row).getTenKH());

        ccbNhanVien.setSelectedItem(listGetAllHD.get(row).getTenNV());

//      txtThanhTien.setText(String.valueOf(listGetAllHD.get(row).getThanhTien()));
        txtThanhTien.setText(String.valueOf(this.banHangService.getTongTienTheoMaHD(listGetAllHD.get(row).getMaHD())));

        txtHoaDonChon.setText(listGetAllHD.get(row).getMaHD());

        ccbKhuyenMai.setSelectedItem(listGetAllHD.get(row).getMaKM());

        listHDCT = this.banHangService.getAllHDCTTheoMaHD(txtHoaDonChon.getText());
        showDataHDCT(listHDCT);

        if (listGetAllHD.get(row).getTrangThai() != 1) {
            btnSuaHD.setEnabled(false);
            btnThanhToan.setEnabled(false);
            btnHuyDon.setEnabled(false);
        } else {
            btnSuaHD.setEnabled(true);
            btnThanhToan.setEnabled(true);
            btnHuyDon.setEnabled(true);
        }

    }// GEN-LAST:event_tblHoaDonMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        String name = txtTimKiem.getText();

        if (name.isBlank()) {
            listCTSP = this.banHangService.getAllCTSP();
            displayProductFilter(listCTSP);
        } else {
            listCTSP = this.banHangService.searchSP(name);
            displayProductFilter(listCTSP);
        }
    }// GEN-LAST:event_txtTimKiemKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        KhachHang kh = new KhachHang();
        kh.setVisible(true);
    }// GEN-LAST:event_jButton1ActionPerformed

    private void btnLayTTKHMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnLayTTKHMouseClicked
        // TODO add your handling code here:
        txtMaKH.setText(UserInfor.CUSTOMERCODE);
        txtTenKH.setText(UserInfor.CUSTOMERNAME);
    }// GEN-LAST:event_btnLayTTKHMouseClicked

    private void DateTimNgayKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_DateTimNgayKeyReleased
        // TODO add your handling code here:

    }// GEN-LAST:event_DateTimNgayKeyReleased

    ActionListener filterListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<CTSPBanHang> filteredData = filterData(listCTSP);

            displayProductFilter(filteredData);
            for (CTSPBanHang cTSPBanHang : filteredData) {
                System.out.println(filteredData.toString());
            }
        }
    };

    private List<CTSPBanHang> filterData(List<CTSPBanHang> data) {
        Predicate<CTSPBanHang> predicate = new Predicate<CTSPBanHang>() {
            public boolean evaluate(CTSPBanHang item) {

                String selectedColor = (String) ccbMauSac.getSelectedItem();
                int selectedSize = (int) ccbSize.getSelectedItem();
                String selectedBranch = (String) ccbThuongHieu.getSelectedItem();

                boolean filterByColor = !selectedColor.equals("All");
                boolean filterBySize = selectedSize != 0;
                boolean filterByBranch = !selectedBranch.equals("All");

                boolean colorMatch = !filterByColor || item.getTenMau().equalsIgnoreCase(selectedColor);
                boolean sizeMatch = !filterBySize || item.getSize() == selectedSize;
                boolean branchMatch = !filterByBranch || item.getThuongHieu().equalsIgnoreCase(selectedBranch);

                return colorMatch && sizeMatch && branchMatch;
            }
        };
        return (List<CTSPBanHang>) CollectionUtils.select(data, predicate);
    }

    private void displayProductFilter(List<CTSPBanHang> data) {
        dtmCTSP.setRowCount(0);
        for (CTSPBanHang x : data) {
            Object[] row = {
                x.getTenSP(),
                x.getDongSP(),
                x.getThuongHieu(),
                x.getSize(),
                x.getGiaBan(),
                x.getSoLuongTon(),
                x.getTenMau()
            };
            dtmCTSP.addRow(row);
        }
    }

    private void showDataHD(List<HoaDonViewModel> list) {
        dtmHoaDon.setRowCount(0);
        for (HoaDonViewModel x : list) {
            dtmHoaDon.addRow(new Object[]{
                x.getMaHD(),
                x.getTenKH(),
                x.getTenNV(),
                x.getMaKM(),
                x.getThanhTien(),
                x.getNgayTao(),
                x.getTrangThai() == 0 ? "Đã thanh toán" : (x.getTrangThai() == 1) ? "Chưa thanh toán" : "Đã hủy"
            });
        }
    }

    private void showDataHDCT(List<HDCTBanHang> list) {
        dtmHDCT.setRowCount(0);
        for (HDCTBanHang x : list) {
            Object[] row = {
                x.getTenSP(),
                x.getSoLuong(),
                x.getLoai(),
                x.getHang(),
                x.getSize(),
                x.getDonGia()
            };
            dtmHDCT.addRow(row);
        }
    }

    public void resetTableHoaDon() {
        listGetAllHD.removeAll(listGetAllHD);
        listGetAllHD = this.banHangService.getAllHDChuaThanhToan();
        showDataHD(listGetAllHD);
    }

    public void resetTableCTSP() {
        listCTSP.removeAll(listCTSP);
        listCTSP = this.banHangService.getAllCTSP();
        displayProductFilter(listCTSP);
    }

    public void resetTableHDCT() {
        listHDCT.removeAll(listHDCT);
        listHDCT = this.banHangService.getAllHDCTTheoMaHD(txtHoaDonChon.getText());
        showDataHDCT(listHDCT);
    }

    public void clear() {
        txtHoaDonChon.setText("");
        txtNgayTao.setDate(null);
        txtTenKH.setText("Khach Ban Le");
        txtMaKH.setText("KH00");
        txtThanhTien.setText("");
        txtTienKM.setText("");
        txtTienKhachTra.setText("");
        txtTimKiem.setText("");
        jTextField8.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDich().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateTimNgay;
    private javax.swing.JButton btnHead;
    private javax.swing.JButton btnHuyDon;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLayTTKH;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSuaHD;
    private javax.swing.JButton btnSuaSL;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JComboBox<String> ccbKhuyenMai;
    private javax.swing.JComboBox<String> ccbMauSac;
    private javax.swing.JComboBox<String> ccbNhanVien;
    private javax.swing.JComboBox<String> ccbSize;
    private javax.swing.JComboBox<String> ccbThuongHieu;
    private javax.swing.JComboBox<String> ccbTrangThaiHoaDon;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPhamCT;
    private javax.swing.JLabel txtHoaDonChon;
    private javax.swing.JTextField txtMaHD;
    public javax.swing.JLabel txtMaKH;
    private com.toedter.calendar.JDateChooser txtNgayTao;
    public javax.swing.JTextField txtTenKH;
    private javax.swing.JLabel txtTenNV;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTienKM;
    private javax.swing.JTextField txtTienKhachTra;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
