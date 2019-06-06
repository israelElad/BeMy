package com.example.bemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class not_found extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_found);
    }
    public void backClick(View view)
    {
        Intent intent = new Intent(not_found.this, MainActivity.class);
        startActivity(intent);
    }
}
