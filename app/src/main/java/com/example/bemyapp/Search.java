package com.example.bemyapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Search {

    private boolean isAvaliableInTime(Volunteer volunteer) {
        if (volunteer.getBusy()) {
            return false;
        }
        Date now = new Date();
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
            if (volunteers.get(i).getAvailableFor().get("call") &&
                    volunteers.get(i).getAvailableFor().get("mission")) {
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
            if (volunteers.get(i).getAvailableFor().get("call") &&
                    volunteers.get(i).getAvailableFor().get("mission")) {
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
            if (searchVolunteerForLegs(city) == null) {
                break;
            }
            volunteerList.add(searchVolunteerForLegs(city));
        }
        if (volunteerList.isEmpty()) {
            return null;
        }
        return volunteerList;
    }

    public List<Volunteer> getVolunteersForEarsOrMouth() {
        List<Volunteer> volunteerList = new ArrayList<Volunteer>();
        for(int i = 0; i < 3; i++) {
            if (searchVolunteerForEarsOrMouth() == null) {
                break;
            }
            volunteerList.add(searchVolunteerForEarsOrMouth());
        }
        if (volunteerList.isEmpty()) {
            return null;
        }
        return volunteerList;
    }

    public List<Volunteer> getVolunteersForFriend(String city) {
        List<Volunteer> volunteerList = new ArrayList<Volunteer>();
        for(int i = 0; i < 3; i++) {
            if (searchVolunteerForFriend(city) == null) {
                break;
            }
            volunteerList.add(searchVolunteerForFriend(city));
        }
        if (volunteerList.isEmpty()) {
            return null;
        }
        return volunteerList;
    }
}
