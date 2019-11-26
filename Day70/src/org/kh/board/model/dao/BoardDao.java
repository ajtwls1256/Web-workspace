package org.kh.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.board.model.vo.Board;

public class BoardDao
{

    public ArrayList<Board> selectAllBoard(SqlSession session)
    {
        List<Board> list = session.selectList("mybatis2.selectAllBoard");
        
        return (ArrayList<Board>)list;
    }

    public int getTotalCount(SqlSession session)
    {
        int totalCount = session.selectOne("mybatis2.totalCount");
        return totalCount;
    }
    
}
