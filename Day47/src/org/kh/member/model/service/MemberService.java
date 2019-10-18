package org.kh.member.model.service;

import java.sql.Connection;

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
}
