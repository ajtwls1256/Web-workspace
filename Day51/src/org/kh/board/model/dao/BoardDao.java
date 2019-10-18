package org.kh.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.board.model.vo.Board;
import org.kh.common.JDBCTemplate;

public class BoardDao
{

    public int totalCount(Connection conn)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select count(*) as total from board";
        int result = 0;
        
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                result = rset.getInt("total");
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }

        
        return result;
    }

    public ArrayList<Board> selectList(Connection conn, int start, int end)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from(select rownum as rnum,n.* from (select * from BOARD order by board_no desc) n) where rnum between ? and ?";
        ArrayList<Board> list = new ArrayList<>();
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Board b = new Board();
                b.setRnum(rset.getInt("rnum"));
                b.setBoardNo(rset.getInt("board_no"));
                b.setBoardTitle(rset.getString("board_title"));
                b.setBoardContent(rset.getString("board_content"));
                b.setBoardWriter(rset.getString("board_writer"));
                b.setBoardDate(rset.getDate("board_date"));
                b.setReadcount(rset.getInt("readcount"));
                b.setFilename(rset.getString("filename"));
                b.setFilepath(rset.getString("filepath"));
                
                list.add(b);
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        
        
        
        return list;
    }
    
}
