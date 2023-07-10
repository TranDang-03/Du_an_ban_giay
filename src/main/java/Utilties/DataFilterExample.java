/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilties;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Utilties.DataItem;

public class DataFilterExample extends JFrame {

    private JComboBox<String> nameComboBox;
    private JComboBox<Integer> ageComboBox;
    private JComboBox<String> genderComboBox;
    private JList<String> dataList;
    private DefaultListModel<String> listModel;

    public DataFilterExample() {
        setTitle("Data Filter Example");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Tạo một JPanel để chứa JComboBox, JList và JButton
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        // Tạo các JComboBox để chọn điều kiện lọc
        nameComboBox = new JComboBox<>();
        nameComboBox.addItem("All");
        nameComboBox.addItem("John");
        nameComboBox.addItem("Alice");
        nameComboBox.addItem("Bob");
        panel.add(nameComboBox, BorderLayout.NORTH);

        ageComboBox = new JComboBox<>();
        ageComboBox.addItem(-1); // -1 để lựa chọn tất cả tuổi
        ageComboBox.addItem(20);
        ageComboBox.addItem(30);
        ageComboBox.addItem(40);
        panel.add(ageComboBox, BorderLayout.CENTER);

        genderComboBox = new JComboBox<>();
        genderComboBox.addItem("All");
        genderComboBox.addItem("Male");
        genderComboBox.addItem("Female");
        panel.add(genderComboBox, BorderLayout.SOUTH);

        // Tạo JList để hiển thị dữ liệu
        listModel = new DefaultListModel<>();
        dataList = new JList<>(listModel);
        panel.add(new JScrollPane(dataList), BorderLayout.EAST);

        // Dữ liệu mẫu
        List<DataItem> data = new ArrayList<>();
        data.add(new DataItem("John", 25, "Male"));
        data.add(new DataItem("Alice", 30, "Female"));
        data.add(new DataItem("Bob", 28, "Male"));
        data.add(new DataItem("Emily", 35, "Female"));
        data.add(new DataItem("David", 22, "Male"));

        // Hiển thị dữ liệu ban đầu
        displayData(data);

        // Xử lý sự kiện khi chọn các combobox
        ActionListener filterListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lọc dữ liệu theo điều kiện
                List<DataItem> filteredData = filterData(data);

                // Hiển thị dữ liệu đã lọc
                displayData(filteredData);
            }
        };

        nameComboBox.addActionListener(filterListener);
        ageComboBox.addActionListener(filterListener);
        genderComboBox.addActionListener(filterListener);
    }

    private List<DataItem> filterData(List<DataItem> data) {
        Predicate<DataItem> predicate = new Predicate<DataItem>() {
            public boolean evaluate(DataItem item) {
                // Lấy giá trị được chọn từ combobox
                String selectedName = (String) nameComboBox.getSelectedItem();
                int selectedAge = (int) ageComboBox.getSelectedItem();
                String selectedGender = (String) genderComboBox.getSelectedItem();

                // Kiểm tra xem mục đích lọc dữ liệu
                boolean filterByName = !selectedName.equals("All");
                boolean filterByAge = selectedAge != -1;
                boolean filterByGender = !selectedGender.equals("All");

                // Điều kiện lọc dữ liệu
                boolean nameMatch = !filterByName || item.getName().equals(selectedName);
                boolean ageMatch = !filterByAge || item.getAge() == selectedAge;
                boolean genderMatch = !filterByGender || item.getGender().equals(selectedGender);

                // Trả về true nếu tất cả các điều kiện đúng
                return nameMatch && ageMatch && genderMatch;
            }
        };

        return (List<DataItem>) CollectionUtils.select(data, predicate);
    }

    private void displayData(List<DataItem> data) {
        listModel.clear();
        for (DataItem item : data) {
            listModel.addElement(item.getName() + ", " + item.getAge() + ", " + item.getGender());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DataFilterExample example = new DataFilterExample();
                example.setVisible(true);
            }
        });
    }
}

    /*`DataItem` đại diện cho một mục dữ liệu với các thuộc tính tên, tuổi và giới tính. Trong ví dụ này, chúng ta sử dụng ba `JComboBox` để chọn các điều kiện lọc dữ liệu: tên, tuổi và giới tính.

Khi bạn chọn các giá trị trên các `JComboBox`, sự kiện `actionPerformed` sẽ được kích hoạt và phương thức `filterData` được gọi để lọc dữ liệu dựa trên các giá trị đã chọn.

Phương thức `filterData` xác định các điều kiện lọc dữ liệu dựa trên các giá trị đã chọn từ các `JComboBox`. Sau đó, chúng ta sử dụng `CollectionUtils.select` để lọc dữ liệu từ danh sách gốc dựa trên điều kiện được xác định bởi `predicate`.

Cuối cùng, phương thức `displayData` được sử dụng để hiển thị dữ liệu đã lọc trong `JList`.

Khi bạn chọn các giá trị trên các `JComboBox`, dữ liệu sẽ được lọc dựa trên các điều kiện đã chọn và hiển thị lại trong `JList`.

Lưu ý rằng để chạy ví dụ này, bạn cần thêm thư viện Apache Commons Collections vào dự án của mình và cung cấp đường dẫn thư viện cho trình biên dịch.*/
