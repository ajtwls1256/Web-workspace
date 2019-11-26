package kr.co.tomato.vo;

import java.sql.Date;

public class Chat
{
    private String chatName;
    private String chatContent;
    private Date chatTime;
    public Chat()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public Chat(String chatName, String chatContent, Date chatTime)
    {
        super();
        this.chatName = chatName;
        this.chatContent = chatContent;
        this.chatTime = chatTime;
    }
    public String getChatName()
    {
        return chatName;
    }
    public void setChatName(String chatName)
    {
        this.chatName = chatName;
    }
    public String getChatContent()
    {
        return chatContent;
    }
    public void setChatContent(String chatContent)
    {
        this.chatContent = chatContent;
    }
    public Date getChatTime()
    {
        return chatTime;
    }
    public void setChatTime(Date chatTime)
    {
        this.chatTime = chatTime;
    }
    
    
}
