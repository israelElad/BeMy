package com.example.bemyapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


public class Volunteer {
    //personal info
    private String name;
    private String phoneNumber;
    //help info
    private Map<String, Boolean> availableFor;
    private Map<Date, Date> availableWhen;
    //location info
    private String city;



    public Volunteer(String name, String phoneNumber, Map<String, Boolean> availableFor,
                     Map<Date, Date> availableWhen, String city) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.availableFor = availableFor;
        this.availableWhen = availableWhen;
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

    public Map<String, Boolean> getAvailableFor() {
        return availableFor;
    }

    public void setAvailableFor(Map<String, Boolean> avilableFor) {
        this.availableFor = avilableFor;
    }

    public Map<Date, Date> getAvailableWhen() {
        return availableWhen;
    }

    public void setAvailableWhen(Map<Date, Date> avilableWhen) {
        this.availableWhen = avilableWhen;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

   /* //@androidx.annotation.NonNull
    @Override
    public String toString() {
       // Gson gson=new Gson();
        // return gson.toJson(this);
        return new String("Name: "+name+", "
               + "Phone: "+ phoneNumber +", "
                + "Call: "+ availableFor.get() +", "
                + "Message: "+ availableFor.get() +", "

                + "City: "+ phoneNumber +", "
        );
    }*/
}
