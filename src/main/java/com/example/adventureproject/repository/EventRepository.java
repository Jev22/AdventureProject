package com.example.adventureproject.repository;

import com.example.adventureproject.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
