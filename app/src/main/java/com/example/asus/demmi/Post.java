package com.example.asus.demmi;

public class Post {

    String userName;
    String userPhoneNumber;
    String userWilaya;
    String userRegion;
    String Body;

    public Post() {
    }

    public Post(String userName, String userPhoneNumber, String userWilaya, String userRegion, String body) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userWilaya = userWilaya;
        this.userRegion = userRegion;
        Body = body;
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
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }
}
