package org.kh.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.Check;
import org.kh.member.model.vo.Member;
import org.kh.member.model.vo.Search;
import org.kh.member.model.vo.Search2;

public class MemberDao {

	public Member loginMember(SqlSession session, Member m) {
		Member member = session.selectOne("mybatis.loginMember",m);
		return member;
	}

	public ArrayList<Member> selectAllMember(SqlSession session) {
	    
	    //selectList는 리스트 타입으로밖에 안돼서 여기서 리스트로 만들고 ArrayList에서 형변환
	    List<Member> list = session.selectList("mybatis.selectAllMember"); 
	    // List 타입을 ArrayList로 형변환해서 리턴
	    return (ArrayList<Member>) list;
	}

    public int insertMember(SqlSession session, Member m)
    {
        int result = session.insert("mybatis.insertMember", m);
        
        return result;
    }

    public int updateMember(SqlSession session, Member m)
    {
        int result = session.update("mybatis.updateMember", m);
        
        return result;
    }

    public int deleteMember(SqlSession session, String memberId)
    {
        int result = session.delete("mybatis.deleteMember", memberId);
        
        return result;
    }

    public ArrayList<Member> checkMemberList(SqlSession session, Check ck)
    {
        List<Member> list = session.selectList("mybatis.checkMemberList", ck);
        
        return (ArrayList<Member>)list;
    }

    public ArrayList<Member> searchMember(SqlSession session, Search search)
    {
        List<Member> list = session.selectList("mybatis.searchMember", search);
        return (ArrayList<Member>)list;
    }

    public ArrayList<Member> searchMember2(SqlSession session, Search2 search)
    {
        List<Member> list = session.selectList("mybatis.searchMember2", search);
        return (ArrayList<Member>)list;
    }

    public ArrayList<Member> searchMember3(SqlSession session, String[] addr)
    {
        List<Member> list = session.selectList("mybatis.searchMember3", addr);
        return (ArrayList<Member>)list;
    }

}
