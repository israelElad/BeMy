package com.example.bemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class registration_form extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
    }

    public void onSubmitClick(View view){
        VolunteerDataBase volunteerDataBase = new VolunteerDataBase(this);
        EditText editTextName = (EditText) findViewById(R.id.editText);
        String name =  editTextName.getText().toString();
        EditText editTextphone= (EditText) findViewById(R.id.editText3);
        String phone =  editTextphone.getText().toString();
        RadioButton call=findViewById(R.id.radioButton);
        boolean callAndMessage=call.isChecked();
        RadioButton err=findViewById(R.id.radioButton2);
        boolean errand=err.isChecked();
        EditText editTextLocation= (EditText) findViewById(R.id.editText4);
        String location =  editTextLocation.getText().toString();
        //"Thu Sep 28 20:29:30 JST 2000";
        Map<String,Boolean> availableFor =new TreeMap<String,Boolean>();
        availableFor.put("callOrMessage",callAndMessage);
        availableFor.put("Mission",errand);

    Map<Date, Date> availableWhen = new HashMap<>();
    availableWhen.put(volunteerDataBase.toDate("Thu Jun 06 01:26:00 GMT 2019"), volunteerDataBase.toDate("Thu Jun 06 10:40:00 GMT 2019"));
    availableWhen.put(volunteerDataBase.toDate("Thu Jun 07 01:26:00 GMT 2019"), volunteerDataBase.toDate("Thu Jun 07 10:40:00 GMT 2019"));
    availableWhen.put(volunteerDataBase.toDate("Thu Jun 08 01:26:00 GMT 2019"), volunteerDataBase.toDate("Thu Jun 08 10:40:00 GMT 2019"));
    Volunteer volunteer=new Volunteer(name,phone,availableFor,location,availableWhen);
    Info.getInstance().addVolunteer(volunteer);
    Intent intent=new Intent(registration_form.this , register.class);
    startActivity(intent);


    }

    public String viewToString(View view){
        EditText editText = (EditText) view;
        return ""+editText.getText().toString();
    }

}
