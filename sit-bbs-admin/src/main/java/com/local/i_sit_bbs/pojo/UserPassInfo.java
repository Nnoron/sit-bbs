package com.local.i_sit_bbs.pojo;

public class UserPassInfo {
    private Integer userId;

    private String userName;

    private String passWord;

    private Integer valid;

    public UserPassInfo(Integer userId, String userName, String passWord,Integer valid) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.valid=valid;
    }

    public UserPassInfo() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}