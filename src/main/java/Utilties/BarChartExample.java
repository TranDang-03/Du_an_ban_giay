/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilties;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;

public class BarChartExample extends JFrame{
    public static void main(String[] args) {
        // Tạo bộ dữ liệu cho biểu đồ
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(5000, "Doanh thu", "Product A");
        dataset.addValue(7000, "Doanh thu", "Product B");
        dataset.addValue(3000, "Doanh thu", "Product C");
        dataset.addValue(9000, "Doanh thu", "Product D");

        // Tạo biểu đồ cột
        JFreeChart chart = ChartFactory.createBarChart(
                "Tổng doanh thu các sản phẩm Java Swing", // Tiêu đề biểu đồ
                "Sản phẩm", // Tên trục x
                "Doanh thu (USD)", // Tên trục y
                dataset, // Bộ dữ liệu
                PlotOrientation.VERTICAL, // Hướng biểu đồ
                true, // Hiển thị giá trị trên các cột
                true, // Cho phép lưới
                false // Cho phép tooltip
        );

        // Tạo khung biểu đồ
        ChartFrame frame = new ChartFrame("Biểu đồ", chart);
        frame.pack();
        frame.setVisible(true);

        // Lưu biểu đồ thành file ảnh PNG
        try {
            ChartUtilities.saveChartAsPNG(new File("bar_chart.png"), chart, 500, 300);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
