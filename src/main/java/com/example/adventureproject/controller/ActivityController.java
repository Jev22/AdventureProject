package com.example.adventureproject.controller;

import com.example.adventureproject.model.Activity;
import com.example.adventureproject.repository.ActivityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
public class ActivityController {

    @Autowired
    ActivityRepository activitiesRepository;

    @PostMapping(value="/activity", consumes = "application/json")
    public ResponseEntity<Activity> newActivity(@RequestBody Activity activity){

    }




    @DeleteMapping("activity/{id}")
    public ResponseEntity<Object> deleteActivity (@PathVariable int id) {
        try {
            activitiesRepository.deleteById(id);
        } catch (Exception err) {
            return new ResponseEntity<>("Kommune ikke fundet", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
