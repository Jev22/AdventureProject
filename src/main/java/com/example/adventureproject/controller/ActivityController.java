package com.example.adventureproject.controller;

import com.example.adventureproject.model.Activity;
import com.example.adventureproject.repository.ActivityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
public class ActivityController {

    @Autowired
    ActivityRepository activityRepository;

    @PostMapping(value="/activity", consumes = "application/json")

    //Henter liste med alle activities
    @GetMapping("/activity")
    public List<Activity> allActivity() {
        return activityRepository.findAll();
    }

    @GetMapping("/activity/{id}")
    public Activity getActivity(@PathVariable int id) {
        Optional<Activity> obj = activityRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        }
        Activity activity = new Activity();
        activity.setName("Not Found");
        return activity;
    }


    @DeleteMapping("activity/{id}")
    public ResponseEntity<Object> deleteActivity (@PathVariable int id) {
        try {
            activityRepository.deleteById(id);
        } catch (Exception err) {
            return new ResponseEntity<>("Kommune ikke fundet", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
