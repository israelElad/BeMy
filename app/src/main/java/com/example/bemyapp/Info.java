package com.example.bemyapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Info {
    private static Info instance = null;
    private List<Volunteer> volunteersList;
    private Boolean isInSearching;

    // private constructor restricted to this class itself
    private Info()
    {
        volunteersList = new ArrayList<Volunteer>();
        isInSearching = false;
    }

    // static method to create instance of Singleton class
    public static Info getInstance()
    {
        if (instance == null)
            instance = new Info();

        return instance;
    }

    public Boolean isVolunteerExist(String phoneNumber){
        for (int i = 0; i < volunteersList.size(); i++){
            if (volunteersList.get(i).getPhoneNumber().equals(phoneNumber)){
                return true;
            }
        }
        return false;
    }

    public Volunteer getVolunteer(String phoneNumber){
        for (int i = 0; i < volunteersList.size(); i++){
            if (volunteersList.get(i).getPhoneNumber().equals(phoneNumber)){
                return volunteersList.get(i);
            }
        }
        return null;
    }

    public Volunteer getVolunteerForUpdating(String phoneNumber){
        for (int i = 0; i < volunteersList.size(); i++){
            if (volunteersList.get(i).getPhoneNumber().equals(phoneNumber)){
                removeVolunteer(phoneNumber);
                return volunteersList.get(i);
            }
        }
        return null;
    }

    public void addVolunteer(Volunteer volunteer){
        volunteersList.add(volunteer);
    }

    public void removeVolunteer(String phoneNumber){
        // Waiting the search will finish
        while (isInSearching){
            System.out.println("waiting...");
        }
        for (int i = 0; i < volunteersList.size(); i++){
            if (volunteersList.get(i).getPhoneNumber().equals(phoneNumber)){
                volunteersList.remove(i);
                return;
            }
        }
    }

    public List<Volunteer> getVolunteersList(){
        return volunteersList;
    }

    public void setVolunteersList(List<Volunteer> volunteersList) {
        this.volunteersList = volunteersList;
    }

    public Boolean getIsInSearching() {
        return isInSearching;
    }

    public void setIsInSearching(Boolean newIsInSearching) {
        isInSearching = newIsInSearching;
    }
}
