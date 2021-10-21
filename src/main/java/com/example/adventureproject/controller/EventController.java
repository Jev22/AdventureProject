package com.example.adventureproject.controller;

import com.example.adventureproject.model.Event;
import com.example.adventureproject.model.Reservation;
import com.example.adventureproject.repository.EventRepository;
import com.example.adventureproject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @PostMapping(value="/event", consumes = "application/json")
    public ResponseEntity<Event> newTimeSlot(@RequestBody Event event) {
        System.out.println("reservation:" + event);
        eventRepository.save(event);
        System.out.println("Done save event=" + event);
        return new ResponseEntity<Event>(event, HttpStatus.CREATED);
    }


}
