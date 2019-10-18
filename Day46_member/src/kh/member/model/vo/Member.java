package kh.member.model.vo;

public class Member
{
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberPhone;
    private int memberLevel;
    
    public Member()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Member(String memberId, String memberPw, String memberName,
            String memberPhone, int memberLevel)
    {
        super();
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberLevel = memberLevel;
    }

    public String getMemberId()
    {
        return memberId;
    }

    public void setMemberId(String memberId)
    {
        this.memberId = memberId;
    }

    public String getMemberPw()
    {
        return memberPw;
    }

    public void setMemberPw(String memberPw)
    {
        this.memberPw = memberPw;
    }

    public String getMemberName()
    {
        return memberName;
    }

    public void setMemberName(String memberName)
    {
        this.memberName = memberName;
    }

    public String getMemberPhone()
    {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone)
    {
        this.memberPhone = memberPhone;
    }

    public int getMemberLevel()
    {
        return memberLevel;
    }

    public void setMemberLevel(int memberLevel)
    {
        this.memberLevel = memberLevel;
    }
    
    
    
}
