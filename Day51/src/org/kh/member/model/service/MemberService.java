package org.kh.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import org.kh.common.JDBCTemplate;
import org.kh.member.model.dao.MemberDao;
import org.kh.member.model.vo.Member;

public class MemberService
{
    public Member login(String memberId, String memberPw) {
        Connection conn = JDBCTemplate.getConnection();
        MemberDao dao = new MemberDao();
        Member m = dao.login(conn, memberId, memberPw);
        
        JDBCTemplate.close(conn);
        return m;
    }
    
    public Member selectOne(String memberId) {
        Connection conn = JDBCTemplate.getConnection();
        MemberDao dao = new MemberDao();
        Member m = dao.selectOne(conn, memberId);
        
        JDBCTemplate.close(conn);
        return m;
    }
    
    public int update(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        MemberDao dao = new MemberDao();
        int result = dao.update(conn, m);
        
        if(result > 0) {
            JDBCTemplate.commit(conn);
        }
        else {
            JDBCTemplate.rollback(conn);
        }
        
        JDBCTemplate.close(conn);
        return result;
    }
    
    public int delete(String memberId) {
        Connection conn = JDBCTemplate.getConnection();
        MemberDao dao = new MemberDao();
        int result = dao.delete(conn, memberId);
        
        if(result > 0) {
            JDBCTemplate.commit(conn);
        }
        else {
            JDBCTemplate.rollback(conn);
        }
        
        JDBCTemplate.close(conn);
        return result;
    }
    
    public int insertMember(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        MemberDao dao = new MemberDao();
        int result = dao.insertMember(conn, m);
        
        if(result > 0) {
            JDBCTemplate.commit(conn);
        }
        else {
            JDBCTemplate.rollback(conn);
        }
        
        JDBCTemplate.close(conn);
        return result;
    }
    
    public ArrayList<Member> selectList() {
        Connection conn = JDBCTemplate.getConnection();
        MemberDao dao = new MemberDao();
        ArrayList<Member> m = dao.selectList(conn);
        
        JDBCTemplate.close(conn);
        return m;
    }
    
    
    public ArrayList<Member> searchKeyword(String type, String keyword) {
        Connection conn = JDBCTemplate.getConnection();
        MemberDao dao = new MemberDao();
        ArrayList<Member> list = null;
        
        switch(type) {
            case "memberId" : list = dao.searchKeywordId(conn,keyword);
                break;
            case "memberName" : list = dao.searchKeywordName(conn,keyword);
                break;
        }

        
        JDBCTemplate.close(conn);
        return list;
    }
    
    
    public String findId(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        MemberDao dao = new MemberDao();
        String memberId = dao.findId(conn, m);
        
        JDBCTemplate.close(conn);
        return memberId;
    }
    
    public String findPw(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        MemberDao dao = new MemberDao();
        String memberPw = dao.findPw(conn, m);
        
        JDBCTemplate.close(conn);
        return memberPw;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
