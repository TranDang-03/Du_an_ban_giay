/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import com.toedter.calendar.JCalendar;

public class datepicker {

    public static void main(String[] args) {
        JFrame frame = new JFrame("DatePicker Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo JTextField để hiển thị ngày được chọn
        JFormattedTextField dateField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        dateField.setColumns(10);

        // Tạo JButton để mở DatePicker
        JButton datePickerButton = new JButton("...");
        datePickerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPopupMenu popup = new JPopupMenu();
                JCalendar calendar = new JCalendar() {
                    @Override
                    public void setCalendar(Calendar calendar) {
                        super.setCalendar(calendar);
                        
                        // Đặt giá trị ngày vào JTextField khi người dùng chọn ngày
                        dateField.setValue(calendar.getTime());
                        
                        // Đóng popup sau khi người dùng chọn ngày
                        popup.setVisible(false);
                    }
                };
                
                popup.add(calendar);
                calendar.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName().equals("calendar")) {
                            Calendar selectedDate = (Calendar) evt.getNewValue();
                            Date date = selectedDate.getTime();
                            
                            // Lấy dữ liệu ngày từ DatePicker
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            String dateString = dateFormat.format(date);
                            System.out.println("Ngày được chọn: " + dateString);
                        }
                    }
                });
                
                // Hiển thị popup bên cạnh JButton
                popup.show(datePickerButton, 0, datePickerButton.getHeight());
            }
        });

        JPanel panel = new JPanel();
        panel.add(dateField);
        panel.add(datePickerButton);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}

