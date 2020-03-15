package com.OfficeHours;

import java.util.*;

public class JavaMapsOH {


    public static void main(String[] args) {

        HashMap<String, String> user1 = new HashMap<>();

        user1.put("First Name" , null);
        user1.put("Last Name", "Smith");
        user1.put("Account Number", "A633534");
        user1.put("DOB","03,11,2020");

        System.out.println(user1);

        LinkedHashMap<String, String> user2 = new LinkedHashMap<>();
        user2.put("First Name", "Erfan");
        user2.put("Last Name", null);
        user2.put("Last Name","White");
        user2.put("Last Name","Green");
        user2.put("Account Number","A505056");
        user2.put("DOB","12,02,2019");


        System.out.println(user2);


        //combine two HashMaps together
        List<Map<String, String>> users = new ArrayList<>();
        //LinkedHashMap extends HashMap

        users.add(user1);


        HashMap<String, String> user3 = new HashMap<>(user1);
        user3.put("Account NUmber", "A50563432");
        user3.put("DOB", "12,08,1990");

        users.add(user3);

        //print account number for all users along with last name

        for (Map<String, String> user: users) {
            System.out.println("Account Number " +user.get("Account Number") + " | Last Name: " + user.get("Last Name"));
        }
    }
}
