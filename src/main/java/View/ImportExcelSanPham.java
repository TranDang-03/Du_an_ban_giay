/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Service.SanPhamCTService;
import Util.DBConnect;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

/**
 *
 * @author Admin
 */
public class ImportExcelSanPham extends javax.swing.JFrame {

    private SanPhamCTService service = new SanPhamCTService();
    
    public ImportExcelSanPham() {
        initComponents();
        this.setLocationRelativeTo(null);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBangExcel = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblBangExcel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ảnh", "Mã SP", "Tên SP", "Số lượng", "Kích cỡ", "Màu sắc", "Thương hiệu", "Dòng", "Kiểu dáng", "Chất liệu", "Giá nhập", "Giá bán", "NSX"
            }
        ));
        tblBangExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangExcelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBangExcel);

        jButton1.setText("Import Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jButton1)
                .addGap(129, 129, 129)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tblBangExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangExcelMouseClicked

    }//GEN-LAST:event_tblBangExcelMouseClicked
    DefaultTableModel dtm;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        dtm = (DefaultTableModel) tblBangExcel.getModel();
        dtm.setRowCount(0);
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportWorkBook = null;
        String currentDirectoryPath = "D:\\";
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
                    XSSFCell anh = excelRow.getCell(0);
                    XSSFCell ma = excelRow.getCell(1);
                    XSSFCell ten = excelRow.getCell(2);
                    XSSFCell sol = excelRow.getCell(3);
                    XSSFCell kc = excelRow.getCell(4);
                    XSSFCell ms = excelRow.getCell(5);
                    XSSFCell th = excelRow.getCell(6);
                    XSSFCell dong = excelRow.getCell(7);
                    XSSFCell kd = excelRow.getCell(8);
                    XSSFCell cl = excelRow.getCell(9);
                    XSSFCell giaban = excelRow.getCell(10);
                    XSSFCell gianhap = excelRow.getCell(11);
                    XSSFCell nsx = excelRow.getCell(12);                 
                    System.out.println();
                    dtm.addRow(new Object[]{anh,ma,ten,sol,kc,ms,th,dong,kd,cl,giaban,gianhap,nsx});
                }
                JOptionPane.showMessageDialog(rootPane, "Import Excel Thành công");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(ImportExcelSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int insertedRows = 0;
        int row = tblBangExcel.getRowCount();
        String query = """
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
                                  ,[idNSX])
                            VALUES
                                  (?,?,?,?,?,?,?,?,?,?,?,?,?)
                       """;

        for (int i = 0; i < row; i++) {
            String anh = dtm.getValueAt(i, 0).toString();
            String ma = dtm.getValueAt(i, 1).toString();
            String ten = dtm.getValueAt(i, 2).toString();
            String sl = dtm.getValueAt(i, 3).toString();
            String kc = dtm.getValueAt(i, 4).toString();
            String ms = dtm.getValueAt(i, 4).toString();
            String th = dtm.getValueAt(i, 6).toString();
            String dong = dtm.getValueAt(i, 7).toString();
            String kd = dtm.getValueAt(i, 8).toString();
            String cl = dtm.getValueAt(i, 9).toString();
            String gianhap = dtm.getValueAt(i, 10).toString();
            String giaban = dtm.getValueAt(i, 11).toString();
            String nsx = dtm.getValueAt(i, 12).toString();
            try {
                PreparedStatement ps = null;
                Connection con = DBConnect.getConnection();
                ps = con.prepareStatement(query);
                ps.setObject(1, anh);
                ps.setObject(2, ma);
                ps.setObject(3, ten);
                ps.setObject(4, sl);
                ps.setObject(5, kc);
                ps.setObject(6, ms);
                ps.setObject(7, th);
                ps.setObject(8, dong);
                ps.setObject(9, kd);
                ps.setObject(10,cl);
                ps.setObject(11,gianhap);
                ps.setObject(12,giaban);
                ps.setObject(13,nsx);
                int result = ps.executeUpdate();
                if (result > 0) {
                    insertedRows++;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null, " Dữ liệu đã được thêm");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ImportExcelSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportExcelSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportExcelSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportExcelSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportExcelSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBangExcel;
    // End of variables declaration//GEN-END:variables
}
