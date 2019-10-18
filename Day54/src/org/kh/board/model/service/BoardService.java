package org.kh.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import org.kh.board.model.dao.BoardDao;
import org.kh.board.model.vo.Board;
import org.kh.board.model.vo.BoardPageData;
import org.kh.common.JDBCTemplate;

public class BoardService
{

    public BoardPageData selectList(int reqPage)
    {
        Connection conn = JDBCTemplate.getConnection();
        BoardDao dao = new BoardDao();
     
        
        /* 페이지 가져오기 */
        
        int numPerPage = 10;    // 한 페이지당 게시물 수
        int totalCount = dao.totalCount(conn);  // 전체 게시물 수
        
        // 전체 페이지 수
        int totalPage = (totalCount%numPerPage==0) ? (totalCount/numPerPage) : (totalCount/numPerPage)+1;
        
        // 현재 페이지의 처음 글의 글번호와 마지막 글의 글번호
        int start = (reqPage - 1)*numPerPage + 1;
        int end = reqPage * numPerPage;
        
        ArrayList<Board> list = dao.selectList(conn, start, end);
        
        
        /* 페이지 번호에맞는 페이지 네비 생성 */
        int pageNaviSize = 5;   // 한 네비에 페이지 수
        String pageNavi = "";
        
        int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize +1;   // 페이지 네비 시작번호
        
        System.out.println(pageNo);
        
        // 이전 버튼 생성 (1~5 페이지면 생성x)
        if(pageNo != 1) {
            pageNavi += "<a class='btn' href='/boardList?reqPage="+(pageNo - 1)+"'>이전</a>";
        }
        
        // 페이지 네비 크기만큼 돌면서 네비를 추가, 단 마지막페이지를 넘어가면 for문 중단
        for(int i =0; i<pageNaviSize; i++) {
            if(pageNo+i > totalPage)
            {
                break;
            }
            
            // 현재 페이지일 시는 a태그를 빼고 현재 페이지 표시
            if(pageNo+i == reqPage) {
                pageNavi += "<span class='selectPage'>" + (pageNo+i) + "</span>";
            }else {
                pageNavi += "<a class='btn' href='/boardList?reqPage=" + (pageNo+i) + "'>" + (pageNo+i) + "</a>";
            }
        }
        
        // 페이지 네비 시작번호 + 네비에 페이지 수 가 마지막페이지보다 크면 넘길 글이 없으니 다음버튼 생성x
        if(pageNo + pageNaviSize <= totalPage) {
            pageNavi += "<a class='btn' href='/boardList?reqPage=" + (pageNo + pageNaviSize) + "'>다음</a>";
        }
        
        
        BoardPageData bpd = new BoardPageData(list, pageNavi);
        
        JDBCTemplate.close(conn);
        return bpd;
    }

    public Board selectOne(int boardNo)
    {
        Connection conn = null;
        BoardDao dao = new BoardDao();
        
        Board board = dao.selectOne(conn, boardNo);
        
        JDBCTemplate.close(conn);
        
        
        
        return board;
    }
    
}
