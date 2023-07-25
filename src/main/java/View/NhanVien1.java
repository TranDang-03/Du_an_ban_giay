/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import Service.NhanVienService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Util.DBConnect;
import Model.NhanVien;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.PreparedStatement;
import java.sql.Connection;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author admin
 */
public class NhanVien1 extends javax.swing.JDialog {

    /**
     * Creates new form NhanVien1
     */
    private NhanVienService service = new NhanVienService();
    private DefaultTableModel model;
    private List<Model.NhanVien> listnv = new ArrayList<>();

    public NhanVien1() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) this.tblnv.getModel();
        this.loadTable();
        this.clear();
    }

    public void loadTable() {
        ArrayList<Model.NhanVien> list = this.service.all();
        model.setRowCount(0);
        listnv = this.service.all();
        for (Model.NhanVien nv : list) {
            model.addRow(new Object[]{
                nv.getMaNV(),
                nv.getTenNV(),
                nv.isGioiTinh() == true ? "Nam " : "Nữ",
                nv.getNgSinh(),
                nv.getSdt(),
                nv.getDiaChi(),
                nv.getChucVu() == 0 ? "Trưởng phòng" : "Nhân viên",
                nv.getLuong(),
                nv.getTaiKhoan(),
                nv.getMatKhau(),
                nv.getTrangThai() == 0 ? "Hoạt động" : "Không hoạt động"
            });
            this.initSearch();
        }
    }

    public void initSearch() {
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
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
                DefaultTableModel model = (DefaultTableModel) tblnv.getModel();
                model.setRowCount(0);
                String code = txtTimKiem.getText();
                List<NhanVien> tempList = new ArrayList<>();
                for (NhanVien item : listnv) {
                    if (item.getMaNV().contains(code)) {
                        tempList.add(item);
                    }
                }
                for (NhanVien nv : tempList) {
                    model.addRow(new Object[]{
                        nv.getMaNV(),
                        nv.getTenNV(),
                        nv.isGioiTinh() == true ? "Nam " : "Nữ",
                        nv.getNgSinh(),
                        nv.getSdt(),
                        nv.getDiaChi(),
                        nv.getChucVu() == 0 ? "Trưởng phòng" : "Nhân viên",
                        nv.getLuong(),
                        nv.getTaiKhoan(),
                        nv.getMatKhau(),
                        nv.getTrangThai() == 0 ? "Hoạt động" : "Không hoạt động"});
                }
            }
        });

    }

    public void clear() {

        this.txtNgaySinh.setText("");
        this.txtma.setText("");
        this.txtten.setText("");
        this.txt_Luong.setText("");
        this.txt_sdt.setText("");
        this.txtTK.setText("");
        this.txtMK.setText("");
        this.txtDiaChi.setText("");

        this.cbbnv.setSelectedItem(true);
    }

    public boolean checkData() {
        if (txtma.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống!");
            return false;
        } else if (txtNgaySinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống!");
            return false;
        } else if (txtten.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa Chỉ không được để trống!");
            return false;
        } else if (txt_Luong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày Sinh không được để trống!");
            return false;

        } else if (txt_sdt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sdt không được để trống!");
            return false;
        } else if (txtTK.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sdt không được để trống!");
            return false;
        } else if (txtMK.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sdt không được để trống!");
            return false;

        } else {
            return true;
        }
    }

//    
//
    public boolean checkMaNVAdd() {
        String ma = this.txtma.getText();
        for (Model.NhanVien nhanVien : listnv) {
            if (nhanVien.getMaNV().equalsIgnoreCase(ma)) {
                JOptionPane.showMessageDialog(this, "Mã Nhân Viên đã tồn tại");
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtten = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rd_nam = new javax.swing.JRadioButton();
        rd_nu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rd_ql = new javax.swing.JRadioButton();
        rd_nv = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_Luong = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbbnv = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtMK = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblnv = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Mã NV:");

        jLabel3.setText("Tên NV: ");

        txtten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenActionPerformed(evt);
            }
        });

        jLabel4.setText("Ngày sinh:");

        jLabel5.setText("SĐT:");

        txt_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sdtActionPerformed(evt);
            }
        });

        jLabel6.setText("Giới tính:");

        buttonGroup1.add(rd_nam);
        rd_nam.setSelected(true);
        rd_nam.setText("Nam");
        rd_nam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_namMouseClicked(evt);
            }
        });

        buttonGroup1.add(rd_nu);
        rd_nu.setText("Nữ");

        jLabel7.setText("Địa chỉ:");

        jLabel8.setText("Chức vụ:");

        buttonGroup2.add(rd_ql);
        rd_ql.setSelected(true);
        rd_ql.setText("Trưởng phòng");
        rd_ql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_qlActionPerformed(evt);
            }
        });

        buttonGroup2.add(rd_nv);
        rd_nv.setText("Nhân viên");

        jLabel9.setText("Tài khoản:");

        jLabel10.setText("Lương:");

        jLabel11.setText("Trạng thái:");

        cbbnv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));

        jLabel12.setText("Mật khẩu:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        jButton4.setText("Mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 102, 0));
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("import Excel");
        jButton11.setBorder(null);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtma)
                                    .addComponent(txtNgaySinh)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rd_ql)
                                        .addGap(18, 18, 18)
                                        .addComponent(rd_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_Luong, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbnv, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(198, 198, 198)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(32, 32, 32)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtten)
                            .addComponent(txt_sdt)
                            .addComponent(txtDiaChi)
                            .addComponent(txtTK)
                            .addComponent(txtMK, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rd_nam)
                            .addComponent(rd_nu)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_ql)
                            .addComponent(rd_nv)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbbnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lí Nhân Viên");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tblnv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Giới Tính", "Ngày Sinh", "Sđt", "Địa chỉ", "Chức Vụ", "Lương", "Tên Tk", "Mật Khẩu", "Trạng Thái"
            }
        ));
        tblnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblnv);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Tìm kiếm:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 554, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(337, 337, 337))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String maNhanVien = this.txtma.getText();
        String tenNhanVien = this.txtten.getText();
        boolean gioiTinh;
        if (rd_nam.isSelected() == true) {
            gioiTinh = true;
        } else {
            gioiTinh = false;
        }
        int chucVu;
        if (rd_ql.isSelected() == true) {
            chucVu = 0;
        } else {
            chucVu = 1;
        }
        int trangThai = Integer.parseInt(cbbnv.getSelectedItem().toString());
//      
        String ngaySinh = txtNgaySinh.getText();
        Date dateNgaySinh;
        try {
            dateNgaySinh = new SimpleDateFormat("yyyy-mm-dd").parse(ngaySinh);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Bạn cần nhập ngày bắt đầu theo định dạng Year/Month/Day");
            return;
        }
        float luong = Float.parseFloat(txt_Luong.getText());
        String Luong = String.valueOf(txt_Luong.getText());
        String diaChi = this.txtDiaChi.getText();
        String sdt = this.txt_sdt.getText();
        String taiKhoan = this.txtTK.getText();
        String matKhau = this.txtMK.getText();

        Model.NhanVien nv = new Model.NhanVien(0, maNhanVien, tenNhanVien, gioiTinh, dateNgaySinh, diaChi, sdt, chucVu, trangThai, luong, taiKhoan, matKhau);

        boolean a = this.service.update(nv);

        if (a == true) {
            JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
            return;
        }

        this.clear();
        this.loadTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.clear();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rd_qlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_qlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_qlActionPerformed

    private void txt_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sdtActionPerformed

    private void rd_namMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_namMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_namMouseClicked

    private void tblnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnvMouseClicked
        // TODO add your handling code here:
        int index = this.tblnv.getSelectedRow();
//        String idNhanVien = model.getValueAt(index, 0).toString();
        String maNhanVien = model.getValueAt(index, 0).toString();
        String tenNhanVien = model.getValueAt(index, 1).toString();
        String gioiTinh = model.getValueAt(index, 2).toString();
        String ngaySinh = model.getValueAt(index, 3).toString();
        String sdt = model.getValueAt(index, 4).toString();
        String diaChi = model.getValueAt(index, 5).toString();
        String chucVu = model.getValueAt(index, 6).toString();
        String luong = model.getValueAt(index, 7).toString();
        String tenTaiKhoan = model.getValueAt(index, 8).toString();
        String matKhau = model.getValueAt(index, 9).toString();
        String trangThai = model.getValueAt(index, 10).toString();

        this.txtma.setText(maNhanVien);
        this.txtten.setText(tenNhanVien);
//        Boolean setGioiTinh = gioiTinh.equalsIgnoreCase("Nam") ? true : false;
//        if (setGioiTinh == true) {
//            rd_nam.setSelected(true);
//        } else {
//            rd_nu.setSelected(true);
//        }
        if (gioiTinh.equals("Nữ")) {
            rd_nu.setSelected(true);
        } else {
            rd_nam.setSelected(true);
        }
//        Boolean setChucVu = chucVu.equalsIgnoreCase("1") ? true : false;
//        if (setChucVu == true) {
//            rd_ql.setSelected(true);
//        } else {
//            rd_nv.setSelected(true);
//        }
        if (chucVu.equals("Trưởng phòng")) {
            rd_ql.setSelected(true);
        } else {
            rd_nv.setSelected(true);
        }
        this.txt_Luong.setText(luong);
        this.txtNgaySinh.setText(ngaySinh);
        this.txt_sdt.setText(sdt);
        this.txtMK.setText(matKhau);
        this.txtTK.setText(tenTaiKhoan);
        this.txtDiaChi.setText(diaChi);
        this.cbbnv.setSelectedItem(trangThai);
    }//GEN-LAST:event_tblnvMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        String maNhanVien = this.txtma.getText();
//        String tenNhanVien = this.txtten.getText();
//        boolean gioiTinh;
//        if (rd_nam.isSelected() == true) {
//            gioiTinh = true;
//        } else {
//            gioiTinh = false;
//        }
//        int chucVu;
//        if (rd_ql.isSelected() == true) {
//            chucVu = 1;
//        } else {
//            chucVu = 0;
//        }
//        int trangThai = Integer.parseInt(cbbnv.getSelectedItem().toString());
////      
//        String ngaySinh = txtNgaySinh.getText();
//        Date dateNgaySinh;
//        try {
//            dateNgaySinh = new SimpleDateFormat("yyyy-mm-dd").parse(ngaySinh);
//        } catch (ParseException ex) {
//            JOptionPane.showMessageDialog(this, "Bạn cần nhập ngày bắt đầu theo định dạng Year/Month/Day");
//            return;
//        }
//        float luong = Float.parseFloat(txt_Luong.getText());
//        String Luong = String.valueOf(txt_Luong.getText());
//        String diaChi = this.txtDiaChi.getText();
//        String sdt = this.txt_sdt.getText();
//        String taiKhoan = this.txtTK.getText();
//        String matKhau = this.txtMK.getText();
//
//        Model.NhanVien nv = new Model.NhanVien(0, maNhanVien, tenNhanVien, gioiTinh, dateNgaySinh, diaChi, sdt, chucVu, trangThai, luong, taiKhoan, matKhau);
//
//        boolean a = this.service.insert(nv);
//
//        if (a == true) {
//            JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Thêm thất bại");
//            return;
//        }
//
//        this.clear();
//        this.loadTable();
        int cf = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn thêm ?");
        if (cf == JOptionPane.YES_OPTION) {

            if (checkData()) {
                if (checkMaNVAdd()) {
                    String maNhanVien = this.txtma.getText();
                    String tenNhanVien = this.txtten.getText();
                    boolean gioiTinh;
                    if (rd_nam.isSelected() == true) {
                        gioiTinh = true;
                    } else {
                        gioiTinh = false;
                    }
                    int chucVu;
                    if (rd_ql.isSelected() == true) {
                        chucVu = 1;
                    } else {
                        chucVu = 0;
                    }
                    int trangThai = Integer.parseInt(cbbnv.getSelectedItem().toString());
//      
                    String ngaySinh = txtNgaySinh.getText();
                    Date dateNgaySinh;
                    try {
                        dateNgaySinh = new SimpleDateFormat("yyyy-mm-dd").parse(ngaySinh);
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(this, "Bạn cần nhập ngày bắt đầu theo định dạng Year/Month/Day");
                        return;
                    }
                    float luong = Float.parseFloat(txt_Luong.getText());
                    String Luong = String.valueOf(txt_Luong.getText());
                    String diaChi = this.txtDiaChi.getText();
                    String sdt = this.txt_sdt.getText();
                    String taiKhoan = this.txtTK.getText();
                    String matKhau = this.txtMK.getText();

                    Model.NhanVien nv = new Model.NhanVien(0, maNhanVien, tenNhanVien, gioiTinh, dateNgaySinh, diaChi, sdt, chucVu, trangThai, luong, taiKhoan, matKhau);

                    boolean a = this.service.insert(nv);

                    if (a == true) {
                        JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Thêm thất bại");
                        return;
                    }

                    this.clear();
                    this.loadTable();
                }
            } else {
                return;
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed
    DefaultTableModel dtm;
    private void txttenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        dtm = (DefaultTableModel) tblnv.getModel();
        dtm.setRowCount(0);
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportWorkBook = null;
        String currentDirectoryPath = "C:\\Users\\admin\\Documents";
        JFileChooser ejfc = new JFileChooser(currentDirectoryPath);
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Excel file", "xls", "xlsx", "xslm");
        ejfc.setFileFilter(extensionFilter);
        int excelchooser = ejfc.showOpenDialog(null);
        if (excelchooser == JFileChooser.APPROVE_OPTION) {
            try {
                File excelFile = ejfc.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImportWorkBook = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImportWorkBook.getSheetAt(0);
                for (int i = 1; i < excelSheet.getLastRowNum(); i++) {
                    XSSFRow excelRow = excelSheet.getRow(i);
                    XSSFCell maNV = excelRow.getCell(0);
                    XSSFCell ten = excelRow.getCell(1);
                    XSSFCell gioiTinh = excelRow.getCell(2);
                    String gioiTinhStr = String.valueOf(gioiTinh).equals("1") ? "Nam" : "Nữ";
//                    System.out.println("Gioi tinh sau khi convert string : " + gioiTinhStr);

//                    String gioiTinhStr = gioiTinh.equals("1")?"Nam":"Nữ";
                    java.util.Date ngaySinh = excelRow.getCell(3).getDateCellValue();
                    DateFormat dateFormatNgaySinh = new SimpleDateFormat("yyyy-MM-dd");
                    String strNgaySinh = dateFormatNgaySinh.format(ngaySinh);
//                  
                    XSSFCell SDT = excelRow.getCell(4);
                    XSSFCell diaChi = excelRow.getCell(5);
                    XSSFCell chucVu = excelRow.getCell(6);
//                    String chucVuString = String.valueOf(chucVu);
////                    Integer chucVuInt = Integer.parseInt(chucVuString);
//                    
//                    System.out.println("Chuc vu excel: " + chucVu);
                    String chucVuStr = String.valueOf(chucVu).equals("1") ? "1" : "0";
                    XSSFCell Luong = excelRow.getCell(7);
                    String luongStr = String.valueOf(chucVu);
                    XSSFCell tenTK = excelRow.getCell(8);
                    XSSFCell mk = excelRow.getCell(9);
                    XSSFCell trangThai = excelRow.getCell(10);
                    String trangThaiStr = String.valueOf(trangThai).equals("1") ? "0" : "1";

                    System.out.println();
                    dtm.addRow(new Object[]{maNV, ten, gioiTinhStr, strNgaySinh, diaChi, SDT, chucVuStr, Luong, tenTK, mk, trangThaiStr});
                }
                JOptionPane.showMessageDialog(rootPane, "Import Excel thanh cong");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(ImportExcelNhanVienView.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(NhanVien1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVien1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVien1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVien1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVien1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbnv;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_nu;
    private javax.swing.JRadioButton rd_nv;
    private javax.swing.JRadioButton rd_ql;
    private javax.swing.JTable tblnv;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txt_Luong;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}
