package com.example.adventureproject.controller;

import com.example.adventureproject.model.Equipment;
import com.example.adventureproject.model.Event;
import com.example.adventureproject.model.TimeSlot;
import com.example.adventureproject.repository.EquipmentRepository;
import com.example.adventureproject.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TimeSlotController {


    @Autowired
    TimeSlotRepository timeSlotRepository;

    @PostMapping(value="/timeSlot", consumes = "application/json")
    public ResponseEntity<TimeSlot> newTimeSlot(@RequestBody TimeSlot timeSlot) {
        System.out.println("Udstyr:" + timeSlot);
        timeSlotRepository.save(timeSlot);
        System.out.println("Done save timeslot=" + timeSlot);
        return new ResponseEntity<TimeSlot>(timeSlot, HttpStatus.CREATED);

    }

    @GetMapping("/timeSlot")
    public List<TimeSlot> allTimeSlot() {
        return timeSlotRepository.findAll();
    }

    @GetMapping("/findTimeSlotByActivityID/{activityID}")
    public List<TimeSlot> findTimeslotByActivityID(@PathVariable int activityID ) {
        return timeSlotRepository.findTimeSlotByActivityID(activityID);
    }

    @DeleteMapping("timeSlot/{timeSlotID}")
    public ResponseEntity<Object> deleteTimeSlot(@PathVariable int timeSlotID) {
        System.out.println("Delete kaldt timeSlot Kode = " + timeSlotID);
        try {
            timeSlotRepository.deleteById(timeSlotID);
        } catch (Exception err) {
            return new ResponseEntity<>("TimeSlot ikke fundet", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
