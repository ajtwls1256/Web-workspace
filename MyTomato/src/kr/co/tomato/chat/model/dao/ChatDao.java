package kr.co.tomato.chat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Chat;

public class ChatDao
{
    
    public ArrayList<Chat> getChatList(Connection conn, String nowTime){
        ArrayList<Chat> chatList = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from chat where= chatTime > ? order by chatTime";
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nowTime);
            rset = pstmt.executeQuery();
            
            chatList = new ArrayList<>();
            while(rset.next()) {
                Chat chat = new Chat();
                chat.setChatName(rset.getString("chatName"));
                chat.setChatContent(rset.getString("chatContent"));
                chat.setChatTime(rset.getDate("chatName"));
                
                chatList.add(chat);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        
        return chatList;
    }
    
    
    
    public int submit(Connection conn, String chatName, String chatContent) {
        PreparedStatement pstmt = null;
        int result = -1;
        String sql = "insert into chat values(?,?,sysdate)";
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, chatName);
            pstmt.setString(2, chatContent);
            
            result = pstmt.executeUpdate();
            
  
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }
}
