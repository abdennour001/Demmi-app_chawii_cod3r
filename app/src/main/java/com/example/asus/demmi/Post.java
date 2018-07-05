package com.example.asus.demmi;

public class Post {

    private String userName;
    private String userPhoneNumber;
    private String userWilaya;
    private String userRegion;
    private String body;
    private String blood;
    private String rhesus;
    private String type;

    public Post() {
    }

    public Post(String userName, String userPhoneNumber, String userWilaya, String userRegion, String body) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userWilaya = userWilaya;
        this.userRegion = userRegion;
        this.body = body;
    }

    public Post(String userName, String userPhoneNumber, String userWilaya, String userRegion, String body,
    String blood, String rhesus) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userWilaya = userWilaya;
        this.userRegion = userRegion;
        this.body = body;
        this.blood = blood;
        this.rhesus = rhesus;
    }

    public Post(String userName, String userPhoneNumber, String userWilaya, String userRegion, String body,
    String blood, String rhesus, String type) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userWilaya = userWilaya;
        this.userRegion = userRegion;
        this.body = body;
        this.blood = blood;
        this.rhesus = rhesus;
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserWilaya() {
        return userWilaya;
    }

    public void setUserWilaya(String userWilaya) {
        this.userWilaya = userWilaya;
    }

    public String getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(String userRegion) {
        this.userRegion = userRegion;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getRhesus() {
        return rhesus;
    }

    public void setRhesus(String rhesus) {
        this.rhesus = rhesus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
