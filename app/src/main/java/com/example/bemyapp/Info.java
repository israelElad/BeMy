package com.example.bemyapp;

import java.util.ArrayList;
import java.util.List;

public class Info {
    private static Info instance = null;
    private List<Volunteer> volunteersList;

    // private constructor restricted to this class itself
    private Info()
    {
        volunteersList = new ArrayList<Volunteer>();
    }

    // static method to create instance of Singleton class
    public static Info getInstance()
    {
        if (instance == null)
            instance = new Info();

        return instance;
    }
    public void addVolunteer(){}
    public void removeVolunteer(){}

    public List<Volunteer> getVolunteersList(){
        return this.volunteersList;
    }

}
