package View;

import Constrant.UserInfor;
import Utilties.BarChartExample;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class TrangChu extends javax.swing.JFrame implements Runnable {

    GiaoDich gd = new GiaoDich();
    SanPhamCT sp = new SanPhamCT();
    NhanVien1 nv = new NhanVien1();
    ThongKe tk = new ThongKe();
    KhachHang1 kh = new KhachHang1();
    HoaDonView hd = new HoaDonView();
    KhuyenMai km = new KhuyenMai();

    BarChartExample bar = new BarChartExample();

    public TrangChu() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Thread t1 = new Thread(this);
        t1.start();

        String employee = String.valueOf(UserInfor.user.values());
        String replaceAll = employee.replaceAll("[\\[\\]\\{\\}()]", "");
        System.out.println(replaceAll);

        txtWelcome.setText(replaceAll);
    }

    private void setFrame(JComponent comp) {
        Form.removeAll();
        Form.add(comp);
        Form.setLayout(new BorderLayout());
        Form.repaint();
        Form.validate();
        Form.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        dongho = new javax.swing.JLabel();
        jbgd = new javax.swing.JLabel();
        jbsp = new javax.swing.JLabel();
        jbnv = new javax.swing.JLabel();
        jb = new javax.swing.JLabel();
        btnThoat = new javax.swing.JLabel();
        txtWelcome = new javax.swing.JLabel();
        jbsp1 = new javax.swing.JLabel();
        jbsp2 = new javax.swing.JLabel();
        jbtk = new javax.swing.JLabel();
        Form = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí của hàng bán giày thể thao nam");
        setUndecorated(true);

        Menu.setBackground(new java.awt.Color(187, 221, 243));

        dongho.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        dongho.setForeground(new java.awt.Color(204, 0, 0));
        dongho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dongho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Alarm.png"))); // NOI18N
        dongho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbgd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbgd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbgd.setText("GIAO DỊCH");
        jbgd.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbgd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbgdMouseClicked(evt);
            }
        });

        jbsp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbsp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbsp.setText("SẢN PHẨM");
        jbsp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbspMouseClicked(evt);
            }
        });

        jbnv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbnv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbnv.setText("NHÂN VIÊN");
        jbnv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbnvMouseClicked(evt);
            }
        });

        jb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jb.setText("KHÁCH HÀNG");
        jb.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbMouseClicked(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThoat.setText("THOÁT");
        btnThoat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });

        txtWelcome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtWelcome.setForeground(new java.awt.Color(255, 0, 51));
        txtWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtWelcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User.png"))); // NOI18N

        jbsp1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbsp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbsp1.setText("HÓA ÐƠN");
        jbsp1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbsp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbsp1MouseClicked(evt);
            }
        });

        jbsp2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbsp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbsp2.setText("KHUYẾN MÃI");
        jbsp2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbsp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbsp2MouseClicked(evt);
            }
        });

        jbtk.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbtk.setText("THỐNG KÊ");
        jbtk.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbtk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtWelcome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jbnv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbsp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbgd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dongho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbsp1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbsp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dongho, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jbgd, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbsp, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbsp1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbsp2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtk, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbnv, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout FormLayout = new javax.swing.GroupLayout(Form);
        Form.setLayout(FormLayout);
        FormLayout.setHorizontalGroup(
            FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        FormLayout.setVerticalGroup(
            FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbgdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbgdMouseClicked
        this.setFrame(gd.getRootPane());
        gd.timer.start();
    }//GEN-LAST:event_jbgdMouseClicked

    private void jbspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbspMouseClicked
        this.setFrame(sp.getRootPane());
        gd.timer.stop();
    }//GEN-LAST:event_jbspMouseClicked

    private void jbnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbnvMouseClicked
        this.setFrame(nv.getRootPane());
        gd.timer.stop();
    }//GEN-LAST:event_jbnvMouseClicked

    private void jbtkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtkMouseClicked
        this.setFrame(tk.getRootPane());
        gd.timer.stop();
    }//GEN-LAST:event_jbtkMouseClicked

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
        int cf = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn thoát ?");
        if (cf == JOptionPane.YES_OPTION) {
            UserInfor.user.clear();
            System.out.println(UserInfor.user);
            gd.timer.stop();
            dispose();
        } else {
            gd.timer.stop();
            return;
        }
    }//GEN-LAST:event_btnThoatMouseClicked

    private void jbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbMouseClicked
        this.setFrame(kh.getRootPane());
    }//GEN-LAST:event_jbMouseClicked

    private void jbsp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbsp1MouseClicked
        this.setFrame(hd.getRootPane());
        gd.timer.stop();
    }//GEN-LAST:event_jbsp1MouseClicked

    private void jbsp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbsp2MouseClicked
        this.setFrame(km.getRootPane());
        gd.timer.stop();
    }//GEN-LAST:event_jbsp2MouseClicked

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
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Form;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel btnThoat;
    private javax.swing.JLabel dongho;
    private javax.swing.JLabel jb;
    private javax.swing.JLabel jbgd;
    private javax.swing.JLabel jbnv;
    private javax.swing.JLabel jbsp;
    private javax.swing.JLabel jbsp1;
    private javax.swing.JLabel jbsp2;
    private javax.swing.JLabel jbtk;
    private javax.swing.JLabel txtWelcome;
    // End of variables declaration//GEN-END:variables

    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

    @Override
    public void run() {
        while (true) {
            Date now = new Date();
            String st = sdf.format(now);
            dongho.setText(st);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

        }
    }
}
