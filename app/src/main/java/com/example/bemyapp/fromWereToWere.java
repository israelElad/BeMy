package com.example.bemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class fromWereToWere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_were_to_were);
    }

    public void Click(View view)
    {
        String beMyWhat=getIntent().getStringExtra("BeMy");
        EditText editTextName = (EditText) findViewById(R.id.location);
        String location =  editTextName.getText().toString();
        Intent intent = new Intent(fromWereToWere.this, search.class);
        intent.putExtra("BeMy",beMyWhat);
        intent.putExtra("location",location);
        startActivity(intent);
    }
}
