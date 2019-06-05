package com.example.bemyapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Volunteer {
    //personal info
    private String name;
    private String phoneNumber;
    //help info
    private TreeMap<String, Boolean> avilableFor;
    private ArrayList<Date> avilableWhen;
    //location info
    private String city;



    public Volunteer(String name, String phoneNumber, TreeMap<String, Boolean> avilableFor, ArrayList<Date> avilableWhen, String city) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.avilableFor = avilableFor;
        this.avilableWhen = avilableWhen;
        this.city = city;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TreeMap<String, Boolean> getAvilableFor() {
        return avilableFor;
    }

    public void setAvilableFor(TreeMap<String, Boolean> avilableFor) {
        this.avilableFor = avilableFor;
    }

    public ArrayList<Date> getAvilableWhen() {
        return avilableWhen;
    }

    public void setAvilableWhen(ArrayList<Date> avilableWhen) {
        this.avilableWhen = avilableWhen;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
