package org.kh.notice.model.vo;

import java.sql.Date;

public class Notice
{
    private int rnum;
    private int noticeNo;
    private String noticeTitle;
    private String noticeContent;
    private String noticeWriter;
    private Date noticeDate;
    private int readcount;
    private String filename;
    private String filepath;
    
    public Notice()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Notice(int rnum, int noticeNo, String noticeTitle, String noticeContent,
            String noticeWriter, Date noticeDate, int readcount,
            String filename, String filepath)
    {
        super();
        this.rnum = rnum;
        this.noticeNo = noticeNo;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeWriter = noticeWriter;
        this.noticeDate = noticeDate;
        this.readcount = readcount;
        this.filename = filename;
        this.filepath = filepath;
    }
    
    
    
    public int getRnum()
    {
        return rnum;
    }

    public void setRnum(int rnum)
    {
        this.rnum = rnum;
    }

    public int getNoticeNo()
    {
        return noticeNo;
    }
    public void setNoticeNo(int noticeNo)
    {
        this.noticeNo = noticeNo;
    }
    public String getNoticeTitle()
    {
        return noticeTitle;
    }
    public void setNoticeTitle(String noticeTitle)
    {
        this.noticeTitle = noticeTitle;
    }
    public String getNoticeContent()
    {
        return noticeContent;
    }
    public void setNoticeContent(String noticeContent)
    {
        this.noticeContent = noticeContent;
    }
    public String getNoticeWriter()
    {
        return noticeWriter;
    }
    public void setNoticeWriter(String noticeWriter)
    {
        this.noticeWriter = noticeWriter;
    }
    public Date getNoticeDate()
    {
        return noticeDate;
    }
    public void setNoticeDate(Date noticeDate)
    {
        this.noticeDate = noticeDate;
    }
    public int getReadcount()
    {
        return readcount;
    }
    public void setReadcount(int readcount)
    {
        this.readcount = readcount;
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
    
    
}
