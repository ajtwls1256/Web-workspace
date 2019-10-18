package org.kh.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.common.JDBCTemplate;
import org.kh.notice.model.vo.Notice;
import org.kh.notice.model.vo.NoticeComment;

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
    
    public int deleteNotice(Connection conn, int noticeNo) {
        PreparedStatement pstmt = null;
        int result = 0;
        String sql = "delete from notice where notice_no=?";
        
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
    
    public int updateNotice(Connection conn, Notice n) {
        PreparedStatement pstmt = null;
        int result = 0;
        String sql = "update notice set notice_title=?, notice_content=?, filename=?, filepath=? where notice_no=?";
        
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, n.getNoticeTitle());
            pstmt.setString(2, n.getNoticeContent());
            pstmt.setString(3, n.getFilename());
            pstmt.setString(4, n.getFilepath());
            pstmt.setInt(5, n.getNoticeNo());
            
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

    public int insertNoticeComment(Connection conn, NoticeComment nc)
    {
        PreparedStatement pstmt = null;
        int result = 0;
        String sql = "insert into notice_comment values(seq_notice_comment_no.nextval,?,?,?,?,?,sysdate)";
        
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, nc.getNoticeCommentLevel());
            pstmt.setString(2, nc.getNoticeCommentWriter());
            pstmt.setString(3, nc.getNoticeCommentContent());
            pstmt.setInt(4, nc.getNoticeRef());
            // 0인 경우(일반댓글) null을 넣고, 아닌경우(대댓글) 숫자를 문자로바꿔서 넣음 (어차피 DB 특성상 문자로들어와도 숫자로받아주고 null도 받아줌)
            // 0인경우와 아닌 경우를 둘다 한번에 처리하기 위함
            pstmt.setString(5, nc.getNoticeCommentRef()==0 ? null : String.valueOf(nc.getNoticeCommentRef()));
            
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

    public ArrayList<NoticeComment> selectNoticeCommentList(Connection conn,
            int noticeNo)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        ArrayList<NoticeComment> list = new ArrayList<>();
        String sql = "select * from notice_comment where notice_ref=?";
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, noticeNo);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                NoticeComment nc = new NoticeComment();
                nc.setNoticeCommentContent(rset.getString("notice_comment_content"));
                nc.setNoticeCommentDate(rset.getDate("notice_comment_date"));
                nc.setNoticeCommentLevel(rset.getInt("notice_comment_level"));
                nc.setNoticeCommentNo(rset.getInt("notice_comment_no"));
                nc.setNoticeCommentRef(rset.getInt("notice_comment_ref"));
                nc.setNoticeCommentWriter(rset.getString("notice_comment_writer"));
                nc.setNoticeRef(rset.getInt("notice_ref"));
                
                list.add(nc);
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
