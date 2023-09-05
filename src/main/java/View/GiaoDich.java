/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Constrant.UserInfor;
import Model.HoaDon;
import Repository.BanHangRepository;
import Service.BanHangService;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
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

    private List<HoaDonViewModel> pageHoaDon = new ArrayList<>();

    private DefaultTableModel dtmCTSP = new DefaultTableModel();

    private List<CTSPBanHang> listCTSP = new ArrayList<>();

    private DefaultTableModel dtmHDCT = new DefaultTableModel();

    private List<HDCTBanHang> listHDCT = new ArrayList<>();

    public BanHangService banHangService = new BanHangService();

    private int data;

    public Timer timer;

    private final int MIN_COUNT = 0;

    int rowoffset = 0;

    int fetch = 5;

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

        listGetAllHD = banHangService.getAllHDChuaThanhToan();

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

        jButton2.setEnabled(false);

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

        ccbNhanVien.setEnabled(false);

        txtNgayTao.setEnabled(false);

        txtThanhTien.setEditable(false);

        DateTimNgay.setEnabled(false);

        txtThanhTien.setText("0.0");
        txtTienKM.setText("0.0");

//------------------------------------------------------------------------------
        data = 60;

        txtTimer.setText(data + " s");

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTimer.setText(data + " s");
                if (data == MIN_COUNT) {
//                    JOptionPane.showMessageDialog(rootPane, "Reset lai du lieu nha =D");
                    data = 60;
                } else {
                    data--;
                }
            }
        });
        timer.start();
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
        ccbKhuyenMai.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String maKM = (String) ccbKhuyenMai.getSelectedItem();
                    float tienKM = 0;
                    float tongTien = Float.valueOf(txtThanhTien.getText());

                    int loaiKM = banHangService.loaiKM(maKM);
                    if (loaiKM == 0) {
                        int giaTriKM = banHangService.giaTriKM(maKM);
                        tienKM = tongTien - giaTriKM;
                        txtTienKM.setText(String.valueOf(tienKM));
                    } else {
                        int giaTriKM = banHangService.giaTriKM(maKM);
                        tienKM = tongTien - (tongTien * (giaTriKM / 100.0f));
                        txtTienKM.setText(String.valueOf(tienKM));
                    }
                }
            }
        });
//------------------------------------------------------------------------------
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
        btnSuaSL = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JButton();
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
        jLabel8 = new javax.swing.JLabel();
        txtTienKhachTra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        btnHuyDon = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnTaoHD = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtNgayTao = new com.toedter.calendar.JDateChooser();
        ccbNhanVien = new javax.swing.JComboBox<>();
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
        jLabel18 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtThanhTien = new javax.swing.JTextField();
        ccbKhuyenMai = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtTimer = new javax.swing.JLabel();

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

        btnSuaSL.setText("Sửa SL");
        btnSuaSL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaSLMouseClicked(evt);
            }
        });

        btnXoaSP.setText("Xóa SP");
        btnXoaSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaSPMouseClicked(evt);
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
                        .addGap(26, 26, 26)
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
                .addGap(131, 131, 131))
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

        jLabel7.setText("Tổng Tiền:");

        jLabel8.setText("Tiền khách trả:");

        txtTienKhachTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachTraKeyReleased(evt);
            }
        });

        jLabel9.setText("Tiền thừa: ");

        txtTienThua.setEditable(false);
        txtTienThua.setForeground(new java.awt.Color(255, 0, 0));
        txtTienThua.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnHuyDon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHuyDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnHuyDon.setText("Hủy đơn");
        btnHuyDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDonActionPerformed(evt);
            }
        });

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

        txtNgayTao.setDateFormatString("yyyy-MM-dd");

        ccbNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setText("<<");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnHead.setText("|<");
        btnHead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeadActionPerformed(evt);
            }
        });

        jLabel15.setText("Mã KH:");

        btnLayTTKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Accept.png"))); // NOI18N
        btnLayTTKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLayTTKHMouseClicked(evt);
            }
        });

        jLabel16.setText("Thành Tiền:");

        txtTenNV.setText("null");

        jLabel18.setText("Tên NV: ");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        jButton2.setText("Sửa Đơn");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        ccbKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTienKM, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLayTTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(ccbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addComponent(txtTenKH)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel18)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ccbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHead)
                    .addComponent(jLabel14))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(DateTimNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtHoaDonChon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(ccbTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnPrevious)
                                .addGap(79, 79, 79)
                                .addComponent(btnNext)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLast)
                        .addGap(70, 70, 70))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTaoHD)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan)
                .addGap(18, 18, 18)
                .addComponent(btnHuyDon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTenNV))
                .addGap(18, 18, 18)
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
                                .addComponent(jLabel13)
                                .addComponent(ccbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHuyDon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHead)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtHoaDonChon)
                        .addComponent(ccbTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DateTimNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );

        jLabel17.setText("Tự động làm mới sau: ");

        txtTimer.setForeground(new java.awt.Color(255, 51, 51));
        txtTimer.setText("null");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(376, 376, 376))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTimer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        if (DateTimNgay.getDate() == null) {
            rowoffset -= 5;
            if (rowoffset < 0) {
                rowoffset = this.banHangService.getAllHD().size() - fetch;
            }
            pageHoaDon = this.banHangService.listGetAllHDPage(rowoffset);
            showDataHD(pageHoaDon);
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
//      TODO add your handling code here:

//        int row = tblHoaDon.getSelectedRow();
//        String maKM = (String) ccbKhuyenMai.getSelectedItem();
//        String makm = "";
//        float tongTien = Float.valueOf(txtThanhTien.getText());
//        float tienKM = 0;
//
//        if (row == -1) {
//            JOptionPane.showMessageDialog(this, "Hãy chọn hóa đơn cần thanh toán!!!");
//        } else {
//            if (maKM.isEmpty()) {
//                makm = pageHoaDon.get(row).getMaKM();
//                if (banHangService.getTrangThaiKM(makm) == 0) {
//                    int giaTriKM = banHangService.giaTriKM(maKM);
//                    tienKM = tongTien - giaTriKM;
//                    txtTienKM.setText(String.valueOf(tienKM));
//                    float thanhTien = Float.valueOf(txtTienKM.getText());
//                    float tienKhachTra = Float.valueOf(txtTienKhachTra.getText());
//                    float tienThua = tienKhachTra - thanhTien;
//                    if (tienThua >= 0) {
//                        JOptionPane.showMessageDialog(this, "Thanh toán thành công!!!");
//                        banHangService.thanhToanHD(txtMaKH.getText(), (String) ccbNhanVien.getSelectedItem(), Float.valueOf(thanhTien), maKM, txtHoaDonChon.getText());
//                        resetTableHoaDon();
//                        System.out.println(tienThua);
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Thanh toán thất bại!!!");
//                    }
//                } else if (makm.isEmpty()) {
//                    int giaTriKM = banHangService.giaTriKM("KM0");
//                    tienKM = tongTien - giaTriKM;
//                    txtTienKM.setText(String.valueOf(tienKM));
//                    float thanhTien = Float.valueOf(txtTienKM.getText());
//                    float tienKhachTra = Float.valueOf(txtTienKhachTra.getText());
//                    float tienThua = tienKhachTra - thanhTien;
//                    if (tienThua >= 0) {
//                        JOptionPane.showMessageDialog(this, "Thanh toán thành công!!!");
//                        banHangService.thanhToanHD(txtMaKH.getText(), (String) ccbNhanVien.getSelectedItem(), Float.valueOf(thanhTien), maKM, txtHoaDonChon.getText());
//                        resetTableHoaDon();
//                        System.out.println(tienThua);
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Thanh toán thất bại!!!");
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(this, "Khuyến mãi không còn hiệu lực!!!!");
//                }
//            }
//        }
        String maKH = txtMaKH.getText();
        String maNV = (String) ccbNhanVien.getSelectedItem();
        String maKM = "";
        float thanhtien = Float.valueOf(txtTienKM.getText());
        String maHD = txtHoaDonChon.getText();
        float tienKhachTra = 0;

        if (ccbKhuyenMai.getSelectedItem() == null) {
            maKM = "KM0";
        } else {
            maKM = (String) ccbKhuyenMai.getSelectedItem();
        }

        if (txtTienKhachTra.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy nhập lại số tiền!!!!");
        } else {
            tienKhachTra = Float.valueOf(txtTienKhachTra.getText());
        }

        if (maHD == null || maHD.equals("null")) {
            JOptionPane.showMessageDialog(this, "Hãy chọn hóa đơn cần thanh toán!!!");
        } else if (!txtTienKhachTra.getText().matches("^(0*[1-9]\\d*|0*[0-9]+\\.\\d+|0*[1-9]+\\d*\\.\\d+)$")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập lại số tiền cần thanh toán!!!!!");
        } else if (thanhtien <= 0) {
            JOptionPane.showMessageDialog(this, "Thanh toán thất bại!!!!");
        } else if (tienKhachTra <= 0 || tienKhachTra < thanhtien) {
            JOptionPane.showMessageDialog(this, "Số tiền thanh toán không đủ hãy nhập lại!!!!");
        } else {
            System.out.println(tienKhachTra);
            System.out.println(thanhtien);
            System.out.println(maKM);
            System.out.println(maHD);
            System.out.println(maNV);
            this.banHangService.thanhToanHD(maKH, maNV, thanhtien, maKM, maHD);

            JOptionPane.showMessageDialog(this, "Thanh toán thành công!!!");

            int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn in hóa đơn không?", "", 2);

            if (check == 0) {
                Document document;
                try {
                    try {
                        String font = "C:\\Users\\PC\\Documents\\Du_an_ban_giay\\src\\unicode.ttf";
                        String path = "C:\\Users\\PC\\Documents\\Du_an_ban_giay\\src\\hoadon.pdf";
                        String imagePath = "C:\\Users\\PC\\Documents\\Du_an_ban_giay\\src\\main\\java\\icon\\banner.png";
                        PdfFont fontTitle = PdfFontFactory.createFont(font, com.itextpdf.text.pdf.BaseFont.IDENTITY_H);

                        java.util.Date date = new java.util.Date();
                        Calendar calendar = GregorianCalendar.getInstance();
                        calendar.setTime(date);

                        int year = calendar.get(Calendar.YEAR);
                        int month = calendar.get(Calendar.MONTH);
                        int day = calendar.get(Calendar.DAY_OF_MONTH);
                        int hour = calendar.get(Calendar.HOUR_OF_DAY);
                        int min = calendar.get(Calendar.MINUTE);
                        int second = calendar.get(Calendar.SECOND);
                        String timeNow = hour + ":" + min + ":" + second + "\t" + day + "/" + month + "/" + year;

                        PdfWriter pdfWriter = new PdfWriter(path);

                        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
                        pdfDocument.addNewPage();
                        ImageData imageData = ImageDataFactory.create(imagePath);
                        com.itextpdf.layout.element.Image img = new com.itextpdf.layout.element.Image(imageData);
                        img.setHeight(50f).setWidth(65f);

                        document = new Document(pdfDocument);
                        float columnWith[] = {80, 1000};
                        Table tableHeader = new Table(columnWith).setBorder(Border.NO_BORDER).setHeight(60f).setAutoLayout();

                        tableHeader.setBackgroundColor(new DeviceRgb(91, 168, 44));
                        tableHeader.addCell(new Cell().add(img).setBorder(Border.NO_BORDER)
                                .setVerticalAlignment(VerticalAlignment.MIDDLE).setMarginTop(5f));
                        tableHeader.addCell(new Cell().add("Hóa đơn bán hàng")
                                .setFontColor(new DeviceRgb(255, 255, 255)).setFontSize(17f)
                                .setBold()
                                .setMarginLeft(15f)
                                .setFont(fontTitle)
                                .setTextAlignment(TextAlignment.CENTER)
                                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                                .setBorder(Border.NO_BORDER));

                        Font fontCapture = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
                        Paragraph infoCostumer = new Paragraph("Thông tin hóa đơn");
                        infoCostumer.setFont(fontTitle).setBold().setMarginTop(15f);

                        Paragraph nameCos = new Paragraph("Mã Hóa Đơn:\t" + txtHoaDonChon.getText());
                        nameCos.setFont(fontTitle).setFontSize(9f);

                        Paragraph purchaseTime = new Paragraph("Ngày Thanh Toán:\t" + timeNow);
                        purchaseTime.setFont(fontTitle).setFontSize(9f);

                        Paragraph phoneNumber = new Paragraph("Tên Khách Hàng:\t" + txtTenKH.getText());
                        phoneNumber.setFont(fontTitle).setFontSize(9f);

                        Paragraph staffName = new Paragraph("Tên Nhân Viên:\t" + txtTenNV.getText());
                        staffName.setFont(fontTitle).setFontSize(9f);

                        document.add(tableHeader);
                        document.add(infoCostumer);
                        document.add(nameCos);
                        document.add(purchaseTime);
                        document.add(phoneNumber);
                        document.add(staffName);

                        Paragraph listProducts = new Paragraph("Sản phẩm");
                        listProducts.setFont(fontTitle).setBold().setMarginTop(25f).setMarginBottom(-10);

                        document.add(listProducts);

                        float columnWithTableContent[] = {150, 350, 400};
                        Table tableContent = new Table(columnWithTableContent)
                                .setTextAlignment(TextAlignment.CENTER)
                                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                                .setBorder(Border.NO_BORDER).setMarginTop(15f);
                        tableContent.addCell(new Cell().add("Tên sản phẩm")
                                .setBackgroundColor(new DeviceRgb(91, 168, 44))
                                .setFont(fontTitle).setBold().setFontColor(Color.WHITE)
                                .setFontSize(9)
                                .setBorder(Border.NO_BORDER));
                        tableContent.addCell(new Cell().add("Số lượng")
                                .setBackgroundColor(new DeviceRgb(91, 168, 44)).setFont(fontTitle)
                                .setBold().setFontColor(Color.WHITE)
                                .setFontSize(9)
                                .setBorder(Border.NO_BORDER));
                        tableContent.addCell(new Cell().add("Giá bán")
                                .setFontSize(9)
                                .setBackgroundColor(new DeviceRgb(91, 168, 44)).setFont(fontTitle)
                                .setBold().setFontColor(Color.WHITE)
                                .setBorder(Border.NO_BORDER));

                        float price = 0;

                        for (HDCTBanHang x : listHDCT) {
                            tableContent.addCell(new Cell().add(x.getTenSP()).setFont(fontTitle).setBorder(Border.NO_BORDER).setFontSize(9));
                            tableContent.addCell(new Cell().add(x.getSoLuong() + "").setFont(fontTitle).setBorder(Border.NO_BORDER).setFontSize(9));
                            tableContent.addCell(new Cell().add(x.getDonGia() + "").setFont(fontTitle).setBorder(Border.NO_BORDER).setFontSize(9));
                            price += x.getSoLuong() * Float.parseFloat(x.getDonGia() + "");
                        }
                        document.add(tableContent);

                        float coulumnWithFotter[] = {100, 300, 900, 250, 150};
                        Table tableFotter = new Table(coulumnWithFotter)
                                .setTextAlignment(TextAlignment.LEFT)
                                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                                .setBorder(Border.NO_BORDER);
                        tableFotter.addCell(new Cell().setBackgroundColor(new DeviceRgb(91, 168, 44)).setBorder(Border.NO_BORDER));
                        tableFotter.addCell(new Cell().setBackgroundColor(new DeviceRgb(91, 168, 44)).setBorder(Border.NO_BORDER));
                        tableFotter.addCell(new Cell().setBackgroundColor(new DeviceRgb(91, 168, 44)).setBorder(Border.NO_BORDER));
                        tableFotter.addCell(new Cell().add("Tổng tiền"
                                + "\nGiảm giá"
                                + "\nTổng tiền khách đưa"
                                + "\nTrả lại")
                                .setFont(fontTitle)
                                .setFontColor(Color.WHITE)
                                .setFontSize(9)
                                .setBold()
                                .setBackgroundColor(new DeviceRgb(91, 168, 44))
                                .setBorder(Border.NO_BORDER)
                        );

                        String tongTienTra = txtTienKhachTra.getText();
                        String tienTraLai = txtTienThua.getText();
                        float tienKhuyenMai = Float.valueOf(txtThanhTien.getText()) - Float.valueOf(txtTienKM.getText());

                        tableFotter.addCell(new Cell().add(
                                price
                                + "\n" + tienKhuyenMai
                                + "\n" + tongTienTra
                                + "\n" + tienTraLai
                        )
                                .setFont(fontTitle)
                                .setFontColor(Color.WHITE)
                                .setFontSize(9)
                                .setBold()
                                .setBackgroundColor(new DeviceRgb(91, 168, 44))
                                .setBorder(Border.NO_BORDER)
                        );

                        document.add(tableFotter);

                        document.close();
                        System.out.println("Create a PDF file sussecess");
                        resetTableHoaDon();
                        listHDCT.removeAll(listHDCT);
                        showDataHDCT(listHDCT);
                        clear();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        e.getMessage();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getMessage();
                }
            } else {
                resetTableHoaDon();
                listHDCT.removeAll(listHDCT);
                showDataHDCT(listHDCT);
                clear();
            }
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblSanPhamCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamCTMouseClicked
        // TODO add your handling code here:
        int number;
        String maKM = "";

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
//------------------------------------------------------------------------------
                            float tongTien = Float.valueOf(txtThanhTien.getText());
                            float tienKM = 0;
                            ccbKhuyenMai.setSelectedItem(null);
                            if (ccbKhuyenMai.getSelectedItem() == null) {
                                int giaTriKM = banHangService.giaTriKM("KM0");
                                tienKM = tongTien - giaTriKM;
                                txtTienKM.setText(String.valueOf(tienKM));
                            } else {
                                maKM = (String) ccbKhuyenMai.getSelectedItem();
                                int loaiKM = banHangService.loaiKM(maKM);
                                if (loaiKM == 0) {
                                    int giaTriKM = banHangService.giaTriKM(maKM);
                                    tienKM = tongTien - giaTriKM;
                                    txtTienKM.setText(String.valueOf(tienKM));
                                } else {
                                    int giaTriKM = banHangService.giaTriKM(maKM);
                                    tienKM = tongTien - (tongTien * (giaTriKM / 100.0f));
                                    txtTienKM.setText(String.valueOf(tienKM));
                                }
                            }

                            if (!txtThanhTien.getText().isEmpty()) {
                                float totalPrice = Float.valueOf(txtThanhTien.getText());
                                if (totalPrice > 0) {
                                    listKhuyenMai.removeAll(listKhuyenMai);
                                    ccbKhuyenMai.removeAllItems();
                                    listKhuyenMai = banHangService.getAllMaKMTheoGiaApDung(totalPrice);
                                    dcbmKhuyenMai.addAll(listKhuyenMai);
                                } else {
                                    listKhuyenMai.removeAll(listKhuyenMai);
                                    ccbKhuyenMai.removeAllItems();
                                    dcbmKhuyenMai.addAll(listKhuyenMai);
                                }
                            }
//------------------------------------------------------------------------------
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
                            this.banHangService.suaSoLuongCTSP(soLuongTonKho, idCTSP);
                            soLuongTon = soLuongTonKho - number;
                            this.banHangService.suaSoLuongCTSP(soLuongTon, idCTSP);
                            resetTableCTSP();
                            resetTableHDCT();
                            resetTableHoaDon();
                            Float total = this.banHangService.getTongTienTheoMaHD(maHD);
                            txtThanhTien.setText(String.valueOf(total));

//------------------------------------------------------------------------------
                            float tongTien = Float.valueOf(txtThanhTien.getText());
                            float tienKM = 0;
                            ccbKhuyenMai.setSelectedItem(null);
                            if (ccbKhuyenMai.getSelectedItem() == null) {
                                int giaTriKM = banHangService.giaTriKM("KM0");
                                tienKM = tongTien - giaTriKM;
                                txtTienKM.setText(String.valueOf(tienKM));
                            } else {
                                maKM = (String) ccbKhuyenMai.getSelectedItem();
                                int loaiKM = banHangService.loaiKM(maKM);
                                if (loaiKM == 0) {
                                    int giaTriKM = banHangService.giaTriKM(maKM);
                                    tienKM = tongTien - giaTriKM;
                                    txtTienKM.setText(String.valueOf(tienKM));
                                } else {
                                    int giaTriKM = banHangService.giaTriKM(maKM);
                                    tienKM = tongTien - (tongTien * (giaTriKM / 100.0f));
                                    txtTienKM.setText(String.valueOf(tienKM));
                                }
                            }

                            if (!txtThanhTien.getText().isEmpty()) {
                                float totalPrice = Float.valueOf(txtThanhTien.getText());
                                if (totalPrice > 0) {
                                    listKhuyenMai.removeAll(listKhuyenMai);
                                    ccbKhuyenMai.removeAllItems();
                                    listKhuyenMai = banHangService.getAllMaKMTheoGiaApDung(totalPrice);
                                    dcbmKhuyenMai.addAll(listKhuyenMai);
                                } else {
                                    listKhuyenMai.removeAll(listKhuyenMai);
                                    ccbKhuyenMai.removeAllItems();
                                    dcbmKhuyenMai.addAll(listKhuyenMai);
                                }
                            }
//------------------------------------------------------------------------------
                        } else {
                            JOptionPane.showMessageDialog(this, "Cập nhật số lượng thất bại!!!!");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_tblSanPhamCTMouseClicked

    private void btnSuaSLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaSLMouseClicked
        // TODO add your handling code here:

        String maKM = "";
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

                float tongTien = Float.valueOf(txtThanhTien.getText());
                float tienKM = 0;
                if (ccbKhuyenMai.getSelectedItem() == null) {
                    int giaTriKM = banHangService.giaTriKM("KM0");
                    tienKM = tongTien - giaTriKM;
                    txtTienKM.setText(String.valueOf(tienKM));
                    giaTriKM = banHangService.giaTriKM(maKM);
                    txtTienKM.setText(String.valueOf(tienKM));
                } else {
                    ccbKhuyenMai.getSelectedItem();
                    int loaiKM = banHangService.loaiKM(maKM);
                    if (loaiKM == 0) {
                        int giaTriKM = banHangService.giaTriKM(maKM);
                        tienKM = tongTien - giaTriKM;
                        txtTienKM.setText(String.valueOf(tienKM));
                    } else {
                        int giaTriKM = banHangService.giaTriKM(maKM);
                        tienKM = tongTien - (tongTien * (giaTriKM / 100.0f));
                        txtTienKM.setText(String.valueOf(tienKM));
                    }
                }

                if (!txtThanhTien.getText().isEmpty()) {
                    float totalPrice = Float.valueOf(txtThanhTien.getText());
                    if (totalPrice > 0) {
                        listKhuyenMai.removeAll(listKhuyenMai);
                        ccbKhuyenMai.removeAllItems();
                        listKhuyenMai = banHangService.getAllMaKMTheoGiaApDung(totalPrice);
                        dcbmKhuyenMai.addAll(listKhuyenMai);
                    } else {
                        listKhuyenMai.removeAll(listKhuyenMai);
                        ccbKhuyenMai.removeAllItems();
                        dcbmKhuyenMai.addAll(listKhuyenMai);
                    }
                }
                JOptionPane.showMessageDialog(this, "Chỉnh sửa số lượng thành công!!!");
            }
        }
    }//GEN-LAST:event_btnSuaSLMouseClicked

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if (DateTimNgay.getDate() == null) {
            rowoffset += 5;
            if (rowoffset > banHangService.getAllHD().size() - 1) {
                rowoffset = 0;
            }
            pageHoaDon = this.banHangService.listGetAllHDPage(rowoffset);
            showDataHD(pageHoaDon);

            int c = this.banHangService.getAllHD().size();
            System.out.println(c);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtTienKhachTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachTraKeyReleased
        // TODO add your handling code here:

        if (txtThanhTien.getText().isBlank() || txtTienKhachTra.getText().isBlank()) {
            txtTienThua.setText("");
        } else {
            if (!txtTienKhachTra.getText().matches("^[1-9]\\d*$")) {
                JOptionPane.showMessageDialog(rootPane, "Hãy nhập lại số tiền!!!!");
            } else {
                float tongTien = Float.valueOf(txtTienKM.getText());
                float tienTra = Float.valueOf(txtTienKhachTra.getText());
                float tienThua = tienTra - tongTien;
                if (tienThua < 0) {
                    txtTienThua.setText("0");
                } else {
                    String formattedNumber = String.format("%.0f", tienThua);
                    txtTienThua.setText(String.valueOf(formattedNumber));
                }
            }
        }
    }//GEN-LAST:event_txtTienKhachTraKeyReleased

    private void btnHeadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeadActionPerformed
        // TODO add your handling code here:
        rowoffset = 0;
        pageHoaDon = banHangService.listGetAllHDPage(rowoffset);
        showDataHD(pageHoaDon);
    }//GEN-LAST:event_btnHeadActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
//      int c = banHangService.getAllHD().size() / fetch;
        rowoffset = banHangService.getAllHD().size() - fetch;
        pageHoaDon = banHangService.listGetAllHDPage(rowoffset);
        showDataHD(pageHoaDon);
        System.out.println(rowoffset);
    }//GEN-LAST:event_btnLastActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        String maKH = txtMaKH.getText();
        String maNV = (String) ccbNhanVien.getSelectedItem();

        String maKM = (String) ccbKhuyenMai.getSelectedItem();

        String maHD = txtHoaDonChon.getText();

        int row = tblHoaDon.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn hóa đơn cần sửa!!!!");
        } else {
            if (maKM == null) {
                boolean a = this.banHangService.updateHD(maKH, maNV, maHD);
                if (a) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!!!!");
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại!!!!");
                }
            } else {
                boolean a = this.banHangService.updateHD(maKH, maNV, maHD);
                if (a) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!!!!");
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại!!!!");
                }
            }
        }
        resetTableHoaDon();
    }//GEN-LAST:event_jButton2MouseClicked

    private void btnXoaSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaSPMouseClicked
        // TODO add your handling code here:
        String maKM = "";

        int row = tblHDCT.getSelectedRow();
        String maHD = txtHoaDonChon.getText();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn sản phẩm muốn xóa!!!");
        } else {
            int chooser = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa sản phẩm này chứ?", "", 1);
            if (chooser == 0) {
                int idCTSP = listHDCT.get(row).getId();
                int soLuongMua = listHDCT.get(row).getSoLuong();
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

//------------------------------------------------------------------------------
                    float tongTien = Float.valueOf(txtThanhTien.getText());
                    float tienKM = 0;
                    if (ccbKhuyenMai.getSelectedItem() == null) {
                        int giaTriKM = banHangService.giaTriKM("KM0");
                        tienKM = tongTien - giaTriKM;
                        txtTienKM.setText(String.valueOf(tienKM));
                        giaTriKM = banHangService.giaTriKM(maKM);
                        txtTienKM.setText(String.valueOf(tienKM));
                    } else {
                        ccbKhuyenMai.getSelectedItem();
                        int loaiKM = banHangService.loaiKM(maKM);
                        if (loaiKM == 0) {
                            int giaTriKM = banHangService.giaTriKM(maKM);
                            tienKM = tongTien - giaTriKM;
                            txtTienKM.setText(String.valueOf(tienKM));
                        } else {
                            int giaTriKM = banHangService.giaTriKM(maKM);
                            tienKM = tongTien - (tongTien * (giaTriKM / 100.0f));
                            txtTienKM.setText(String.valueOf(tienKM));
                        }
                    }

                    if (!txtThanhTien.getText().isEmpty()) {
                        float totalPrice = Float.valueOf(txtThanhTien.getText());
                        if (totalPrice > 0) {
                            listKhuyenMai.removeAll(listKhuyenMai);
                            ccbKhuyenMai.removeAllItems();
                            listKhuyenMai = banHangService.getAllMaKMTheoGiaApDung(totalPrice);
                            dcbmKhuyenMai.addAll(listKhuyenMai);
                        } else {
                            listKhuyenMai.removeAll(listKhuyenMai);
                            ccbKhuyenMai.removeAllItems();
                            dcbmKhuyenMai.addAll(listKhuyenMai);
                        }
                    }
//------------------------------------------------------------------------------
                }
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!!!!");
            }
        }
    }//GEN-LAST:event_btnXoaSPMouseClicked

    private void btnHuyDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDonActionPerformed
        // TODO add your handling code here:

        //this.banHangService.getAllHDCTTheoMaHD(txtHoaDonChon.getText());
        if (txtHoaDonChon.getText().equals("null") || txtHoaDonChon.getText() == null) {
            JOptionPane.showMessageDialog(this, "Hãy chọn hóa đơn cần hủy!!!");
        } else if (listHDCT.isEmpty()) {
            this.banHangService.xoaHD(txtHoaDonChon.getText());
            JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công!!!!");
            resetTableHoaDon();
            clear();
        } else {
            for (HDCTBanHang x : listHDCT) {
                int sl = this.banHangService.laySLTonTheoIdCTSP(x.getId());
                this.banHangService.suaSoLuongCTSP(sl + x.getSoLuong(), x.getId());
            }
            this.banHangService.huyDon(txtHoaDonChon.getText());
            JOptionPane.showMessageDialog(this, "Hủy đơn thành công!!!!");
            resetTableHoaDon();
            resetTableCTSP();
            listHDCT.removeAll(listHDCT);
            showDataHDCT(listHDCT);
            clear();
        }

    }//GEN-LAST:event_btnHuyDonActionPerformed

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTaoHDActionPerformed
        // TODO add your handling code here:
//------------------------------------------------------------------------------
//        java.util.Date ngayTao = txtNgayTao.getDate();
//        System.out.println(ngayTao);
//        if (ngayTao != null) {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String formattedDate = dateFormat.format(ngayTao);
//            try {
//                java.util.Date parsedDate = dateFormat.parse(formattedDate);
//                java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
//                System.out.println(sqlDate);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Ngày tạo không hợp lệ");
//        }
//------------------------------------------------------------------------------
        String maKH = txtMaKH.getText();

        String maNV = (String) ccbNhanVien.getSelectedItem();

        boolean check = this.banHangService.addHoaDon(maKH, maNV);
        if (check) {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thất bại");
        }

        pageHoaDon = this.banHangService.listGetAllHDPage(rowoffset);
        showDataHD(pageHoaDon);
    }// GEN-LAST:event_btnTaoHDActionPerformed

    private void ccbTrangThaiHoaDonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ccbTrangThaiHoaDonActionPerformed
        // TODO add your handling code here:
        switch (ccbTrangThaiHoaDon.getSelectedIndex()) {
            case 0 -> {
                listGetAllHD = banHangService.getAllHDDaThanhToan();
                showDataHD(listGetAllHD);
            }
            case 1 -> {
                pageHoaDon = banHangService.listGetAllHDPage(rowoffset);
                showDataHD(pageHoaDon);
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

        txtTienKM.setText("");

        txtTienThua.setText("");

        btnXoaSP.setEnabled(true);

        txtMaHD.setText(pageHoaDon.get(row).getMaHD());

        java.util.Date ngayTao = pageHoaDon.get(row).getNgayTao();
        txtNgayTao.setDate(ngayTao);

        txtTenKH.setText(pageHoaDon.get(row).getTenKH());

        txtThanhTien.setText(String.valueOf(this.banHangService.getTongTienTheoMaHD(pageHoaDon.get(row).getMaHD())));

        txtHoaDonChon.setText(pageHoaDon.get(row).getMaHD());

        ccbKhuyenMai.setSelectedItem(pageHoaDon.get(row).getMaKM());

        listHDCT = this.banHangService.getAllHDCTTheoMaHD(txtHoaDonChon.getText());
        showDataHDCT(listHDCT);

        if (pageHoaDon.get(row).getTrangThai() != 1) {
            jButton2.setEnabled(false);
            btnThanhToan.setEnabled(false);
            btnHuyDon.setEnabled(false);
        } else {
            jButton2.setEnabled(true);
            btnThanhToan.setEnabled(true);
            btnHuyDon.setEnabled(true);
        }

        if (txtThanhTien.getText() != null) {
            float totalPrice = Float.valueOf(txtThanhTien.getText());
            if (totalPrice > 0) {
                listKhuyenMai.removeAll(listKhuyenMai);
                ccbKhuyenMai.removeAllItems();
                listKhuyenMai = banHangService.getAllMaKMTheoGiaApDung(totalPrice);
                dcbmKhuyenMai.addAll(listKhuyenMai);
            } else {
                listKhuyenMai.removeAll(listKhuyenMai);
                ccbKhuyenMai.removeAllItems();
                dcbmKhuyenMai.addAll(listKhuyenMai);
            }
        }

        ccbKhuyenMai.setSelectedItem(pageHoaDon.get(row).getMaKM());

        txtMaKH.setText(pageHoaDon.get(row).getMaKhachHang());

        System.out.println(pageHoaDon.get(row).toString());

//------------------------------------------------------------------------------
        String maKM = pageHoaDon.get(row).getMaKM();
        float tienKM = 0;
        float tongTien = Float.valueOf(txtThanhTien.getText());
        if (maKM == null) {
            int giaTriKM = banHangService.giaTriKM("KM0");
            tienKM = tongTien - giaTriKM;
            txtTienKM.setText(String.valueOf(tienKM));
        } else {
            int loaiKM = banHangService.loaiKM(maKM);
            if (loaiKM == 0) {
                int giaTriKM = banHangService.giaTriKM(maKM);
                tienKM = tongTien - giaTriKM;
                txtTienKM.setText(String.valueOf(tienKM));
            } else {
                int giaTriKM = banHangService.giaTriKM(maKM);
                tienKM = tongTien - (tongTien * (giaTriKM / 100.0f));
                txtTienKM.setText(String.valueOf(tienKM));
            }
        }
//------------------------------------------------------------------------------
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

//------------------------------------------------------------------------------
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
//------------------------------------------------------------------------------

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
        pageHoaDon.removeAll(pageHoaDon);
        pageHoaDon = this.banHangService.listGetAllHDPage(rowoffset);
        showDataHD(pageHoaDon);
    }

    public void resetTableCTSP() {
        String find = txtTimKiem.getText();

        if (find.isBlank()) {
            listCTSP.removeAll(listCTSP);
            listCTSP = this.banHangService.getAllCTSP();
            List<CTSPBanHang> filterData = filterData(listCTSP);
            displayProductFilter(filterData);
        } else {
            listCTSP.removeAll(listCTSP);
            listCTSP = this.banHangService.searchSP(find);
            List<CTSPBanHang> filterData = filterData(listCTSP);
            displayProductFilter(filterData);
        }

    }

    public void resetTableHDCT() {
        listHDCT.removeAll(listHDCT);
        listHDCT = this.banHangService.getAllHDCTTheoMaHD(txtHoaDonChon.getText());
        showDataHDCT(listHDCT);
    }

    public void clear() {
        txtHoaDonChon.setText("null");
        txtNgayTao.setDate(null);
        txtTenKH.setText("Khach Ban Le");
        txtMaKH.setText("KH00");
        txtThanhTien.setText("");
        txtTienKM.setText("");
        txtTienKhachTra.setText("");
        txtTimKiem.setText("");
        txtTienThua.setText("");
        ccbKhuyenMai.setSelectedItem(null);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    public javax.swing.JLabel txtTimer;
    // End of variables declaration//GEN-END:variables
}
