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

    private final int MIN_COUNT = 0; // Giá trị tối đa của đồng hồ đếm
    private Timer timer;

    public UpdateJFrameWithTimer() {
        data = 5;

        dataLabel = new JLabel("Data: " + data);

        // Add the JLabel to the frame
        setLayout(new FlowLayout());
        add(dataLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Tạo đồng hồ đếm ngược từ 0 đến MAX_COUNT, sau đó lặp lại
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataLabel.setText("Data: " + data);

                if (data == MIN_COUNT) {
                    data = 5; // Đặt lại giá trị về 0 khi đạt đến MAX_COUNT
                } else {
                    data--; // Tăng giá trị lên 1 nếu chưa đạt MAX_COUNT
                }
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
