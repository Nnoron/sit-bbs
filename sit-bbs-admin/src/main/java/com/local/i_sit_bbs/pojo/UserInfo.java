package com.local.i_sit_bbs.pojo;

public class UserInfo {
    private Integer userId;

    private String userName;

    private String nickName;

    private String realName;

    private String gender;

    private String birthday;

    private String college;

    private String building;

    private String major;

    private String briefIntroduce;

    private String headPath;

    private String personalLabels;

    private String registerTime;

    private String arvTime;

    private Integer valid;

    public UserInfo(String name){
        this.userName=name;
    }

    public UserInfo(Integer userId,String userName, String nickName, String realName, String gender,
                    String birthday, String college, String building, String major, String briefIntroduce,
                    String headPath, String personalLabels,String arvTime,Integer valid) {
        this.userId = userId;
        this.userName=userName;
        this.nickName = nickName;
        this.realName = realName;
        this.gender = gender;
        this.birthday = birthday;
        this.college = college;
        this.building = building;
        this.major = major;
        this.briefIntroduce = briefIntroduce;
        this.headPath = headPath;
        this.personalLabels = personalLabels;
        this.arvTime=arvTime;
        this.valid=valid;
    }

    public UserInfo() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getBriefIntroduce() {
        return briefIntroduce;
    }

    public void setBriefIntroduce(String briefIntroduce) {
        this.briefIntroduce = briefIntroduce == null ? null : briefIntroduce.trim();
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath == null ? null : headPath.trim();
    }

    public String getPersonalLabels() {
        return personalLabels;
    }

    public void setPersonalLabels(String personalLabels) {
        this.personalLabels = personalLabels == null ? null : personalLabels.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getArvTime() {
        return arvTime;
    }

    public void setArvTime(String arvTime) {
        this.arvTime = arvTime;
    }
}