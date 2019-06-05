package com.example.bemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class beMyChoose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_my_choose);
    }

    public void beMyFriendClick(View view)
    {
        Intent intent = new Intent(beMyChoose.this, chooseContactWay.class);
        startActivity(intent);
    }

}
