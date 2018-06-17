package com.example.asus.demmi;

public class User {

    String userName;
    String phoneNumber;
    String email;
    String wilaya;
    String region;
    String sex;
    String age;
    String bloodCategory;
    String bloodRH;

    public User() {
    }

    public User(String userName, String phoneNumber, String email, String wilaya, String region, String sex, String age, String bloodCategory, String bloodRH) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.wilaya = wilaya;
        this.region = region;
        this.sex = sex;
        this.age = age;
        this.bloodCategory = bloodCategory;
        this.bloodRH = bloodRH;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWilaya() {
        return wilaya;
    }

    public void setWilaya(String wilaya) {
        this.wilaya = wilaya;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBloodCategory() {
        return bloodCategory;
    }

    public void setBloodCategory(String bloodCategory) {
        this.bloodCategory = bloodCategory;
    }

    public String getBloodRH() {
        return bloodRH;
    }

    public void setBloodRH(String bloodRH) {
        this.bloodRH = bloodRH;
    }
}
