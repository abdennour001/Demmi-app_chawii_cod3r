package com.example.asus.demmi;

import java.util.Date;
import java.util.List;

/**
 * Created by asus on 13/03/2018.
 */

class Contact {

    /** Contact information */

    private User user;
    private List<Integer> extraPhoneNumbers;
    private List<String> extraEmails;
    private List<Wilaya> extraWilayas;
    private List<String> extraRegions;

    /*
    * **/

    /* eEmpty constructor */
    public Contact() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getExtraPhoneNumbers() {
        return extraPhoneNumbers;
    }

    public void setExtraPhoneNumbers(List<Integer> extraPhoneNumbers) {
        this.extraPhoneNumbers = extraPhoneNumbers;
    }

    public List<String> getExtraEmails() {
        return extraEmails;
    }

    public void setExtraEmails(List<String> extraEmails) {
        this.extraEmails = extraEmails;
    }

    public List<Wilaya> getExtraWilayas() {
        return extraWilayas;
    }

    public void setExtraWilayas(List<Wilaya> extraWilayas) {
        this.extraWilayas = extraWilayas;
    }

    public List<String> getExtraRegions() {
        return extraRegions;
    }

    public void setExtraRegions(List<String> extraRegions) {
        this.extraRegions = extraRegions;
    }
}
