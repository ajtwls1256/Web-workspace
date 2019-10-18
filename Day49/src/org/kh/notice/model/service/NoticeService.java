package org.kh.notice.model.service;

import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;

import org.kh.common.JDBCTemplate;
import org.kh.notice.model.dao.NoticeDao;
import org.kh.notice.model.vo.Notice;
import org.kh.notice.model.vo.PageData;

public class NoticeService
{
    public PageData selectList(int reqPage){
        Connection conn = JDBCTemplate.getConnection();
        NoticeDao dao = new NoticeDao();
        
        int numPerPage = 10;    // 한 페이지 당 게시물 수
        int totalCount = dao.totalCount(conn);      // 전체 게시물 수
        
        // 100 -> 10, 101 -> 11, 111 -> 12
        // 나머지가 0인경우 -> 몫만, 나머지가 0이아닌경우 -> 몫+1
        int totalPage = (totalCount%numPerPage == 0) ? (totalCount/numPerPage) : (totalCount/numPerPage) + 1;
        System.out.println("totalpage : " + totalPage);
        
        
        // 1 page -> 1번글~10번글, 2page -> 11번글 ~ 20번글
        int start = (reqPage - 1)*numPerPage +1;        // 페이지 시작 게시글 번호
        int end = reqPage*numPerPage;                   // 페이지 마지막 게시글 번호
        System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
        
        ArrayList<Notice> list = dao.selectList(conn, start, end);
        
        
        /* 페이지 네비게이션 생성*/
        /* 이전 1 2 3 4 5 다음 */
        /* 이전 6 7 8 9 10 다음 */
        
        int pageNaviSize = 5;   // 페이지 넘버 수
        String pageNavi = "";   // 페이지 네비 HTML을 저장하는 변수
        
        // pageNo 는 해당 페이지 시작번호
        // 1 ~ 5 -> 1 , 6 ~ 10 -> 6
        int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;       // 일부러 정수연산시켜서 나눗셈 연산에 소수점이 안나오게 처리
        
        
        // 내 페이지가 항상 가운데로 가게
//        int pageNo = 1;
//        if(reqPage > 2) {
//            pageNo = reqPage-2;
//        }
        
        
        // 이전 버튼 생성
        if(pageNo != 1) {
            pageNavi += "<a class='btn' href='/noticeList?reqPage="+ (pageNo-1)+"'>이전</a>";     // 6 7 8 9 10 일때 5를 부르기 위해 6 - 1 = 5
        }
        
        // 한 칸씩 이동하게 만들기
//        if(pageNo != 1) {
//            pageNavi += "<a class='btn' href='/noticeList?reqPage="+ (reqPage-1)+"'>이전</a>";     // 6 7 8 9 10 일때 5를 부르기 위해 6 - 1 = 5
//        }
        
 
        // i 를 1부터 증가시키면서 pageNaviSize 만큼 반복문
        // 단, pageNo가 totalPage보다 크면 마지막 페이지에 도달한 것이므로
        // 반복문 수행을 멈춤
        int i = 1;
        while(! (i++ > pageNaviSize || pageNo > totalPage)) {
            if(reqPage == pageNo) {
                pageNavi += "<span class='selectPage'>" + pageNo + "</span>";
            }else {
                pageNavi += "<a class='btn' href='/noticeList?reqPage=" + pageNo + "'>" + pageNo + "</a>";
            }
            pageNo++;
        }
        
        // 마지막 페이지보다 값이 크면 다음 버튼이 필요가 없으므로 생성을 안함
        if(pageNo <= totalPage) {
            pageNavi += "<a class='btn' href='/noticeList?reqPage=" + pageNo + "'>다음</a>";
        }
        
        // 한 칸씩 이동하게 만들기
//        if(pageNo <= totalPage) {
//            pageNavi += "<a class='btn' href='/noticeList?reqPage=" + (reqPage+1) + "'>다음</a>";
//        }
        
        PageData pd = new PageData(list, pageNavi);
            
        
        JDBCTemplate.close(conn);
        return pd;
    }
    
    
    public Notice selectOne(int noticeNo) {
        Connection conn = JDBCTemplate.getConnection();
        NoticeDao dao = new NoticeDao();
        
        Notice n = dao.selectOne(conn, noticeNo);
        
        if(n != null) {
            int result = dao.readCount(conn, noticeNo);
            
            if(result > 0) {
                JDBCTemplate.commit(conn);
            }else {
                JDBCTemplate.rollback(conn);
            }
            
        }
        
        JDBCTemplate.close(conn);
        return n;
    }
    
    
    
    public int insertNotice(Notice n) {
        Connection conn = JDBCTemplate.getConnection();
        NoticeDao dao = new NoticeDao();
        
        int result = dao.insertNotice(conn, n);
        
        if(result > 0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        
        JDBCTemplate.close(conn);
        return result;
    }
    
    
}
