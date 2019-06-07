package com.example.bemyapp;

import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
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
            if (volunteerList != null) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel1")
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("Someone is looking for you")
                        .setContentText("press OK to continue")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("press OK to continue"))
                        .setPriority(NotificationCompat.PRIORITY_HIGH);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
                notificationManager.notify(1, builder.build());
                Intent intent = new Intent(search.this, conect.class);
                intent.putExtra("name",volunteerList.get(0).getName());
                intent.putExtra("phone",volunteerList.get(0).getPhoneNumber());
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(search.this, not_found.class);
                startActivity(intent);}
        }else if(beMyWhat.equals("Ear")){
            volunteerList=searchVolunteer.getVolunteersForEarsOrMouth();
            if (volunteerList != null) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel1")
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("Someone is looking for you")
                        .setContentText("press OK to continue")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("press OK to continue"))
                        .setPriority(NotificationCompat.PRIORITY_HIGH);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
                notificationManager.notify(1, builder.build());
                Intent intent = new Intent(search.this, conect.class);
                intent.putExtra("name",volunteerList.get(0).getName());
                intent.putExtra("phone",volunteerList.get(0).getPhoneNumber());
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(search.this, not_found.class);
                startActivity(intent);}
        }else if(beMyWhat.equals("Leg")){
            String location =getIntent().getStringExtra("location");
            volunteerList=searchVolunteer.getVolunteersForLegs(location);
            if (volunteerList != null) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel1")
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("Someone is looking for you")
                        .setContentText("press OK to continue")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("press OK to continue"))
                        .setPriority(NotificationCompat.PRIORITY_HIGH);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
                notificationManager.notify(1, builder.build());
                Intent intent = new Intent(search.this, chooseContactWay.class);
                intent.putExtra("name",volunteerList.get(0).getName());
                intent.putExtra("phone",volunteerList.get(0).getPhoneNumber());
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(search.this, not_found.class);
                startActivity(intent);}
        }else if(beMyWhat.equals("Friend")){
            String location =getIntent().getStringExtra("location");
            volunteerList=searchVolunteer.getVolunteersForFriend(location);
            if (volunteerList != null) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel1")
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("Someone is looking for you")
                        .setContentText("press OK to continue")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("press OK to continue"))
                        .setPriority(NotificationCompat.PRIORITY_HIGH);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
                notificationManager.notify(1, builder.build());
                Intent intent = new Intent(search.this, chooseContactWay.class);
                intent.putExtra("name",volunteerList.get(0).getName());
                intent.putExtra("phone",volunteerList.get(0).getPhoneNumber());
                startActivity(intent);
            }else {
            Intent intent = new Intent(search.this, not_found.class);
            startActivity(intent);}
        }else{
            System.out.println("beMy");
        }
    }
}
