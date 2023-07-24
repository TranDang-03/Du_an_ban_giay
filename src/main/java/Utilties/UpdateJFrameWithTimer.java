/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateJFrameWithTimer extends JFrame {

    private JLabel dataLabel;
    private int data;

    public UpdateJFrameWithTimer() {
        data = 0;

        dataLabel = new JLabel("Data: " + data);
        JButton updateButton = new JButton("Update Data");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tăng giá trị của biến data và cập nhật dữ liệu trên JLabel
                data++;
                dataLabel.setText("Data: " + data);
            }
        });

        // Add components to the frame
        setLayout(new FlowLayout());
        add(dataLabel);
        add(updateButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Tạo đồng hồ đếm ngược cứ 5 giây
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thực hiện cập nhật dữ liệu và vẽ lại JFrame
                data++;
                dataLabel.setText("Data: " + data);
                revalidate();
                repaint();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UpdateJFrameWithTimer();
            }
        });
    }
}
