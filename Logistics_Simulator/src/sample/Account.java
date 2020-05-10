package sample;

public class Account {
    private String Email;
    private String PassWord;
    //private String member_SSN;

    public Account(String email, String passWord) {
        Email = email;
        PassWord = passWord;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

//    public String getMember_SSN() {
//        return member_SSN;
//    }

//    public void setMember_SSN(String member_SSN) {
//        this.member_SSN = member_SSN;
//    }
}
