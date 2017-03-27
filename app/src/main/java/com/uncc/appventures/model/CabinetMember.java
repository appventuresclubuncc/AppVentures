package com.uncc.appventures.model;

/**
 * Created by Sanket on 2/17/2017.
 */

public class CabinetMember {
    private String experience;
    private String joined;
    private String major;
    private String name;
    private String position;
    private String url;
    private String year;

    public CabinetMember() {

    }

    public CabinetMember(String experience, String joined, String major, String name, String position, String url, String year) {
        this.experience = experience;
        this.joined = joined;
        this.major = major;
        this.name = name;
        this.position = position;
        this.url = url;
        this.year = year;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getJoined() {
        return joined;
    }

    public void setJoined(String joined) {
        this.joined = joined;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

