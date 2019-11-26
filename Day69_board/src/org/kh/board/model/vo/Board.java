package org.kh.board.model.vo;

import java.sql.Date;

public class Board
{
    private int boardNo;
    private String boardTitle;
    private String boardWriter;
    private String boardContent;
    private Date boardDate;
    public Board()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public Board(int boardNo, String boardTitle, String boardWriter,
            String boardContent, Date boardDate)
    {
        super();
        this.boardNo = boardNo;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContent = boardContent;
        this.boardDate = boardDate;
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
    public String getBoardWriter()
    {
        return boardWriter;
    }
    public void setBoardWriter(String boardWriter)
    {
        this.boardWriter = boardWriter;
    }
    public String getBoardContent()
    {
        return boardContent;
    }
    public void setBoardContent(String boardContent)
    {
        this.boardContent = boardContent;
    }
    public Date getBoardDate()
    {
        return boardDate;
    }
    public void setBoardDate(Date boardDate)
    {
        this.boardDate = boardDate;
    }
    
    
}
