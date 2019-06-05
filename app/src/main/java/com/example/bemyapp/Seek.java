package com.example.bemyapp;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Seek {

    boolean isAvaliableInTime(Volunteer volunteer){
        if (volunteer.getBusy()) {
            return false;
        }
        Date now = new Date();
        Map<Date, Date> schedual =  volunteer.getAvailableWhen();
        for (Map.Entry<Date, Date> entry : schedual.entrySet()) {
            if (entry.getKey().before(now) && entry.getValue().after(now)) {
                return true;
            }
        }
        return false;
    }

    public Volunteer seekVolunteerForLegs(String city) {
        List<Volunteer> volunteers = Info.getInstance().getVolunteersList();
        for (int i = 0; i < volunteers.size(); i++) {
            if(volunteers.get(i).getAvailableFor().get("call") &&
                    volunteers.get(i).getAvailableFor().get("mission")) {
                if(volunteers.get(i).getCity().equals(city)) {
                    if(isAvaliableInTime(volunteers.get(i))){
                        volunteers.get(i).setBusy(true);
                        return volunteers.get(i);
                    }
                }
            }
        }
        return null;
    }

    public Volunteer seekVolunteerForEars() {
        return null;
    }

    public Volunteer seekVolunteerForMouth() {
        return null;
    }

    public Volunteer seekVolunteerForFriend() {
        return null;
    }
}
