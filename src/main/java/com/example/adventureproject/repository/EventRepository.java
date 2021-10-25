package com.example.adventureproject.repository;

import com.example.adventureproject.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

        List<Event> findEventByActivityID(int activityID);



}
