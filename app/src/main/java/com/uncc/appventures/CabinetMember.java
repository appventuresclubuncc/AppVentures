package com.uncc.appventures;

public class CabinetMember {
    // Creates Memeber Object according to firebase fields
    private String name, position;

    public CabinetMember() {
    }

    public CabinetMember(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

}
