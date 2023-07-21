package View;

import Model.ChiTietSP;
import Service.SanPhamCTService;
import Util.DBConnect;
import ViewModels.SPCTViewModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class SanPhamCT extends javax.swing.JFrame {

    private SanPhamCTService service = new SanPhamCTService();
    private DefaultTableModel model;
    private List<SPCTViewModel> list = new LinkedList<>();
    private String pathImage = null;

    public SanPhamCT() {
        initComponents();
        this.loadTable();
        this.loadCbb();
        this.clear();
    }

    public void loadTable() {
        model = (DefaultTableModel) this.tblBangSP.getModel();
        model.setRowCount(0);
        list = this.service.all();
        for (SPCTViewModel spct : list) {
            model.addRow(new Object[]{
                spct.getId(),
                spct.getAnh(),
                spct.getMaSp(),
                spct.getTenSp(),
                spct.getSoLuong(),
                spct.getKichCo(),
                spct.getMauSac(),
                spct.getThuongHieu(),
                spct.getDong(),
                spct.getKieuDang(),
                spct.getChatLieu(),
                spct.getGiaNhap(),
                spct.getGiaBan(),
                spct.getNSX(),
                spct.getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh"
            });
        }
        this.initSearch();
    }

    public void initSearch() {
        txt_search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }

            public void search() {
                DefaultTableModel model = (DefaultTableModel) tblBangSP.getModel();
                model.setRowCount(0);
                String code = txt_search.getText();
                List<SPCTViewModel> tempList = new ArrayList<>();
                for (SPCTViewModel item : list) {
                    if (item.getMaSp().contains(code)) {
                        tempList.add(item);
                    }
                }
                for (SPCTViewModel spct : tempList) {
                    model.addRow(new Object[]{
                        spct.getId(),
                        spct.getAnh(),
                        spct.getMaSp(),
                        spct.getTenSp(),
                        spct.getSoLuong(),
                        spct.getKichCo(),
                        spct.getMauSac(),
                        spct.getThuongHieu(),
                        spct.getDong(),
                        spct.getKieuDang(),
                        spct.getChatLieu(),
                        spct.getGiaNhap(),
                        spct.getGiaBan(),
                        spct.getNSX(),
                        spct.getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh"});
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbAnh = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        cbbTH = new javax.swing.JComboBox<>();
        cbbMS = new javax.swing.JComboBox<>();
        cbbKD = new javax.swing.JComboBox<>();
        cbbCL = new javax.swing.JComboBox<>();
        cbbNSX = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtSoL = new javax.swing.JTextField();
        cbbSP = new javax.swing.JComboBox<>();
        btnThemSp = new javax.swing.JButton();
        cbbDong = new javax.swing.JComboBox<>();
        cbbKC = new javax.swing.JComboBox<>();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        rdhd = new javax.swing.JRadioButton();
        rdno = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBangSP = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        rdHD = new javax.swing.JRadioButton();
        rdNo = new javax.swing.JRadioButton();
        rdAll = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lí Sản Phẩm");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        lbAnh.setBackground(new java.awt.Color(255, 255, 255));
        lbAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAnhMouseClicked(evt);
            }
        });

        jLabel3.setText("Tên SP: ");

        jLabel4.setText("Mã SP:");

        jLabel5.setText("Thương hiệu");

        jLabel6.setText("Kích cỡ:");

        jLabel7.setText("Màu sắc: ");

        jLabel8.setText("Dòng: ");

        jLabel9.setText("Kiểu dáng:");

        jLabel10.setText("Chất liệu:");

        jLabel11.setText("Giá nhập:");

        jLabel12.setText("NSX:");

        jLabel13.setText("Giá bán:");

        cbbTH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbTHMouseClicked(evt);
            }
        });

        cbbMS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbMSMouseClicked(evt);
            }
        });

        cbbKD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbKDMouseClicked(evt);
            }
        });

        cbbCL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbCLMouseClicked(evt);
            }
        });

        cbbNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbNSXMouseClicked(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 204, 51));
        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 204, 51));
        jButton6.setText("+");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 204, 51));
        jButton7.setText("+");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 204, 51));
        jButton10.setText("+");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 204, 51));
        jButton11.setText("+");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel16.setText("Số lượng:");

        cbbSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbSPMouseClicked(evt);
            }
        });
        cbbSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSPActionPerformed(evt);
            }
        });

        btnThemSp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemSp.setForeground(new java.awt.Color(0, 204, 51));
        btnThemSp.setText("+");
        btnThemSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSpActionPerformed(evt);
            }
        });

        cbbDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbDongMouseClicked(evt);
            }
        });

        cbbKC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbKCMouseClicked(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton13.setForeground(new java.awt.Color(0, 204, 51));
        jButton13.setText("+");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton14.setForeground(new java.awt.Color(0, 204, 51));
        jButton14.setText("+");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel15.setText("Trạng thái:");

        buttonGroup1.add(rdhd);
        rdhd.setText("Hoạt động");

        buttonGroup1.add(rdno);
        rdno.setText("Không hoạt động");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdhd, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdno)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbbKD, javax.swing.GroupLayout.Alignment.LEADING, 0, 92, Short.MAX_VALUE)
                                    .addComponent(cbbMS, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbTH, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnThemSp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaBan)
                                    .addComponent(txtGiaNhap))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbKC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbDong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbNSX, 0, 136, Short.MAX_VALUE)
                                    .addComponent(cbbCL, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSoL))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemSp))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(cbbTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addComponent(cbbKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(cbbMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10)
                            .addComponent(cbbDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(cbbKD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6)
                            .addComponent(jButton11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txtSoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(rdhd)
                    .addComponent(rdno))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tblBangSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ảnh", "Mã SP", "Tên SP", "Số lượng", "Kích cỡ", "Màu sắc", "Thương hiệu", "Dòng", "Kiểu dáng", "Chất liệu", "Giá nhập", "Giá bán", "NSX", "Trạng thái"
            }
        ));
        tblBangSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBangSP);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Tìm kiếm:");

        txt_search.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_searchInputMethodTextChanged(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setEnabled(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnImport.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImport.setText("Import execl");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdHD);
        rdHD.setText("Hoạt động");
        rdHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdHDActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdNo);
        rdNo.setText("Không hoạt động");
        rdNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNoActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdAll);
        rdAll.setText("Tất cả");
        rdAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdHD, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdNo)
                .addGap(18, 18, 18)
                .addComponent(rdAll, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImport)
                .addGap(5, 5, 5)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdHD)
                            .addComponent(rdNo)
                            .addComponent(rdAll)))
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(349, 349, 349))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSpActionPerformed
        SanPham sp = new SanPham();
        sp.setVisible(true);
    }//GEN-LAST:event_btnThemSpActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        MauSac ms = new MauSac();
        ms.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ThuongHieu th = new ThuongHieu();
        th.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        KichCo kc = new KichCo();
        kc.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        KieuDang kd = new KieuDang();
        kd.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        NSX nsx = new NSX();
        nsx.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        DongSP dong = new DongSP();
        dong.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ChatLieu cl = new ChatLieu();
        cl.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void lbAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAnhMouseClicked
        try {
            JFileChooser fchooser = new JFileChooser("C:\\Ki_5\\DuAn1\\Du_an_ban_giay-master\\Du_an_ban_giay-master\\src\\main\\java\\icon");
            int choosed = fchooser.showOpenDialog(this.getRootPane());
            if (choosed != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File f = fchooser.getSelectedFile();
            if (!f.exists()) {
                JOptionPane.showMessageDialog(rootPane, "Ảnh không tồn tại");
                return;
            }
            ImageIcon icon = new ImageIcon(f.getAbsolutePath());
            this.pathImage = f.getAbsolutePath();
            this.lbAnh.setIcon(icon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn ảnh");
        }
    }//GEN-LAST:event_lbAnhMouseClicked

    private void tblBangSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangSPMouseClicked
        int index = tblBangSP.getSelectedRow();
        if (index == -1) {
            return;
        }

        String anh = tblBangSP.getValueAt(index, 1).toString();
        System.out.println(anh);
        ImageIcon imageIcon = new ImageIcon(anh);
        lbAnh.setIcon(imageIcon);

        String ma = tblBangSP.getValueAt(index, 2).toString();
        String ten = tblBangSP.getValueAt(index, 3).toString();
        String sl = tblBangSP.getValueAt(index, 4).toString();
        String kichco = tblBangSP.getValueAt(index, 5).toString();
        String ms = tblBangSP.getValueAt(index, 6).toString();
        String th = tblBangSP.getValueAt(index, 7).toString();
        String dong = tblBangSP.getValueAt(index, 8).toString();
        String kieudang = tblBangSP.getValueAt(index, 9).toString();
        String chatlieu = tblBangSP.getValueAt(index, 10).toString();
        String gianhap = tblBangSP.getValueAt(index, 11).toString();
        String giaban = tblBangSP.getValueAt(index, 12).toString();
        String nsx = tblBangSP.getValueAt(index, 13).toString();
        String trangThai = tblBangSP.getValueAt(index, 14).toString();

        txtMa.setText(ma);
        cbbSP.setSelectedItem(ten.toString());
        txtSoL.setText(sl);
        cbbKC.setSelectedItem(kichco.toString());
        cbbMS.setSelectedItem(ms.toString());
        cbbTH.setSelectedItem(th.toString());
        cbbDong.setSelectedItem(dong.toString());
        cbbKD.setSelectedItem(kieudang.toString());
        cbbCL.setSelectedItem(chatlieu.toString());
        txtGiaNhap.setText(gianhap);
        txtGiaBan.setText(giaban);
        cbbNSX.setSelectedItem(nsx.toString());

        if (trangThai.equals("Hoạt động")) {
            rdhd.setSelected(true);
        } else {
            rdno.setSelected(true);
        }

        btnThem.setEnabled(false);
        txtMa.setEnabled(false);
        btnSua.setEnabled(true);

    }//GEN-LAST:event_tblBangSPMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int cf = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn thêm ?");
        if (cf == JOptionPane.YES_OPTION) {

            if (checkData()) {
                if (checkMaSPAdd()) {
                    Integer idSanPham = service.getIDBySP(cbbSP.getSelectedItem().toString());
                    Integer brandId = service.getIDByThuongHieu(cbbTH.getSelectedItem().toString());
                    Integer colorId = service.getIDByMauSac(cbbMS.getSelectedItem().toString());
                    Integer modelId = service.getIDByKieuDang(cbbKD.getSelectedItem().toString());
                    Float price = Float.parseFloat(txtGiaNhap.getText());
                    Float priceSale = Float.parseFloat(txtGiaBan.getText());
                    String masp = txtMa.getText();
                    Integer trangThai;
                    if (rdhd.isSelected() == true) {
                        trangThai = 0;
                    } else {
                        trangThai = 1;
                    }
                    Integer sizeId = service.getIDByKichCo(cbbKC.getSelectedItem().toString());
                    Integer dong = service.getIDByDongSP(cbbDong.getSelectedItem().toString());
                    Integer chatLieu = service.getIDByChatLieu(cbbCL.getSelectedItem().toString());
                    Integer nxdId = service.getIDByNSX(cbbNSX.getSelectedItem().toString());
                    Integer soLuong = Integer.parseInt(txtSoL.getText());
                    String anh = this.pathImage;
                    ChiTietSP ctsp = new ChiTietSP();
                    ctsp.setAnh(anh);
                    ctsp.setGiaBan(priceSale);
                    ctsp.setGiaNhap(price);
                    ctsp.setIdCL(chatLieu);
                    ctsp.setIdDong(dong);
                    ctsp.setIdKC(sizeId);
                    ctsp.setIdKD(modelId);
                    ctsp.setIdMS(colorId);
                    ctsp.setIdNSX(nxdId);
                    ctsp.setIdSP(idSanPham);
                    ctsp.setIdTH(brandId);
                    ctsp.setMaCTSP(masp);
                    ctsp.setSoLuongTon(soLuong);
                    ctsp.setTrangThai(trangThai);
                    if (service.add(ctsp)) {
                        this.loadTable();
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }
                }
                this.pathImage = null;
                this.clear();
            }
        } else {
            return;
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int cf = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn sửa ?");

        if (cf == JOptionPane.YES_OPTION) {
            String anh = null;
            if (checkData()) {
                for (SPCTViewModel x : list) {
                    if (x.getMaSp().equals(txtMa.getText())) {
                        anh = x.getAnh();
                    }
                }
                Integer idSanPham = service.getIDBySP(cbbSP.getSelectedItem().toString());
                Integer brandId = service.getIDByThuongHieu(cbbTH.getSelectedItem().toString());
                Integer colorId = service.getIDByMauSac(cbbMS.getSelectedItem().toString());
                Integer modelId = service.getIDByKieuDang(cbbKD.getSelectedItem().toString());
                Float price = Float.parseFloat(txtGiaNhap.getText());
                Float priceSale = Float.parseFloat(txtGiaBan.getText());
                String masp = txtMa.getText();
                int trangThai;
                if (rdhd.isSelected() == true) {
                    trangThai = 0;
                } else {
                    trangThai = 1;
                }
                Integer sizeId = service.getIDByKichCo(cbbKC.getSelectedItem().toString());
                Integer dong = service.getIDByDongSP(cbbDong.getSelectedItem().toString());
                Integer chatLieu = service.getIDByChatLieu(cbbCL.getSelectedItem().toString());
                Integer nxdId = service.getIDByNSX(cbbNSX.getSelectedItem().toString());
                Integer soLuong = Integer.parseInt(txtSoL.getText());
                ChiTietSP ctsp = new ChiTietSP();
                if (this.pathImage == null) {
                    ctsp.setAnh(anh);
                } else {
                    ctsp.setAnh(this.pathImage);
                }
                ctsp.setGiaBan(priceSale);
                ctsp.setGiaNhap(price);
                ctsp.setIdCL(chatLieu);
                ctsp.setIdDong(dong);
                ctsp.setIdKC(sizeId);
                ctsp.setIdKD(modelId);
                ctsp.setIdMS(colorId);
                ctsp.setIdNSX(nxdId);
                ctsp.setIdSP(idSanPham);
                ctsp.setIdTH(brandId);
                ctsp.setMaCTSP(masp);
                ctsp.setSoLuongTon(soLuong);
                ctsp.setTrangThai(trangThai);
                if (service.update(ctsp)) {
                    this.loadTable();

                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
                this.clear();
            }

        } else {
            return;
        }


    }//GEN-LAST:event_btnSuaActionPerformed

    private void txt_searchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_searchInputMethodTextChanged

    }//GEN-LAST:event_txt_searchInputMethodTextChanged

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        this.clear();
        btnThem.setEnabled(true);
        btnSua.setEnabled(false);
        txtMa.setEnabled(true);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
//        ImportExcelSanPham ex = new ImportExcelSanPham();
//        ex.setVisible(true);

        this.importDataFromExcel();
        this.loadCbb();
    }//GEN-LAST:event_btnImportActionPerformed

    private void importDataFromExcel() {
        JFileChooser fileChooser = new JFileChooser("D:\\");
        int returnVal = fileChooser.showOpenDialog(this.getRootPane());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                FileInputStream excelFile = new FileInputStream(file);
                Workbook workbook = new XSSFWorkbook(excelFile);
                Sheet sheet = workbook.getSheetAt(0);

                int startingRow = 1;
                for (int rowNum = startingRow; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    Row row = sheet.getRow(rowNum);
                    ChiTietSP ctsp = new ChiTietSP();
                    Cell cell;

                    // Lấy giá trị từ ô có kiểu dữ liệu là chuỗi (STRING cell)
                    cell = row.getCell(1); // Ví dụ: ô cột A
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            String stringValue = cell.getStringCellValue();
                            ctsp.setAnh(row.getCell(1).getStringCellValue());
                        }
                    }
                    cell = row.getCell(2); // Ví dụ: ô cột A
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            String stringValue = cell.getStringCellValue();
                            ctsp.setMaCTSP(row.getCell(2).getStringCellValue());
                        }
                    }
                    cell = row.getCell(3); // Ví dụ: ô cột A
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            double numericValue = cell.getNumericCellValue();
                            ctsp.setIdSP((int) row.getCell(3).getNumericCellValue());
                        }
                    }
                    cell = row.getCell(4); // Ví dụ: ô cột B
                    if (cell != null) {
                        if (cell.getCellType() == CellType.NUMERIC) {
                            double numericValue = cell.getNumericCellValue();
                            ctsp.setSoLuongTon((int) row.getCell(4).getNumericCellValue());
                        }
                    }
                    cell = row.getCell(5); // Ví dụ: ô cột A
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            double numericValue = cell.getNumericCellValue();
                            ctsp.setIdKC((int) row.getCell(5).getNumericCellValue());
                        }
                    }
                    cell = row.getCell(6); // Ví dụ: ô cột A
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            double numericValue = cell.getNumericCellValue();
                            ctsp.setIdMS((int) row.getCell(6).getNumericCellValue());
                        }
                    }
                    cell = row.getCell(7); // Ví dụ: ô cột A
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            double numericValue = cell.getNumericCellValue();
                            ctsp.setIdTH((int) row.getCell(7).getNumericCellValue());
                        }
                    }
                    cell = row.getCell(8); // Ví dụ: ô cột A
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            double numericValue = cell.getNumericCellValue();
                            ctsp.setIdDong((int) row.getCell(8).getNumericCellValue());
                        }
                    }
                    cell = row.getCell(9); // Ví dụ: ô cột A
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            double numericValue = cell.getNumericCellValue();
                            ctsp.setIdKD((int) row.getCell(9).getNumericCellValue());
                        }
                    }
                    cell = row.getCell(10); // Ví dụ: ô cột A
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            double numericValue = cell.getNumericCellValue();
                            ctsp.setIdCL((int) row.getCell(10).getNumericCellValue());
                        }
                    }
                    cell = row.getCell(11); // Ví dụ: ô cột B
                    if (cell != null) {
                        if (cell.getCellType() == CellType.NUMERIC) {
                            double numericValue = cell.getNumericCellValue();
                            ctsp.setGiaNhap((float) row.getCell(11).getNumericCellValue());
                        }
                    }
                    cell = row.getCell(12); // Ví dụ: ô cột B
                    if (cell != null) {
                        if (cell.getCellType() == CellType.NUMERIC) {
                            double numericValue = cell.getNumericCellValue();
                            ctsp.setGiaBan((float) row.getCell(12).getNumericCellValue());
                        }
                    }
                    cell = row.getCell(13); // Ví dụ: ô cột A
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            double numericValue = cell.getNumericCellValue();
                            ctsp.setIdNSX((int) row.getCell(13).getNumericCellValue());
                        }
                    }
                    cell = row.getCell(14); // Ví dụ: ô cột B
                    if (cell != null) {
                        if (cell.getCellType() == CellType.NUMERIC) {
                            double numericValue = cell.getNumericCellValue();
                            ctsp.setTrangThai((int) row.getCell(14).getNumericCellValue());
                        }
                    }
                    cell = row.getCell(0); // Ví dụ: ô cột B
                    if (cell != null) {
                        if (cell.getCellType() == CellType.NUMERIC) {
                            double numericValue = cell.getNumericCellValue();
                            ctsp.setIdChiTietSP((int) row.getCell(0).getNumericCellValue());
                        }
                    }
//                    

                    saveToDatabase(ctsp);
                }

                workbook.close();
                excelFile.close();
                JOptionPane.showMessageDialog(getRootPane(), "Dữ liệu đã được import thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(getRootPane(), "Lỗi khi import dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Không có tệp được chọn.");
        }
    }

    private void saveToDatabase(ChiTietSP ctsp) throws SQLException {
        int check = 0;
        String sql = """
                       INSERT INTO [dbo].[chi_tiet_san_pham]
                                  ([anh]
                                  ,[maCTSP]
                                  ,[idSanPham]
                                  ,[soLuongTon]
                                  ,[idKichCo]
                                  ,[idMauSac]
                                  ,[idThuongHieu]
                                  ,[idDongSP]
                                  ,[idKieuDang]
                                  ,[idChatLieu]
                                  ,[giaNhap]
                                  ,[giaBan]
                                  ,[idNSX]
                                  ,[trang_thai])
                            VALUES
                                  (?,?,?,?,?,?,?,?,?,?,?,?,?,?)
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            PreparedStatement statement = con.prepareStatement(sql);
            ps.setObject(1, ctsp.getAnh());
            ps.setObject(2, ctsp.getMaCTSP());
            ps.setObject(3, ctsp.getIdSP());
            ps.setObject(4, ctsp.getSoLuongTon());
            ps.setObject(5, ctsp.getIdKC());
            ps.setObject(6, ctsp.getIdMS());
            ps.setObject(7, ctsp.getIdTH());
            ps.setObject(8, ctsp.getIdDong());
            ps.setObject(9, ctsp.getIdKD());
            ps.setObject(10, ctsp.getIdCL());
            ps.setObject(11, ctsp.getGiaNhap());
            ps.setObject(12, ctsp.getGiaBan());
            ps.setObject(13, ctsp.getIdNSX());
            ps.setObject(14, ctsp.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void cbbSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbSPMouseClicked
        cbbSP.removeAllItems();
        loadCbb();
    }//GEN-LAST:event_cbbSPMouseClicked

    private void cbbNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbNSXMouseClicked
        cbbNSX.removeAllItems();
        loadCbb();
    }//GEN-LAST:event_cbbNSXMouseClicked

    private void rdAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAllActionPerformed

        this.loadTable();
        return;
    }//GEN-LAST:event_rdAllActionPerformed

    private void rdNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNoActionPerformed
        model = (DefaultTableModel) this.tblBangSP.getModel();
        model.setRowCount(0);
        list = this.service.getSPByTT(1);
        for (SPCTViewModel spct : list) {
            model.addRow(new Object[]{
                spct.getId(),
                spct.getAnh(),
                spct.getMaSp(),
                spct.getTenSp(),
                spct.getSoLuong(),
                spct.getKichCo(),
                spct.getMauSac(),
                spct.getThuongHieu(),
                spct.getDong(),
                spct.getKieuDang(),
                spct.getChatLieu(),
                spct.getGiaNhap(),
                spct.getGiaBan(),
                spct.getNSX(),
                spct.getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh"
            });
        }
        this.initSearch();

    }//GEN-LAST:event_rdNoActionPerformed

    private void rdHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdHDActionPerformed
        model = (DefaultTableModel) this.tblBangSP.getModel();
        model.setRowCount(0);
        list = this.service.getSPByTT(0);
        for (SPCTViewModel spct : list) {
            model.addRow(new Object[]{
                spct.getId(),
                spct.getAnh(),
                spct.getMaSp(),
                spct.getTenSp(),
                spct.getSoLuong(),
                spct.getKichCo(),
                spct.getMauSac(),
                spct.getThuongHieu(),
                spct.getDong(),
                spct.getKieuDang(),
                spct.getChatLieu(),
                spct.getGiaNhap(),
                spct.getGiaBan(),
                spct.getNSX(),
                spct.getTrangThai() == 0 ? "Đang kinh doanh" : "Ngừng kinh doanh"
            });
        }
        this.initSearch();
    }//GEN-LAST:event_rdHDActionPerformed

    private void cbbTHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbTHMouseClicked
        cbbTH.removeAllItems();
        loadCbb();
    }//GEN-LAST:event_cbbTHMouseClicked

    private void cbbMSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbMSMouseClicked
        cbbMS.removeAllItems();
        loadCbb();
    }//GEN-LAST:event_cbbMSMouseClicked

    private void cbbKDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKDMouseClicked
        cbbKD.removeAllItems();
        loadCbb();
    }//GEN-LAST:event_cbbKDMouseClicked

    private void cbbKCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKCMouseClicked
        cbbKC.removeAllItems();
        loadCbb();
    }//GEN-LAST:event_cbbKCMouseClicked

    private void cbbDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbDongMouseClicked
        cbbDong.removeAllItems();
        loadCbb();
    }//GEN-LAST:event_cbbDongMouseClicked

    private void cbbCLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbCLMouseClicked
        cbbCL.removeAllItems();
        loadCbb();
    }//GEN-LAST:event_cbbCLMouseClicked

    private void cbbSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSPActionPerformed
    public void clear() {
        this.txtGiaBan.setText("");
        this.txtGiaNhap.setText("");
        this.txtMa.setText("");
        this.txtSoL.setText("");
        this.lbAnh.setIcon(null);
    }

    public boolean checkData() {
        if (txtMa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống!");
            return false;
        } else if (txtSoL.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số Lượng Tồn không được để trống!");
            return false;
        } else if (txtGiaNhap.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giá Nhập không được để trống!");
            return false;
        } else if (txtGiaBan.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giá Bán không được để trống!");
            return false;
        } else if (!checkNumber(txtSoL.getText().trim())) {
            return false;
        } else if (!checkNumber(txtGiaNhap.getText().trim())) {
            return false;
        } else if (!checkNumber(txtGiaBan.getText().trim())) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkNumber(String number) {
        String kytu = "\\d+";
        if (number.matches(kytu)) {
            if (Integer.valueOf(number) < 0) {
                JOptionPane.showMessageDialog(this, "Dự liệu không hợp lệ");
                return false;
            } else {
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!");
            return false;
        }
    }

    public boolean checkMaSPAdd() {
        String ma = this.txtMa.getText();
        for (SPCTViewModel ctsp : list) {
            if (ctsp.getMaSp().equalsIgnoreCase(ma)) {
                JOptionPane.showMessageDialog(this, "Mã Sản Phẩm đã tồn tại dữ liệu chi tiết!");
                return false;
            }
        }
        return true;
    }

    private void loadCbb() {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM san_pham";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbbSP.addItem(rs.getString("tenSanPham"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM thuong_hieu";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbbTH.addItem(rs.getString("tenThuongHieu"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM mau_sac";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbbMS.addItem(rs.getString("tenMauSac"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM kieu_dang";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbbKD.addItem(rs.getString("tenKieuDang"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM kich_co";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbbKC.addItem(rs.getString("tenKichCo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM dong_sp";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbbDong.addItem(rs.getString("tenDongSP"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM chat_lieu";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbbCL.addItem(rs.getString("daChinh"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM NSX";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbbNSX.addItem(rs.getString("tenNSX"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SanPhamCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPhamCT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemSp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbCL;
    private javax.swing.JComboBox<String> cbbDong;
    private javax.swing.JComboBox<String> cbbKC;
    private javax.swing.JComboBox<String> cbbKD;
    private javax.swing.JComboBox<String> cbbMS;
    private javax.swing.JComboBox<String> cbbNSX;
    private javax.swing.JComboBox<String> cbbSP;
    private javax.swing.JComboBox<String> cbbTH;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAnh;
    private javax.swing.JRadioButton rdAll;
    private javax.swing.JRadioButton rdHD;
    private javax.swing.JRadioButton rdNo;
    private javax.swing.JRadioButton rdhd;
    private javax.swing.JRadioButton rdno;
    private javax.swing.JTable tblBangSP;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSoL;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
