package com.example.bemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        String beMyWhat=getIntent().getStringExtra("BeMy");
        //todo: change to Seek
        if(beMyWhat.equals("Mouth")){
            Intent intent = new Intent(search.this, chooseContactWay.class);
            startActivity(intent);
        }else if(beMyWhat.equals("Ear")){
            Intent intent = new Intent(search.this, chooseContactWay.class);
            startActivity(intent);
        }else if(beMyWhat.equals("Leg")){
            Intent intent = new Intent(search.this, chooseContactWay.class);
            startActivity(intent);
        }else if(beMyWhat.equals("Friend")){
            Intent intent = new Intent(search.this, chooseContactWay.class);
            startActivity(intent);
        }else{
            System.out.println("beMy");
        }
    }
}
