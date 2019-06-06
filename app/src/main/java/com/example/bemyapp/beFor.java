package com.example.bemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class beFor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_for);

    }
public void onContinueClick(View view) {
    EditText editTextName = (EditText) findViewById(R.id.Name);
    String name =  editTextName.getText().toString();
    EditText editTextPhone = (EditText) findViewById(R.id.phone);
    String phoneNumber =editTextPhone.getText().toString();
    //if the user exists
    if(Info.getInstance().isVolunteerExist(phoneNumber)){
        Intent intent=new Intent(beFor.this,update_or_delete.class);
        intent.putExtra("phoneNumber",phoneNumber);
        startActivity(intent);
    }
    //user doesn't exists
    else{
        Intent intent=new Intent(beFor.this,registration_form.class);
       // intent.putExtra("phoneNumber",phoneNumber);
        startActivity(intent);

    }


    }
}
