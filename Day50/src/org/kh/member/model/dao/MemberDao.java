package org.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        }finally {
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
        }finally {
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
        }finally {
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
        }finally {
            JDBCTemplate.close(pstmt);
        }
        
        return result;
    }
    
    
    
    public int insertMember(Connection conn, Member m) {
        PreparedStatement pstmt = null;
        int result = 0;
        String sql = "insert into member values(?,?,?,?,?,?,sysdate)";
       
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getMemberId());
            pstmt.setString(2, m.getMemberPw());
            pstmt.setString(3, m.getMemberName());
            pstmt.setInt(4, m.getAge());
            pstmt.setString(5, m.getEmail());
            pstmt.setString(6, m.getPhone());
            
            result = pstmt.executeUpdate();
            
            
            return result;    
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
    
    
    
    
    
    public ArrayList<Member> selectList(Connection conn) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        ArrayList<Member> list = new ArrayList<>();
        String sql = "select * from member";
       
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Member m = new Member();
                m.setMemberId(rset.getString("member_id"));
                m.setMemberPw(rset.getString("member_pw"));
                m.setMemberName(rset.getString("member_name"));                
                m.setAge(rset.getInt("age"));
                m.setEmail(rset.getString("email"));
                m.setPhone(rset.getString("phone"));
                m.setEnrollDate(rset.getDate("enroll_date"));
                
                list.add(m);
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
    
    
    
    
    public ArrayList<Member> searchKeywordId(Connection conn, String keyword){
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from member where member_id=?";
        ArrayList<Member> list = new ArrayList<>();
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, keyword);
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Member m = new Member();
                m.setMemberId(rset.getString("member_id"));
                m.setMemberPw(rset.getString("member_pw"));
                m.setMemberName(rset.getString("member_name"));                
                m.setAge(rset.getInt("age"));
                m.setEmail(rset.getString("email"));
                m.setPhone(rset.getString("phone"));
                m.setEnrollDate(rset.getDate("enroll_date"));
                
                list.add(m);
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
    
    
    public ArrayList<Member> searchKeywordName(Connection conn, String keyword){
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from member where member_name like (?)";
        ArrayList<Member> list = new ArrayList<>();
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Member m = new Member();
                m.setMemberId(rset.getString("member_id"));
                m.setMemberPw(rset.getString("member_pw"));
                m.setMemberName(rset.getString("member_name"));                
                m.setAge(rset.getInt("age"));
                m.setEmail(rset.getString("email"));
                m.setPhone(rset.getString("phone"));
                m.setEnrollDate(rset.getDate("enroll_date"));
                
                list.add(m);
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
    
    
    
    public String findId(Connection conn, Member m) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select member_id from member where member_name=? and email=? and phone=?";
        String memberId = "";
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getMemberName());
            pstmt.setString(2, m.getEmail());
            pstmt.setString(3, m.getPhone());
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                memberId = rset.getString("member_id");
            }
            
            return memberId;
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        return memberId;
    }
    
    
    public String findPw(Connection conn, Member m) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select member_pw from member where member_id=? and member_name=? and email=?";
        String memberPw = "";
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getMemberId());
            pstmt.setString(2, m.getMemberName());
            pstmt.setString(3, m.getEmail());
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                memberPw = rset.getString("member_pw");
            }
            
            return memberPw;
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        return memberPw;
    }
    
    
    
}
