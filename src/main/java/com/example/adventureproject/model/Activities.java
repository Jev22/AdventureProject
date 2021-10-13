package com.example.adventureproject.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Activities {

    @Id
    private int activityID;
    private String name;
    private int price;
    private int min_age;
    private int min_height;
    private int participants;

}
