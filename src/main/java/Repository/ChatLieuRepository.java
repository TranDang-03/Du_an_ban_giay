/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ChatLieu;
import Util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ChatLieuRepository {
    public ArrayList<ChatLieu> all() {
        ArrayList<ChatLieu> list = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM chat_lieu";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idChatLieu = rs.getInt("idChatLieu");
                String maChatLieu = rs.getString("maChatLieu");
                String daChinh = rs.getString("daChinh");
                String daPhu = rs.getString("daPhu");
                String daNgoai = rs.getString("daNgoai");
                String lopLotTrong = rs.getString("lopLotTrong");
                int trangThai = rs.getInt("trangThai");
               

                 ChatLieu cl = new ChatLieu(idChatLieu, maChatLieu, daChinh, daPhu, daNgoai, lopLotTrong, trangThai);
                list.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(ChatLieu cl) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = " INSERT INTO chat_lieu(maChatLieu, daChinh, daPhu, daNgoai, lopLotTrong, trangThai) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cl.getMaCL());
            ps.setString(2, cl.getDaChinh());
            ps.setString(3, cl.getDaPhu());
            ps.setString(4, cl.getDaNgoai());
            ps.setString(5, cl.getLopLot());
           
            ps.setInt(6, cl.getTrangThai());
           
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(ChatLieu cl) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "UPDATE chat_lieu SET maChatLieu= ?, daChinh= ?, daPhu= ?, daNgoai= ?, lopLotTrong= ?, trangThai = ? WHERE idChatLieu = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, cl.getMaCL());
            ps.setString(2, cl.getDaChinh());
            ps.setString(3, cl.getDaPhu());
            ps.setString(4, cl.getDaNgoai());
            ps.setString(5, cl.getLopLot());
           
            ps.setInt(6, cl.getTrangThai());
            ps.setInt(7, cl.getIdCL());
            ps.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

   
}
