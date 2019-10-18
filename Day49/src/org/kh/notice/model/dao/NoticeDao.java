package org.kh.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.common.JDBCTemplate;
import org.kh.notice.model.vo.Notice;

public class NoticeDao
{
    public ArrayList<Notice> selectList(Connection conn,int start, int end){
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from "
                        +"(select ROWNUM as rnum, n.* from "
                            +"(select * from notice order by notice_no desc) n) "
                    +"where rnum between ? and ?";
        ArrayList<Notice> list = new ArrayList<>();
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Notice notice = new Notice();
                notice.setRnum(rset.getInt("rnum"));
                notice.setNoticeNo(rset.getInt("notice_no"));
                notice.setNoticeTitle(rset.getString("notice_title"));
                notice.setNoticeContent(rset.getString("notice_content"));
                notice.setNoticeWriter(rset.getString("notice_writer"));
                notice.setNoticeDate(rset.getDate("notice_date"));
                notice.setReadcount(rset.getInt("readcount"));
                notice.setFilename(rset.getString("filename"));
                notice.setFilepath(rset.getString("filepath"));
                
                list.add(notice);
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
    
    public int totalCount(Connection conn) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        // 꺼내올때 편하게 꺼내오기 위해 as를 통해 컬럼명 부여
        String query = "select count(*) as total from notice";
        int result = 0;
        
        try
        {
            pstmt = conn.prepareStatement(query);
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
    
    
    public Notice selectOne(Connection conn, int noticeNo) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from notice where notice_no=?";

        Notice n = null;
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, noticeNo);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                n = new Notice();
                n.setNoticeNo(rset.getInt("notice_no"));
                n.setNoticeTitle(rset.getString("notice_title"));
                n.setNoticeContent(rset.getString("notice_content"));
                n.setNoticeWriter(rset.getString("notice_writer"));
                n.setNoticeDate(rset.getDate("notice_date"));
                n.setReadcount(rset.getInt("readcount"));
                n.setFilename(rset.getString("filename"));
                n.setFilepath(rset.getString("filepath"));
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
        
        return n;
    }
    
    
    
    public int readCount(Connection conn, int noticeNo) {
        PreparedStatement pstmt = null;
        int result = 0;
        String sql = "update notice set readcount = readcount+1 where notice_no=?";
      
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, noticeNo);
            
            result = pstmt.executeUpdate();
            
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }
    
    

    public int insertNotice(Connection conn, Notice n)
    {
        PreparedStatement pstmt = null;
        int result = 0;
        String sql = "insert into notice values (notice_no_seq.nextval,?,?,?,sysdate,0,?,?)";
        
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, n.getNoticeTitle());
            pstmt.setString(2, n.getNoticeContent());
            pstmt.setString(3, n.getNoticeWriter());
            pstmt.setString(4, n.getFilename());
            pstmt.setString(5, n.getFilepath());
            
            result = pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }
    
    
    
    
}
