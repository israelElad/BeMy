package com.example.bemyapp;

import android.annotation.SuppressLint;
import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VolunteerDataBase {
    public VolunteerDataBase(Context context) {
        CreateFile(context);
    }

    @SuppressLint("SimpleDateFormat")
    public Date toDate(String dateStr){
        Date date = null;
        try {
            date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(dateStr);
        }
        catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return date;
    }

    private List<String> parseLine(String line) {
        return Arrays.asList(line.split("\\s*,\\s*"));
    }

    private void CreateFile(Context context) {
        try {
            File f = new File(context.getFilesDir(),"volunteers.txt");
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void WriteToFile(Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("volunteers.txt", Context.MODE_PRIVATE));
            for (int i = 0; i < Info.getInstance().getVolunteersList().size(); i++){
                outputStreamWriter.write(Info.getInstance().getVolunteersList().get(i).toString());
            }
            outputStreamWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private List<String> ReadFromFile(Context context){
        List<String> linesList = new ArrayList<String>();
        String receiveString = "";
        try {
            InputStream inputStream = context.openFileInput("volunteers.txt");
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                receiveString = bufferedReader.readLine();
                if (receiveString != null){
                    linesList.add(receiveString);
                }
                while (receiveString != null) {
                    receiveString = bufferedReader.readLine();
                    if (receiveString != null){
                        linesList.add(receiveString);
                    }
                }
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return linesList;
    }

    public List<Volunteer> loadFromFile(Context context) {
        List<Volunteer> volunteersList = new ArrayList<Volunteer>();
        List<String> linesList = ReadFromFile(context);
        for (int i = 0; i < linesList.size(); i++){
            List<String> line = parseLine(linesList.get(i));
            // availableFor
            Map<String, Boolean> availableFor = new HashMap<>();
            availableFor.put("callOrMessage", Boolean.parseBoolean(line.get(2)));
            availableFor.put("Mission", Boolean.parseBoolean(line.get(3)));
            // availableWhen
            Map<Date, Date> availableWhen = new HashMap<>();
            for (int j = 5; j < line.size(); j+=2){
                availableWhen.put(toDate(line.get(j)), toDate(line.get(j++)));
            }
            volunteersList.add(new Volunteer(line.get(0), line.get(1), availableFor, line.get(4), availableWhen));
        }
        return volunteersList;
    }
}