package org.kh.board.model.vo;

import java.sql.Date;

public class Board
{
    private int rnum;
    private int boardNo;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private Date boardDate;
    private int readcount;
    private String filename;
    private String filepath;
    
    public Board()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Board(int rnum, int boardNo, String boardTitle, String boardContent,
            String boardWriter, Date boardDate, int readcount, String filename,
            String filepath)
    {
        super();
        this.rnum = rnum;
        this.boardNo = boardNo;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardWriter = boardWriter;
        this.boardDate = boardDate;
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
    public int getBoardNo()
    {
        return boardNo;
    }
    public void setBoardNo(int boardNo)
    {
        this.boardNo = boardNo;
    }
    public String getBoardTitle()
    {
        return boardTitle;
    }
    public void setBoardTitle(String boardTitle)
    {
        this.boardTitle = boardTitle;
    }
    public String getBoardContent()
    {
        return boardContent;
    }
    public void setBoardContent(String boardContent)
    {
        this.boardContent = boardContent;
    }
    public String getBoardWriter()
    {
        return boardWriter;
    }
    public void setBoardWriter(String boardWriter)
    {
        this.boardWriter = boardWriter;
    }
    public Date getBoardDate()
    {
        return boardDate;
    }
    public void setBoardDate(Date boardDate)
    {
        this.boardDate = boardDate;
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
