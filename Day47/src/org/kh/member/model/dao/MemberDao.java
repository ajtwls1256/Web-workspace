package org.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.kh.common.JDBCTemplate;
import org.kh.member.model.vo.Member;

public class MemberDao
{
    public Member login(Connection conn, String memberId, String memberPw) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Member m = null;
        String sql = "select * from member where member_id=? and member_pw=?";
       
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            pstmt.setString(2, memberPw);
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                m = new Member();
                m.setMemberId(rset.getString("member_id"));
                m.setMemberPw(rset.getString("member_pw"));
                m.setMemberName(rset.getString("member_name"));                
                m.setAge(rset.getInt("age"));
                m.setEmail(rset.getString("email"));
                m.setPhone(rset.getString("phone"));
                m.setEnrollDate(rset.getDate("enroll_date"));
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        
        return m;
    }
    
    
    public Member selectOne(Connection conn, String memberId) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Member m = null;
        String sql = "select * from member where member_id=?";
       
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                m = new Member();
                m.setMemberId(rset.getString("member_id"));
                m.setMemberPw(rset.getString("member_pw"));
                m.setMemberName(rset.getString("member_name"));                
                m.setAge(rset.getInt("age"));
                m.setEmail(rset.getString("email"));
                m.setPhone(rset.getString("phone"));
                m.setEnrollDate(rset.getDate("enroll_date"));
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        
        return m;
    }
    
    
    public int update(Connection conn, Member m) {
        PreparedStatement pstmt = null;
        int result = 0;
        String sql = "update member set member_pw=?, member_name=?, age=?, email=?, phone=? where member_id=?";
       
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getMemberPw());
            pstmt.setString(2, m.getMemberName());
            pstmt.setInt(3, m.getAge());
            pstmt.setString(4, m.getEmail());
            pstmt.setString(5, m.getPhone());
            pstmt.setString(6, m.getMemberId());
            
            result = pstmt.executeUpdate();
            
            
            return result;    
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }
    
    
    public int delete(Connection conn, String memberId) {
        PreparedStatement pstmt = null;
        int result = 0;
        String sql = "delete from member where member_id=?";
       
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            
            result = pstmt.executeUpdate();
            
            
            return result;    
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }
}
