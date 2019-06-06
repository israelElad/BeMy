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

    public void addVolunteer(String name, String phoneNumber, Map<String, Boolean> availableFor, String city,
                             Map<Date, Date> availableWhen){
        Volunteer volunteer = new Volunteer(name, phoneNumber, availableFor, city, availableWhen);
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
