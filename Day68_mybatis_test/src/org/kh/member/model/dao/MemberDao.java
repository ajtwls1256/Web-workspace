package org.kh.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.Member;

public class MemberDao {

	public Member loginMember(SqlSession session, Member m) {
		Member member = session.selectOne("mybatis.loginMember",m);
		return member;
	}

	public ArrayList<Member> selectAllMember(SqlSession session) {
		List<Member> list = session.selectList("mybatis.selectAllMember"); //selectList는 리스트 타입으로밖에 안돼서 여기서 리스트로 만들고 ArrayList에서 형변환
		return (ArrayList<Member>) list;// List 타입을 ArrayList로 형변환해서 리턴
	}

}
