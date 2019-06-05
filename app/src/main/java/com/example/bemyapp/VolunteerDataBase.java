package com.example.bemyapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VolunteerDataBase {
    public VolunteerDataBase() {
        CreateFile();
    }

    public List<Volunteer> loadFromFile() {
        List<Volunteer> volunteersList = new ArrayList<Volunteer>();
        List<String> linesList = ReadFromFile();
        for (int i = 0; i < linesList.size(); i++){
            List<String> line = parseLine(linesList.get(i));
            // availableFor
            Map<String, Boolean> availableFor = new HashMap<>();
            availableFor.put("callOrMessage", Boolean.parseBoolean(line.get(2)));
            availableFor.put("Mission", Boolean.parseBoolean(line.get(3)));
            // availableWhen
            Map<Date, Date> availableWhen = new HashMap<>();
            for (int j = 5; i < line.size(); i+=2){
                availableWhen.put(toDate(line.get(i)), toDate(line.get(i++)));
            }
            volunteersList.add(new Volunteer(line.get(0), line.get(1), availableFor, line.get(4), availableWhen));
        }
        return volunteersList;
    }

    private Date toDate(String dateStr){
        Date date = null;
        try {
            Date theSameDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(dateStr);
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

    private void CreateFile() {
        try {
            File myObj = new File("volunteers.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void WriteToFile() {
        try {
            FileWriter myWriter = new FileWriter("volunteers.txt");
            for (int i = 0; i < Info.getInstance().getVolunteersList().size(); i++){
                myWriter.write(Info.getInstance().getVolunteersList().get(i).toString());
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public List<String> ReadFromFile(){
        List<String> linessList = new ArrayList<String>();
        try {
            File myObj = new File("volunteers.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                linessList.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return linessList;
    }
}