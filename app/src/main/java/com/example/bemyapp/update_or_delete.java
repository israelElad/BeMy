package com.example.bemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class update_or_delete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_or_delete);
    }

    public void updateClick(View view)
    {
        Intent intent = new Intent(update_or_delete.this, registration_form.class);
        startActivity(intent);
    }
    public void deleteClick(View view)
    {
        Intent intent = new Intent(update_or_delete.this, delete.class);
        startActivity(intent);
    }
}
