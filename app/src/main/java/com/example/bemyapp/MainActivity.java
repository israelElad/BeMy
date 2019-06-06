package com.example.bemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VolunteerDataBase volunteerDataBase = new VolunteerDataBase(this);
        Info.getInstance().setVolunteersList(volunteerDataBase.loadFromFile());

        // narkis's check
        /*
        Map<String, Boolean> availableFor = new HashMap<>();
        availableFor.put("callOrMessage", true);
        availableFor.put("Mission", true);
        Map<Date, Date> availableWhen = new HashMap<>();
        availableWhen.put(volunteerDataBase.toDate("thu Oct 06 00:00:00 PST 2018"), volunteerDataBase.toDate("thu Oct 06 00:14:00 PST 2020"));
        Info.getInstance().addVolunteer(new Volunteer("Yael", "0544736473", availableFor, "Tel-Aviv", availableWhen));
        volunteerDataBase.WriteToFile();
        Info.getInstance().setVolunteersList(volunteerDataBase.loadFromFile());
        */

    }

    @Override
    public void onStop() {
        super.onStop();
        VolunteerDataBase volunteerDataBase = new VolunteerDataBase(this);
        volunteerDataBase.loadFromFile();
    }

    public void beMyClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, beMyChoose.class);
        startActivity(intent);
    }
    public void beForClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, beFor.class);
        startActivity(intent);
    }
}
