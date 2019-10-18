package org.kh.photo.model.vo;

import java.sql.Date;

public class Photo
{
    private int photoNo;
    private String photoWriter;
    private String photoContent;
    private String filename;
    private String filepath;
    private Date photoDate;
    
    public Photo()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Photo(int photoNo, String photoWriter, String photoContent,
            String filename, String filepath, Date photoDate)
    {
        super();
        this.photoNo = photoNo;
        this.photoWriter = photoWriter;
        this.photoContent = photoContent;
        this.filename = filename;
        this.filepath = filepath;
        this.photoDate = photoDate;
    }
    
    public int getPhotoNo()
    {
        return photoNo;
    }
    public void setPhotoNo(int photoNo)
    {
        this.photoNo = photoNo;
    }
    public String getPhotoWriter()
    {
        return photoWriter;
    }
    public void setPhotoWriter(String photoWriter)
    {
        this.photoWriter = photoWriter;
    }
    public String getPhotoContent()
    {
        return photoContent;
    }
    public void setPhotoContent(String photoContent)
    {
        this.photoContent = photoContent;
    }
    public String getFilename()
    {
        return filename;
    }
    public void setFilename(String filename)
    {
        this.filename = filename;
    }
    public String getFilepath()
    {
        return filepath;
    }
    public void setFilepath(String filepath)
    {
        this.filepath = filepath;
    }
    public Date getPhotoDate()
    {
        return photoDate;
    }
    public void setPhotoDate(Date photoDate)
    {
        this.photoDate = photoDate;
    }
    
    
    
}
