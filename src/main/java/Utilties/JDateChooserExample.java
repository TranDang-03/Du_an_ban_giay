/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilties;

/**
 *
 * @author PC
 */
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class JDateChooserExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel(new FlowLayout());

        JDateChooser dateChooser = new JDateChooser();
        panel.add(dateChooser);

        JButton button = new JButton("Get Date");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Date selectedDate = dateChooser.getDate();
                if (selectedDate != null) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate = dateFormat.format(selectedDate);

                    // Chuyển đổi định dạng ngày thành java.sql.Date
                    try {
                        java.util.Date parsedDate = dateFormat.parse(formattedDate);
                        java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
                        System.out.println("SQL Date: " + sqlDate);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No date selected");
                }
            }
        });
        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);
    }
}

