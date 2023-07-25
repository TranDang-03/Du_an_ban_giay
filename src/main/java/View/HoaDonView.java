package View;

import Service.ThongTinHDService;
import ViewModels.SPCTViewModel;
import ViewModels.ThongTinHD;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HoaDonView extends javax.swing.JFrame {

    private ThongTinHDService service = new ThongTinHDService();
    private DefaultTableModel model;
    private List<ThongTinHD> list = new LinkedList<>();

    public HoaDonView() {
        initComponents();
        this.loadTable();
    }

    public void loadTable() {
        model = (DefaultTableModel) this.tblHoaDon.getModel();
        model.setRowCount(0);
        list = this.service.HdAll();
        for (ThongTinHD hd : list) {
            model.addRow(new Object[]{
                hd.getMaHD(),
                hd.getTenNV(),
                hd.getNgayTao(),
                hd.getTenKhachHang(),
                hd.getThanhTien(),
                hd.getKhuyenMai(),
                hd.getTrangThai() == 0 ? "Đã thanh toán" : (hd.getTrangThai() == 1) ? "Chưa thanh toán" : "Đã hủy"
            });
        }
        this.initSearch();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdCao = new javax.swing.JRadioButton();
        rdThap = new javax.swing.JRadioButton();
        rdAll = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hoá Đơn");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Nhân viên", "Ngày tạo", "Khách hàng", "Thành tiền", "Khuyến mãi", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tìm kiếm:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Sắp xếp theo tổng tiền:");

        buttonGroup1.add(rdCao);
        rdCao.setText("Cao nhất");
        rdCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCaoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdThap);
        rdThap.setText("Thấp nhất");
        rdThap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdThapActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdAll);
        rdAll.setText("Tất cả");
        rdAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAllActionPerformed(evt);
            }
        });

        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(rdCao, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdThap)
                                .addGap(18, 18, 18)
                                .addComponent(rdAll, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 209, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(rdCao)
                    .addComponent(rdThap)
                    .addComponent(rdAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
                DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
                model.setRowCount(0);
                String code = txt_search.getText();
                List<ThongTinHD> tempList = new ArrayList<>();
                for (ThongTinHD item : list) {
                    if (item.getTenNV().contains(code)) {
                        tempList.add(item);
                    }
                }
                for (ThongTinHD hd : tempList) {
                    model.addRow(new Object[]{
                        hd.getMaHD(),
                        hd.getTenNV(),
                        hd.getNgayTao(),
                        hd.getTenKhachHang(),
                        hd.getThanhTien(),
                        hd.getKhuyenMai(),
                        hd.getTrangThai() == 0 ? "Đã thanh toán" : (hd.getTrangThai() == 1) ? "Chưa thanh toán" : "Đã hủy"});
                }
            }
        });
    }

    private void rdCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCaoActionPerformed
        model = (DefaultTableModel) this.tblHoaDon.getModel();
        model.setRowCount(0);
        list = this.service.getHDByTongTienCao();
        for (ThongTinHD hd : list) {
            model.addRow(new Object[]{
                hd.getMaHD(),
                hd.getTenNV(),
                hd.getNgayTao(),
                hd.getTenKhachHang(),
                hd.getThanhTien(),
                hd.getKhuyenMai(),
                hd.getTrangThai() == 0 ? "Đã thanh toán" : (hd.getTrangThai() == 1) ? "Chưa thanh toán" : "Đã hủy"
            });
        }
        this.initSearch();
    }//GEN-LAST:event_rdCaoActionPerformed

    private void rdThapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdThapActionPerformed
        model = (DefaultTableModel) this.tblHoaDon.getModel();
        model.setRowCount(0);
        list = this.service.getHDByTongTienThap();
        for (ThongTinHD hd : list) {
            model.addRow(new Object[]{
                hd.getMaHD(),
                hd.getTenNV(),
                hd.getNgayTao(),
                hd.getTenKhachHang(),
                hd.getThanhTien(),
                hd.getKhuyenMai(),
                hd.getTrangThai() == 0 ? "Đã thanh toán" : (hd.getTrangThai() == 1) ? "Chưa thanh toán" : "Đã hủy"
            });
        }
        this.initSearch();
    }//GEN-LAST:event_rdThapActionPerformed

    private void rdAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAllActionPerformed
        this.loadTable();
    }//GEN-LAST:event_rdAllActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdAll;
    private javax.swing.JRadioButton rdCao;
    private javax.swing.JRadioButton rdThap;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
