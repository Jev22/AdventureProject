package com.example.adventureproject.controller;

import com.example.adventureproject.model.Reservation;
import com.example.adventureproject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/reservation")
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/reservation/{reservationID}")
    public Reservation getReservation(@PathVariable int reservationID) {
        Optional<Reservation> obj = reservationRepository.findById(reservationID);
        if (obj.isPresent()) {
            return obj.get();
        }
        Reservation reservation = new Reservation();
        reservation.setName("Not Found");
        return reservation;
    }

    @PostMapping(value="/reservation", consumes = "application/json")
    public ResponseEntity<Reservation> newTimeSlot(@RequestBody Reservation reservation) {
        System.out.println("reservation:" + reservation);
        reservationRepository.save(reservation);
        System.out.println("Done save reservation=" + reservation);
        return new ResponseEntity<Reservation>(reservation, HttpStatus.CREATED);
    }



}
