package com.example.adventureproject.controller;

import com.example.adventureproject.model.Reservation;
import com.example.adventureproject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @PostMapping(value="/reservation", consumes = "application/json")
    public ResponseEntity<Reservation> newTimeSlot(@RequestBody Reservation reservation) {
        System.out.println("reservation:" + reservation);
        reservationRepository.save(reservation);
        System.out.println("Done save reservation=" + reservation);
        return new ResponseEntity<Reservation>(reservation, HttpStatus.CREATED);

    }



}
