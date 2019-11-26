package org.kh.board.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.board.model.dao.BoardDao;
import org.kh.board.model.vo.Board;
import org.kh.board.model.vo.BoardPage;

import common.SqlSessionTemplate;

public class BoardService
{

    public ArrayList<Board> selectAllBoard()
    {
        SqlSession session = SqlSessionTemplate.getSqlSession();
        BoardDao dao = new BoardDao();
        
        ArrayList<Board> list = dao.selectAllBoard(session);
        
        session.close();
        return list;
    }

    public BoardPage selectBoardList(int reqPage)
    {
        SqlSession session = SqlSessionTemplate.getSqlSession();
        BoardDao dao = new BoardDao();
        
        int totalCount = dao.getTotalCount(session);
        System.out.println("Board의 totalCount : " + totalCount);
        
        int naviPerBoard = 5;
        int endNavi = (totalCount%naviPerBoard)>0?(totalCount/naviPerBoard)+1:(totalCount/naviPerBoard);
        
        int pagePerNavi = 5;
        int pageStartNavi = 
        
        return null;
    }
    
    
    
}
