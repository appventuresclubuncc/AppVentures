package com.uncc.appventures;

public class CabinetMember {
    private String name, position;
    private String major, concentration;
    private String reason, gradDate;
    private int imageId;

    public CabinetMember() {}

    public CabinetMember(String name, String position, String major, String concentration, String reason, String gradDate) {
        this.name = name;
        this.position = position;
        this.major = major;
        this.concentration = concentration;
        this.reason = reason;
        this.gradDate = gradDate;
    }

    public CabinetMember(String name, String position, int imageId, String major, String concentration, String reason, String gradDate) {
        this.name = name;
        this.position = position;
        this.imageId = imageId;
        this.major = major;
        this.concentration = concentration;
        this.reason = reason;
        this.gradDate = gradDate;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getImageId() {
        return imageId;
    }

    public String getMajor() {
        return major;
    }

    public String getConcentration() {
        return concentration;
    }

    public String getReason() {
        return reason;
    }

    public String getGradDate() {
        return gradDate;
    }
}
