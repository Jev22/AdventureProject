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
@CrossOrigin("*")
public class ActivityController {

    @Autowired
    ActivityRepository activityRepository;

    @PostMapping(value="/activity", consumes = "application/json")
    public ResponseEntity<Activity> newActivity(@RequestBody Activity activity){
        System.out.println("Aktivitet: " + activity);
        activityRepository.save(activity);
        return new ResponseEntity<Activity>(activity, HttpStatus.CREATED);
    }

    //Henter liste med alle activities
    @GetMapping("/activity")
    public List<Activity> allActivity() {
        return activityRepository.findAll();
    }

    @GetMapping("/activity/{activityID}")
    public Activity getActivity(@PathVariable int activityID) {
        Optional<Activity> obj = activityRepository.findById(activityID);
        if (obj.isPresent()) {
            return obj.get();
        }
        Activity activity = new Activity();
        activity.setName("Not Found");
        return activity;
    }

    @DeleteMapping("activity/{activityID}")
    public ResponseEntity<Object> deleteActivity (@PathVariable int activityID) {
        try {
            activityRepository.deleteById(activityID);
        } catch (Exception err) {
            return new ResponseEntity<>("Aktivitet ikke fundet", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/activity/{activityID}")
    public ResponseEntity<Activity> updateActivity(@PathVariable int activityID, @RequestBody Activity activity) {
        System.out.println(activityID);
        Optional<Activity> activityData = activityRepository.findById(activityID);
        if (activityData.isPresent()) {
            Activity activity1 = activityData.get();
            activity1.setName(activity.getName());
            activity1.setMin_age(activity.getMin_age());
            activity1.setMin_height(activity.getMin_height());
            activity1.setPrice(activity.getPrice());
            activity1.setParticipants(activity.getParticipants());
            activity1 = activityRepository.save(activity1);
            return new ResponseEntity<>(activity1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
