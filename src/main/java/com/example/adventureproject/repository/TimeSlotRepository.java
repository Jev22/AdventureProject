package com.example.adventureproject.repository;

import com.example.adventureproject.model.Activity;
import com.example.adventureproject.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer> {

    List<TimeSlot> findTimeSlotByActivityID(int id);

}
