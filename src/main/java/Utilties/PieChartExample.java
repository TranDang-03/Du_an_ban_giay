/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilties;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PieChartExample extends JFrame {

    private Map<String, Double> data;

    public PieChartExample() {
        setTitle("Pie Chart Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        // Tạo dữ liệu cho biểu đồ
        data = new HashMap<>();
        data.put("Category 1", 2500.0);
        data.put("Category 2", 1500.0);
        data.put("Category 3", 1000.0);
        data.put("Category 4", 2000.0);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        double total = 0;
        for (double value : data.values()) {
            total += value;
        }

        int startAngle = 0;
        for (Map.Entry<String, Double> entry : data.entrySet()) {
            String category = entry.getKey();
            double value = entry.getValue();

            int arcAngle = (int) Math.round(value / total * 360);

            g.setColor(getRandomColor());
            g.fillArc(100, 100, 300, 300, startAngle, arcAngle);

            startAngle += arcAngle;
        }
    }

    private Color getRandomColor() {
        return new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PieChartExample();
            }
        });
    }
}
