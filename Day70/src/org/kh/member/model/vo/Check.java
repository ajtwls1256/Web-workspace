package org.kh.member.model.vo;

public class Check
{
    private String ckId;
    private String ckPw;
    private String ckName;
    private String ckAddr;
    
    public Check()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Check(String ckId, String ckPw, String ckName, String ckAddr)
    {
        super();
        this.ckId = ckId;
        this.ckPw = ckPw;
        this.ckName = ckName;
        this.ckAddr = ckAddr;
    }
    
    public String getCkId()
    {
        return ckId;
    }
    public void setCkId(String ckId)
    {
        this.ckId = ckId;
    }
    public String getCkPw()
    {
        return ckPw;
    }
    public void setCkPw(String ckPw)
    {
        this.ckPw = ckPw;
    }
    public String getCkName()
    {
        return ckName;
    }
    public void setCkName(String ckName)
    {
        this.ckName = ckName;
    }
    public String getCkAddr()
    {
        return ckAddr;
    }
    public void setCkAddr(String ckAddr)
    {
        this.ckAddr = ckAddr;
    }
    
    
}
