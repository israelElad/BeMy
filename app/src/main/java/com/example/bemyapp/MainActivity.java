package com.example.bemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    VolunteerDataBase volunteerDataBase = new VolunteerDataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // narkis's check
        /*
        Map<String, Boolean> availableFor = new HashMap<>();
        availableFor.put("callOrMessage", false);
        availableFor.put("Mission", false);
        Map<Date, Date> availableWhen = new HashMap<>();
        availableWhen.put(volunteerDataBase.toDate("Wed Oct 16 00:00:00 PST 2013"), volunteerDataBase.toDate("Wed Oct 16 00:06:00 PST 2013"));
        Info.getInstance().addVolunteer("Yael", "0544736473", availableFor, "Tel-Aviv", availableWhen);
        volunteerDataBase.WriteToFile(this);
        Info.getInstance().setVolunteersList(volunteerDataBase.loadFromFile(this));*/
    }

    @Override
    public void onDestroy() {
        volunteerDataBase.loadFromFile(this);
        super.onDestroy();
    }

    public void beMyClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, beMyChoose.class);
        startActivity(intent);
    }
    public void beForClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, registration_form.class);
        startActivity(intent);
    }
}
