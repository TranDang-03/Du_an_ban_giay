/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RepeatingCountdownTimerApp extends JFrame {
    private JLabel timerLabel;
    private int remainingSeconds = 5;
    private Timer timer;

    public RepeatingCountdownTimerApp() {
        setTitle("Repeating Countdown Timer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLayout(new FlowLayout());

        timerLabel = new JLabel("5");
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        add(timerLabel);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remainingSeconds--;

                if (remainingSeconds >= 0) {
                    timerLabel.setText(Integer.toString(remainingSeconds));
                } else {
                    timer.stop(); // Dừng Timer khi đếm ngược kết thúc
                    remainingSeconds = 5;
                    timerLabel.setText(Integer.toString(remainingSeconds));
                    JOptionPane.showMessageDialog(RepeatingCountdownTimerApp.this,
                            "Countdown has finished!", "Countdown Finished", JOptionPane.INFORMATION_MESSAGE);
                    timer.start(); // Bắt đầu lại Timer để lặp lại quá trình đếm ngược
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RepeatingCountdownTimerApp().setVisible(true);
            }
        });
    }
}





