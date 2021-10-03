package com.neeraj.csnotes;

public class user {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(int mobile_no) {
        this.mobile_no = mobile_no;
    }
    String username;
    String password;
    int mobile_no;

    public user(String username, String password, int mobile_no) {
        this.username = username;
        this.password = password;
        this.mobile_no = mobile_no;
    }

    public user(signup signup)
{

}
}
