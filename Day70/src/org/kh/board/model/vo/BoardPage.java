package org.kh.board.model.vo;

import java.util.ArrayList;

public class BoardPage
{
    private ArrayList<Board> list;
    private String navi;
    public BoardPage()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public BoardPage(ArrayList<Board> list, String navi)
    {
        super();
        this.list = list;
        this.navi = navi;
    }
    public ArrayList<Board> getList()
    {
        return list;
    }
    public void setList(ArrayList<Board> list)
    {
        this.list = list;
    }
    public String getNavi()
    {
        return navi;
    }
    public void setNavi(String navi)
    {
        this.navi = navi;
    }
    
    
    
}
