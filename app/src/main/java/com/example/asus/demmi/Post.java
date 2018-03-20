package com.example.asus.demmi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by asus on 13/03/2018.
 */

class Post {
    /** Post attributes */

    private List<BloodType> bloodType = new ArrayList<>();
    private Wilaya wilaya;
    private String region;
    private Date postDate; // dateof the post.
    private Date dateBegin; // First day of the Don.
    private Date dateFinish; // Final day of the Don.
    private int postID;
    private String postText;
    private Contact contactElements; // Contains post publisher, the don date and place, user personal information (name, email, phone number and more).
    private List<PostTag> postTags = new ArrayList<>();

    /**
     * */

    /* eEmpty constructor */
    public Post() {

    }



    public List<BloodType> getBloodType() {
        return bloodType;
    }

    public void setBloodType(List<BloodType> bloodType) {
        this.bloodType = bloodType;
    }

    public Wilaya getWilaya() {
        return wilaya;
    }

    public void setWilaya(Wilaya wilaya) {
        this.wilaya = wilaya;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Contact getContactElements() {
        return contactElements;
    }

    public void setContactElements(Contact contactElements) {
        this.contactElements = contactElements;
    }

    public List<PostTag> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<PostTag> postTags) {
        this.postTags = postTags;
    }

    public void addTag(PostTag Tag) {
        this.postTags.add(Tag);
    }

    public void addBloodType(BloodType bloodType) {
        this.bloodType.add(bloodType);
    }
}
