package kr.co.tomato.chat.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.chat.model.dao.ChatDao;
import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Chat;

public class ChatService
{


    public ArrayList<Chat> getChatList(String nowTime)
    {
        Connection conn = JDBCTemplate.getConnection();
        ChatDao dao = new ChatDao();
        
        ArrayList<Chat> list = dao.getChatList(conn, nowTime);
        
        JDBCTemplate.close(conn);

        return list;
    }
    
    
    public int submit(String chatName, String chatContent)
    {
        Connection conn = JDBCTemplate.getConnection();
        ChatDao dao = new ChatDao();
        
        int result = dao.submit(conn, chatName, chatContent);
        
        if(result > 0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
               
        JDBCTemplate.close(conn);

        return result;
    }
    
}
