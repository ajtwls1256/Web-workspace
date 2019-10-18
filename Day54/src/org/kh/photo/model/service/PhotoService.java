package org.kh.photo.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import org.kh.common.JDBCTemplate;
import org.kh.photo.model.dao.PhotoDao;
import org.kh.photo.model.vo.Photo;

public class PhotoService
{

    public int photoTotalCount()
    {
        Connection conn = JDBCTemplate.getConnection();
        PhotoDao dao = new PhotoDao();
        int totalCount = dao.photoTotalCount(conn);
        
        JDBCTemplate.close(conn);
        
        return totalCount;
    }

    public int insertPhoto(Photo p)
    {
        Connection conn = JDBCTemplate.getConnection();
        PhotoDao dao = new PhotoDao();
        int result = dao.insertPhoto(conn, p);
        
        
        if(result > 0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        
        
        JDBCTemplate.close(conn);

        return result;
    }

    public ArrayList<Photo> morePhoto(int start)
    {
        Connection conn = JDBCTemplate.getConnection();
        int length = 5; // 한번에 가져올 갯수
        
        PhotoDao dao = new PhotoDao();
        // conn, 가져올 시작번호, 가져올 끝번호
        ArrayList<Photo> list = dao.morePhoto(conn, start, (start + length - 1));
        
        JDBCTemplate.close(conn);
        
        return list;
    }
    

}
