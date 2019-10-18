package kh.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.common.JDBCTemplate;
import kh.member.model.vo.Member;

public class MemberDao
{
    
    public Member login(String id, String pw) {
        Connection conn = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from member2 where member_id=? and member_pw=?";
        
        Member m = null;
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                m = new Member();
                m.setMemberId(rset.getString("member_id"));
                m.setMemberPw(rset.getString("member_pw"));
                m.setMemberName(rset.getString("member_name"));
                m.setMemberPhone(rset.getString("member_phone"));
                m.setMemberLevel(rset.getInt("member_level"));
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(conn);
        }
        
        return m;
    }
    
    
    public boolean signUp(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        int rset = 0;
        String query = "insert into member2 values(?,?,?,?,?)";
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, m.getMemberId());
            pstmt.setString(2, m.getMemberPw());
            pstmt.setString(3, m.getMemberName());
            pstmt.setString(4, m.getMemberPhone());
            pstmt.setInt(5, m.getMemberLevel());
         
            
            rset = pstmt.executeUpdate();
           
            
            if(rset > 0) 
            {
                JDBCTemplate.commit(conn);
                return true;
            }
            else 
            {
                JDBCTemplate.rollback(conn);
                return false;
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(conn);
        }
        
        
        return false;
    }
    
    

    public boolean delete(String id) {
        Connection conn = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        int rset = 0;
        String query = "delete from member2 where member_id=?";
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
     
            
            rset = pstmt.executeUpdate();
           
            
            if(rset > 0) 
            {
                JDBCTemplate.commit(conn);
                return true;
            }
            else 
            {
                JDBCTemplate.rollback(conn);
                return false;
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(conn);
        }
        
        
        return false;
        
    }
    
    
    
    public String findPw(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select member_pw from member2 where member_id=? and member_name=? and member_phone=?";
        
        String searchPw = "";
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getMemberId());
            pstmt.setString(2, m.getMemberName());
            pstmt.setString(3, m.getMemberPhone());
            
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {

                searchPw = rset.getString("member_pw");

            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(conn);
        }
        
        return searchPw;
    }
    
    
    
    public boolean update(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        String query = "update member2 set member_pw=?, member_name=?, member_phone=?, member_level=? where member_id=?";
        
        try
        {
            pstmt = conn.prepareStatement(query);
           
            pstmt.setString(1, m.getMemberPw());
            pstmt.setString(2, m.getMemberName());
            pstmt.setString(3, m.getMemberPhone());
            pstmt.setInt(4, m.getMemberLevel());
            pstmt.setString(5, m.getMemberId());
            
            result = pstmt.executeUpdate();
           
            
            if(result > 0) 
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(conn);
        }
        
     
        return false;
    }
    
    
    
    
    
    public ArrayList<Member> selectAll(){
        
        Connection conn = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select * from member2";
        
        ArrayList<Member> ml = new ArrayList<>();
        
        try
        {
            pstmt = conn.prepareStatement(query);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                
                String memberId = rset.getString("member_id");
                String memberPw = rset.getString("member_pw");
                String memberName = rset.getString("member_name");
                String memberPhone = rset.getString("member_phone");
                int memberLevel = rset.getInt("member_level");

                
                Member m = new Member(memberId, memberPw, memberName, memberPhone, memberLevel);
                
                ml.add(m); 
            }
            
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(conn);
        }
        
        return ml;
        
    }
    
    
    public boolean change(String id, int level) {
        Connection conn = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        String query = "update member2 set member_level=? where member_id=?";
        
        try
        {
            pstmt = conn.prepareStatement(query);
           
            pstmt.setInt(1, level);
            pstmt.setString(2, id);

            
            result = pstmt.executeUpdate();
           
            
            if(result > 0) 
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(conn);
        }
        
     
        return false;
    }
    
}
