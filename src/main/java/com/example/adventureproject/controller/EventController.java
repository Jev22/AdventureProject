package com.example.adventureproject.controller;

import com.example.adventureproject.model.Event;
import com.example.adventureproject.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @PostMapping(value="/event", consumes = "application/json")
    public ResponseEntity<Event> newEvents(@RequestBody Event event) {
        System.out.println("event:" + event);
        eventRepository.save(event);
        System.out.println("Done save event=" + event);
        return new ResponseEntity<Event>(event, HttpStatus.CREATED);
    }

    @GetMapping("/event")
    public List<Event> allEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/findEventByName/{eventActivity}")
    public List<Event> findEventByName(@PathVariable String eventActivity ) {
        return eventRepository.findEventByEventActivity(eventActivity);
    }


}
