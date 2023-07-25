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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBangsp2 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));

        tblBangsp2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ảnh", "Mã SP", "Tên SP", "Số lượng", "Kích cỡ", "Màu sắc", "Thương hiệu", "Dòng", "Kiểu dáng", "Chất liệu", "Giá nhập", "Giá bán", "NSX", "Trạng thái"
            }
        ));
        tblBangsp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangsp2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblBangsp2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addGap(102, 102, 102)
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
                        .addComponent(rdThap)
                        .addGap(18, 18, 18)
                        .addComponent(rdAll, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(rdCao)
                    .addComponent(rdThap)
                    .addComponent(rdAll)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void tblBangsp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangsp2MouseClicked
        
    }//GEN-LAST:event_tblBangsp2MouseClicked

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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdAll;
    private javax.swing.JRadioButton rdCao;
    private javax.swing.JRadioButton rdThap;
    private javax.swing.JTable tblBangsp2;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
