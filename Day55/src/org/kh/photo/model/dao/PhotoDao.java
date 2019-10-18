package org.kh.photo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.common.JDBCTemplate;
import org.kh.photo.model.vo.Photo;

public class PhotoDao
{

    public int photoTotalCount(Connection conn)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select count(*) as total from photo";
        int totalCount = -1;
        
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                totalCount = rset.getInt("total");
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        
        return totalCount;
    }

    public int insertPhoto(Connection conn, Photo p)
    {
        PreparedStatement pstmt = null;
        String sql = "insert into photo values(seq_photo_no.nextval,?,?,?,?,sysdate)";
        int result = 0;
        
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getPhotoWriter());
            pstmt.setString(2, p.getPhotoContent());
            pstmt.setString(3, p.getFilename());
            pstmt.setString(4, p.getFilepath());
            
            result = pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
        }
        

        
        return result;
    }

    public ArrayList<Photo> morePhoto(Connection conn, int start, int end)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from (select ROWNUM as rnum,p.* from ( select * from photo order by photo_no desc) p ) where rnum between ? and ?";
        ArrayList<Photo> list = new ArrayList<>();
        
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Photo p = new Photo();
                p.setFilename(rset.getString("filename"));
                p.setFilepath(rset.getString("filepath"));
                p.setPhotoContent(rset.getString("photo_content"));
                p.setPhotoDate(rset.getDate("photo_date"));
                p.setPhotoWriter(rset.getString("photo_writer"));
                p.setPhotoNo(rset.getInt("photo_no"));
                
                list.add(p);
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        
        
        return list;
    }
    
}
