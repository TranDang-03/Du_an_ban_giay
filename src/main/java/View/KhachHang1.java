/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import Repository.KhachHangRepository;
import Service.KhachHangService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.KhachHang;

/**
 *
 * @author admin
 */
public class KhachHang1 extends javax.swing.JDialog {

    /**
     * Creates new form KhachHang
     */
    private DefaultTableModel dtm = new DefaultTableModel();
    private List<Model.KhachHang> listkh = new ArrayList<>();
    private KhachHangService service = new KhachHangService();

    public KhachHang1() {
        initComponents();
        this.setLocationRelativeTo(null);

        tblKH.setModel(dtm);
        String headers[] = {"ID", "Mã", "Tên", "Giới Tính", "Ngày sinh", "Sdt", "Địa Chỉ", "Trạng Thái"};
        dtm.setColumnIdentifiers(headers);
        clear();
        loadtable();
    }

    public void loadtable() {
        listkh = this.service.getAll();
        dtm.setRowCount(0);

        for (Model.KhachHang kh : listkh) {
            dtm.addRow(new Object[]{
                kh.getIdKH(),
                kh.getMaKH(),
                kh.getTenKH(),
                kh.isGioiTinh() == true ? "Nam " : "Nữ",
                kh.getNgSinh(),
                kh.getSdt(),
                kh.getDiaChi(),
                kh.getTrangThai() == 0 ? "Hoạt động" : "Không hoạt động"
            });
        }
    }

    public void clear() {
        txtID.setText("");
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtDC.setText("");
        txtNS.setText("");
        txtSDt.setText("");
        radioNam.setSelected(false);
        radioNu.setSelected(false);
        radioHoatDong.setSelected(false);
        radioKhongHoatDong.setSelected(false);
    }

    public boolean checkData() {
        if (txtMaKH.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống!");
            return false;
        } else if (txtTenKH.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống!");
            return false;
        } else if (txtDC.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa Chỉ không được để trống!");
            return false;
        } else if (txtNS.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày Sinh không được để trống!");
            return false;

        } else if (txtSDt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sdt không được để trống!");
            return false;

        } else {
            return true;
        }
    }

//    
//
    public boolean checkMaKHAdd() {
        String ma = this.txtMaKH.getText();
        for (KhachHang khachHangService : listkh) {
            if (khachHangService.getMaKH().equalsIgnoreCase(ma)) {
                JOptionPane.showMessageDialog(this, "Mã khách hàng đã tồn tại");
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
        txtTenKH = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKH = new javax.swing.JTable();
        radioHoatDong = new javax.swing.JRadioButton();
        radioKhongHoatDong = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtDC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNS = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSDt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        radioNam = new javax.swing.JRadioButton();
        radioNu = new javax.swing.JRadioButton();
        btnLM = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        tblKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã", "Tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Dịa chỉ", "Trạng Thái"
            }
        ));
        tblKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKH);

        buttonGroup1.add(radioHoatDong);
        radioHoatDong.setSelected(true);
        radioHoatDong.setText("Hoạt động");

        buttonGroup1.add(radioKhongHoatDong);
        radioKhongHoatDong.setText("Không hoạt động");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID:");

        txtID.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã KH:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Trạng thái:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tên KH:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Địa Chỉ:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Ngày sinh");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Sdt");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Gioi Tinh");

        buttonGroup2.add(radioNam);
        radioNam.setSelected(true);
        radioNam.setText("Nam");
        radioNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNamActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioNu);
        radioNu.setText("Nu");

        btnLM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnLM.setText("Mới");
        btnLM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLMActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quản Lí Khách Hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(txtMaKH)
                            .addComponent(txtTenKH)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioHoatDong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioKhongHoatDong)))
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSDt))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(radioNam)
                                .addGap(32, 32, 32)
                                .addComponent(radioNu))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDC))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNS, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(106, 106, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnThem)
                        .addGap(171, 171, 171)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLM)
                        .addGap(167, 167, 167))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtSDt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(radioHoatDong)
                    .addComponent(radioKhongHoatDong)
                    .addComponent(jLabel9)
                    .addComponent(radioNam)
                    .addComponent(radioNu))
                .addGap(18, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLM)
                    .addComponent(btnSua)
                    .addComponent(btnThem))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:

//        String maKH = txtMaKH.getText();
//        String tenKH = txtTenKH.getText();
//        String diaChi = txtDC.getText();
//        String sdt = txtSDt.getText();
//        String ngaySinh = txtNS.getText();
//        Date dateNgaySinh;
//        try {
//            dateNgaySinh = new SimpleDateFormat("yyyy-mm-dd").parse(ngaySinh);
//        } catch (ParseException ex) {
//            JOptionPane.showMessageDialog(this, "Bạn cần nhập ngày bắt đầu theo định dạng Year/Month/Day");
//            return;
//        }
//
//        boolean gioiTinh;
//
//        if (radioNam.isSelected() == true) {
//            gioiTinh = true;
//        } else {
//            gioiTinh = false;
//        }
//        int trangThai;
//
//        if (radioHoatDong.isSelected() == true) {
//            trangThai = 0;
//        } else {
//            trangThai = 1;
//        }
//
//        Model.KhachHang kh = new Model.KhachHang(maKH, tenKH, gioiTinh, dateNgaySinh, sdt, diaChi, trangThai);
//
//        boolean add = this.service.add(kh);
//
//        if (add == true) {
//            JOptionPane.showMessageDialog(this, "Thêm thành công");
//        } else {
//            JOptionPane.showMessageDialog(this, "Thêm thất bại");
//        }
//
//        clear();
//        loadtable();
        int cf = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn thêm ?");
        if (cf == JOptionPane.YES_OPTION) {

            if (checkData()) {
                if (checkMaKHAdd()) {
                    String maKH = txtMaKH.getText();
                    String tenKH = txtTenKH.getText();
                    
                    String sdt = txtSDt.getText();
                    String diaChi = txtDC.getText();
                    String ngaySinh = txtNS.getText();
                    Date dateNgaySinh;
                    try {
                        dateNgaySinh = new SimpleDateFormat("yyyy-mm-dd").parse(ngaySinh);
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(this, "Bạn cần nhập ngày sinh theo định dạng Year/Month/Day");
                        return;
                    }

                    boolean gioiTinh;

                    if (radioNu.isSelected() == true) {
                        gioiTinh = true;
                    } else {
                        gioiTinh = false;
                    }
                    int trangThai;

                    if (radioHoatDong.isSelected() == true) {
                        trangThai = 0;
                    } else {
                        trangThai = 1;
                    }

                    Model.KhachHang kh = new Model.KhachHang(maKH, tenKH, gioiTinh, dateNgaySinh, sdt, diaChi, trangThai);

                    boolean add = this.service.add(kh);

                    if (add == true) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }

                    clear();
                    loadtable();
                }
                } else {
                    return;
                }
            }


    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        int id = Integer.valueOf(txtID.getText());
        String maKH = txtMaKH.getText();
        String tenKH = txtTenKH.getText();
        String sdt = txtSDt.getText();
        String diaChi = txtDC.getText();
        String ngaySinh = txtNS.getText();
        Date dateNgaySinh;
        try {
            dateNgaySinh = new SimpleDateFormat("yyyy-mm-dd").parse(ngaySinh);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Bạn cần nhập ngày sinh theo định dạng ");
            return;
        }
        boolean gioiTinh;

        if (radioNam.isSelected() == true) {
            gioiTinh = true;
        } else {
            gioiTinh = false;
        }
        int trangThai;
        if (radioHoatDong.isSelected() == true) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }

        Model.KhachHang kh = new Model.KhachHang(maKH, tenKH, gioiTinh, dateNgaySinh, sdt, diaChi, trangThai);
        boolean update = this.service.update(id, kh);

        if (update == true) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
        clear();
        loadtable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKHMouseClicked
        // TODO add your handling code here:
        int row = tblKH.getSelectedRow();

        int id = listkh.get(row).getIdKH();
        String maKH = listkh.get(row).getMaKH();
        String tenKH = listkh.get(row).getTenKH();
        boolean gioiTinh = listkh.get(row).isGioiTinh();
        Date ngaySinh = listkh.get(row).getNgSinh();
        String sdt = listkh.get(row).getSdt();
        String diaChi = listkh.get(row).getDiaChi();

        int trangThai = listkh.get(row).getTrangThai();

        txtID.setText(String.valueOf(id));
        txtMaKH.setText(maKH);
        txtTenKH.setText(tenKH);
        txtNS.setText(String.valueOf(ngaySinh));
        txtDC.setText(diaChi);
        txtSDt.setText(sdt);
        if (gioiTinh == true) {
            radioNam.setSelected(true);
            radioNu.setSelected(false);
        } else {
            radioNam.setSelected(false);
            radioNu.setSelected(true);
        }
        if (trangThai == 0) {
            radioHoatDong.setSelected(true);
            radioKhongHoatDong.setSelected(false);
        } else {
            radioHoatDong.setSelected(false);
            radioKhongHoatDong.setSelected(true);
        }
    }//GEN-LAST:event_tblKHMouseClicked

    private void radioNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNamActionPerformed

    private void btnLMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLMActionPerformed
        // TODO add your handling code here:
        this.clear();
    }//GEN-LAST:event_btnLMActionPerformed

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
            java.util.logging.Logger.getLogger(NSX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NSX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NSX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NSX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHang1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLM;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioHoatDong;
    private javax.swing.JRadioButton radioKhongHoatDong;
    private javax.swing.JRadioButton radioNam;
    private javax.swing.JRadioButton radioNu;
    private javax.swing.JTable tblKH;
    private javax.swing.JTextField txtDC;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNS;
    private javax.swing.JTextField txtSDt;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
