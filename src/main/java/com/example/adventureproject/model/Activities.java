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

    public Activities(){
}

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMin_age() {
        return min_age;
    }

    public void setMin_age(int min_age) {
        this.min_age = min_age;
    }

    public int getMin_height() {
        return min_height;
    }

    public void setMin_height(int min_height) {
        this.min_height = min_height;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }


}