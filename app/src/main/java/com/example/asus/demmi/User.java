package com.example.asus.demmi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 13/03/2018.
 */

class User {

    private int id;
    private String email;
    private String firstName;
    private String familyName;
    private String age;
    private BloodType bloodType;
    private Wilayas wilaya;
    private String region;
    private List<String> phoneNumbers = new ArrayList<>();
    private Sex sex;
    private String password;
    private List<Post> posts = new ArrayList<>();

    /* eEmpty constructor */
    public User() {

    }

    /* Full stack constructor */
    public User(int id, String password, String age, String email, String firstName, String familyName, BloodType bloodType, Wilayas wilaya, String region, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.id = id;
        this.firstName = firstName;
        this.familyName = familyName;
        this.age = age;
        this.bloodType = bloodType;
        this.wilaya = wilaya;
        this.region = region;
        this.phoneNumbers.add(phoneNumber);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Wilayas getWilaya() {
        return wilaya;
    }

    public void setWilaya(Wilayas wilaya) {
        this.wilaya = wilaya;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
