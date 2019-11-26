package org.kh.member.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.dao.MemberDao;
import org.kh.member.model.vo.Check;
import org.kh.member.model.vo.Member;
import org.kh.member.model.vo.Search;
import org.kh.member.model.vo.Search2;

import common.SqlSessionTemplate;

public class MemberService
{
    
    public Member loginMember(Member m)
    {
        SqlSession session = SqlSessionTemplate.getSqlSession();
        MemberDao dao = new MemberDao();
        Member member = dao.loginMember(session, m);
        session.close();
        return member;
    }
    
    public ArrayList<Member> selectAllMember()
    {
        SqlSession session = SqlSessionTemplate.getSqlSession();
        MemberDao dao = new MemberDao();
        ArrayList<Member> list = dao.selectAllMember(session);
        session.close();
        return list;
    }
    
    public int insertMember(Member m)
    {
        SqlSession session = SqlSessionTemplate.getSqlSession();
        MemberDao dao = new MemberDao();
        int result = dao.insertMember(session, m);
        
        if (result > 0)
        {
            session.commit();
        }
        else
        {
            session.rollback();
        }
        session.close();
        
        return result;
    }

    public int updateMember(Member m)
    {
        SqlSession session = SqlSessionTemplate.getSqlSession();
        MemberDao dao = new MemberDao();
        int result = dao.updateMember(session, m);
        
        if (result > 0)
        {
            session.commit();
        }
        else
        {
            session.rollback();
        }
        session.close();
        
        return result;
    }

    public int deleteMember(String memberId)
    {
        SqlSession session = SqlSessionTemplate.getSqlSession();
        MemberDao dao = new MemberDao();
        int result = dao.deleteMember(session, memberId);
        
        if(result > 0) {
            session.commit();
        }else {
            session.rollback();
        }
        
        session.close();
        
        return result;
    }

    public ArrayList<Member> checkMemberList(Check ck)
    {
        SqlSession session = SqlSessionTemplate.getSqlSession();
        MemberDao dao = new MemberDao();
        ArrayList<Member> list = dao.checkMemberList(session, ck);
        
        session.close();
        
        return list;
    }

    public ArrayList<Member> searchMember(Search search)
    {
        SqlSession session = SqlSessionTemplate.getSqlSession();
        MemberDao dao = new MemberDao();
        ArrayList<Member> list = dao.searchMember(session, search);
        
        
        return list;
    }

    public ArrayList<Member> searchMember2(Search2 search)
    {
        SqlSession session = SqlSessionTemplate.getSqlSession();
        MemberDao dao = new MemberDao();
        ArrayList<Member> list = dao.searchMember2(session, search);
        
        
        return list;
    }

    public ArrayList<Member> search3Member(String[] addr)
    {
        SqlSession session = SqlSessionTemplate.getSqlSession();
        MemberDao dao = new MemberDao();
        ArrayList<Member> list = dao.searchMember3(session, addr);
        
        
        return list;
    }
    
}
