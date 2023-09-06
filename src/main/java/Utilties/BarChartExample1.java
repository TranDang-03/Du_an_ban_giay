package Utilties;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarChartExample1 extends JFrame {

    private DefaultCategoryDataset dataset;
    private JFreeChart barChart;
    private ChartPanel chartPanel;
    private JButton reloadButton;

    public BarChartExample1() {
        // Khởi tạo dataset và biểu đồ ban đầu
        dataset = new DefaultCategoryDataset();
        barChart = ChartFactory.createBarChart(
                "Biểu đồ cột đơn giản", // Tiêu đề biểu đồ
                "Thể loại", // Label trục x
                "Số lượng", // Label trục y
                dataset, // Dataset
                PlotOrientation.VERTICAL,
                true, true, false
        );

        chartPanel = new ChartPanel(barChart);
        reloadButton = new JButton("Reload Data");

        // Thêm nút "Reload Data" và biểu đồ vào JFrame
        setLayout(new BorderLayout());
        add(chartPanel, BorderLayout.CENTER);
        add(reloadButton, BorderLayout.SOUTH);

        reloadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Xóa tất cả dữ liệu hiện có trong dataset
                dataset.clear();

                // Thêm dữ liệu mới vào dataset
                dataset.addValue(20, "Dữ liệu 1", "Thể loại 1");
                dataset.addValue(25, "Dữ liệu 1", "Thể loại 2");
                dataset.addValue(12, "Dữ liệu 1", "Thể loại 3");

                // Yêu cầu biểu đồ vẽ lại trên EDT
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        chartPanel.repaint();
                    }
                });
            }
        });

        // Thêm dữ liệu mẫu ban đầu
        dataset.addValue(10, "Dữ liệu 1", "Thể loại 1");
        dataset.addValue(15, "Dữ liệu 1", "Thể loại 2");
        dataset.addValue(7, "Dữ liệu 1", "Thể loại 3");

        // Cài đặt các thuộc tính cho JFrame
        setTitle("Bar Chart Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BarChartExample1();
        });
    }
}
