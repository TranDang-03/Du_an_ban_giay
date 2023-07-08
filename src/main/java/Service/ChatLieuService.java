/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ChatLieu;
import Repository.ChatLieuRepository;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class ChatLieuService {
    private ChatLieuRepository ChatLieuRepo;

    public ChatLieuService() {
        this. ChatLieuRepo = new ChatLieuRepository();
    }
    
    public ArrayList<ChatLieu> all() {
        return this. ChatLieuRepo.all();
    }
    
    public boolean insert(ChatLieu cl){
        return this. ChatLieuRepo.insert(cl);
    }
    public boolean update(ChatLieu cl){
        return this. ChatLieuRepo.update(cl);
    }
}
