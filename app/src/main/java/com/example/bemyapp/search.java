package com.example.bemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        String beMyWhat=getIntent().getStringExtra("BeMy");
        //todo: change to Seek
        SearchVolunteer searchVolunteer=new SearchVolunteer();
        List<Volunteer> volunteerList;
        if(beMyWhat.equals("Mouth")){
            volunteerList=searchVolunteer.getVolunteersForEarsOrMouth();
            
            Intent intent = new Intent(search.this, chooseContactWay.class);
            startActivity(intent);
        }else if(beMyWhat.equals("Ear")){
            volunteerList=searchVolunteer.getVolunteersForEarsOrMouth();
            Intent intent = new Intent(search.this, chooseContactWay.class);
            startActivity(intent);
        }else if(beMyWhat.equals("Leg")){
            volunteerList=searchVolunteer.getVolunteersForLegs("Jerusalem");
            Intent intent = new Intent(search.this, chooseContactWay.class);
            startActivity(intent);
        }else if(beMyWhat.equals("Friend")){
            volunteerList=searchVolunteer.getVolunteersForFriend("Jerusalem");
            Intent intent = new Intent(search.this, chooseContactWay.class);
            startActivity(intent);
        }else{
            System.out.println("beMy");
        }
    }
}
