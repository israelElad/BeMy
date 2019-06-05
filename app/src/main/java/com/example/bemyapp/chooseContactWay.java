package com.example.bemyapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class chooseContactWay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_contact_way);
    }

    public void initiateCall(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + "0500000000"));//change the number.
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE}, 0);
        }
        else {
            startService(callIntent);
        }
    }

    public void initiateSMS(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "0544444444"));
        intent.putExtra("sms_body", "Can you please help me?");
        startActivity(intent);
    }
}
