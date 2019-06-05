package com.example.bemyapp;

import java.util.Date;
import java.util.List;

public class Seek {

    boolean isAvaliableInTime(Volunteer volunteer){
        Date now = new Date();
        return false;
    }

    public Volunteer seekVolunteerForLegs() {
        List<Volunteer> volunteers = Info.getInstance().getVolunteersList();
        for (int i = 0; i < volunteers.size(); i++) {
            if ((volunteers.get(i).getAvilableFor().get("call") == null) &&
                    volunteers.get(i).getAvilableFor().get("call") &&
                    volunteers.get(i).getAvilableFor().get("mission")) {
                //TODO: BLA
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
