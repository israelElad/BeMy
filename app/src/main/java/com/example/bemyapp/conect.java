package com.example.bemyapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class conect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name =getIntent().getStringExtra("name");
        String phone =getIntent().getStringExtra("phone");
        setContentView(R.layout.activity_conect);
        TextView tvName = (TextView)findViewById(R.id.name);
        tvName.setText(name);
        TextView tvPhone = (TextView)findViewById(R.id.phone);
        tvPhone.setText(phone);
    }

    public void initiateCall(View view) {
        String phone =getIntent().getStringExtra("phone");
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phone));//change the number.
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(conect.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(conect.this,
                    new String[]{Manifest.permission.CALL_PHONE}, 0);
        }
        else {
            startActivity(callIntent);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phone));
            intent.putExtra("sms_body", "Can you please help me?");
            startActivity(intent);
        }
    }
    public void backClick(View view)
    {
        //String phone =getIntent().getStringExtra("phone");

        Intent intent = new Intent(conect.this, MainActivity.class);
        startActivity(intent);
    }
}
