package org.kh.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.common.JDBCTemplate;
import org.kh.member.model.vo.Member;

public class MemberDao
{
    public Member login(String id, String pw) {
        Connection conn = JDBCTemplate.getConnection();
        String query = "select * from member where member_id=? and member_pw=?";
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        Member m = null;
        
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,  id);
            pstmt.setString(2,  pw);
            
            rset = pstmt.executeQuery();
            if(rset.next()) {
                m = new Member();
                m.setAddr(rset.getString("addr"));
                m.setAge(rset.getInt("age"));
                m.setEmail(rset.getString("email"));
                m.setEnrollDate(rset.getDate("enroll_date"));
                m.setGender(rset.getString("gender"));
                m.setMemberId(rset.getString("member_id"));
                m.setMemberName(rset.getString("member_name"));
                m.setMemberPw(rset.getString("member_pw"));
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(conn);
        }
        
        return m;
    }
    
    
    public ArrayList<Member> selectAll(){
        
        Connection conn = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select * from member";
        
        ArrayList<Member> ml = new ArrayList<>();
        
        try
        {
            pstmt = conn.prepareStatement(query);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                
                String memberId = rset.getString("member_id");
                String memberPw = rset.getString("member_pw");
                String memberName = rset.getString("member_name");
                String email = rset.getString("email");
                int age = rset.getInt("age");
                String addr = rset.getString("addr");
                String gender = rset.getString("gender");
                Date enrollDate = rset.getDate("enroll_date");
                
                Member m = new Member(memberId, memberPw, memberName, email, age, addr, gender, enrollDate);
                
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
    
    public boolean enroll(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        int rset = 0;
        String query = "insert into member values(?,?,?,?,?,?,?,sysdate)";
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, m.getMemberId());
            pstmt.setString(2, m.getMemberPw());
            pstmt.setString(3, m.getMemberName());
            pstmt.setString(4, m.getEmail());
            pstmt.setInt(5, m.getAge());
            pstmt.setString(6, m.getAddr());
            pstmt.setString(7, m.getGender());
            
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
        String query = "delete from member where member_id=?";
        
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
    
    
    
    public boolean update(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        String query = "update member set member_pw=?, member_name=?, email=?, age=?, addr=?, gender=? where member_id=?";
        
        try
        {
            pstmt = conn.prepareStatement(query);
           
            pstmt.setString(1, m.getMemberPw());
            pstmt.setString(2, m.getMemberName());
            pstmt.setString(3, m.getEmail());
            pstmt.setInt(4, m.getAge());
            pstmt.setString(5, m.getAddr());
            pstmt.setString(6, m.getGender());
            pstmt.setString(7, m.getMemberId());
            
            result = pstmt.executeUpdate();
           
            
            if(result > 0) 
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
    
    
    
}
