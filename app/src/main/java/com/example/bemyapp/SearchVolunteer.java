package com.example.bemyapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SearchVolunteer {

    private boolean isAvaliableInTime(Volunteer volunteer) {
        if (volunteer.getBusy()) {
            return false;
        }
        Date now = new Date();
        try {
            now = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(now.toString());
        }
        catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Map<Date, Date> schedual = volunteer.getAvailableWhen();
        for (Map.Entry<Date, Date> entry : schedual.entrySet()) {
            if (entry.getKey().before(now) && entry.getValue().after(now)) {
                return true;
            }
        }
        return false;
    }

    private Volunteer searchVolunteerForLegs(String city) {
        List<Volunteer> volunteers = Info.getInstance().getVolunteersList();
        for (int i = 0; i < volunteers.size(); i++) {
            if (volunteers.get(i).getAvailableFor().get("callOrMessage") &&
                    volunteers.get(i).getAvailableFor().get("Mission")) {
                if (volunteers.get(i).getCity().equals(city)) {
                    if (isAvaliableInTime(volunteers.get(i))) {
                        volunteers.get(i).setBusy(true);
                        return volunteers.get(i);
                    }
                }
            }
        }
        return null;
    }

    private Volunteer searchVolunteerForEarsOrMouth() {
        List<Volunteer> volunteers = Info.getInstance().getVolunteersList();
        for (int i = 0; i < volunteers.size(); i++) {
            if (volunteers.get(i).getAvailableFor().get("callOrMessage") &&
                    volunteers.get(i).getAvailableFor().get("Mission")) {
                if (isAvaliableInTime(volunteers.get(i))) {
                    volunteers.get(i).setBusy(true);
                    return volunteers.get(i);
                }
            }
        }
        return null;
    }

    private Volunteer searchVolunteerForFriend(String city){
        Volunteer volunteer = searchVolunteerForLegs(city);
        if (volunteer != null) { return volunteer;}
        volunteer = searchVolunteerForEarsOrMouth();
        return volunteer;
    }

    public List<Volunteer> getVolunteersForLegs(String city) {
        List<Volunteer> volunteerList = new ArrayList<Volunteer>();
        for(int i = 0; i < 3; i++) {
            Volunteer newVol = searchVolunteerForLegs(city);
            if ( newVol == null) {
                break;
            }
            volunteerList.add(newVol);
        }
        if (volunteerList.isEmpty()) {
            return null;
        }
        return volunteerList;
    }

    public List<Volunteer> getVolunteersForEarsOrMouth() {
        List<Volunteer> volunteerList = new ArrayList<Volunteer>();
        for(int i = 0; i < 3; i++) {
            Volunteer newVol = searchVolunteerForEarsOrMouth();
            if ( newVol == null) {
                break;
            }
            volunteerList.add(newVol);
        }
        if (volunteerList.isEmpty()) {
            return null;
        }
        return volunteerList;
    }

    public List<Volunteer> getVolunteersForFriend(String city) {
        List<Volunteer> volunteerList = new ArrayList<Volunteer>();
        for(int i = 0; i < 3; i++) {
            Volunteer newVol = searchVolunteerForFriend(city);
            if (newVol == null) {
                break;
            }
            volunteerList.add(newVol);
        }
        if (volunteerList.isEmpty()) {
            return null;
        }
        return volunteerList;
    }
}
