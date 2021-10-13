package com.example.adventureproject.repository;

import com.example.adventureproject.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

        List<Activity> findActivitiesByActivities(String Activities);
}


/*
public interface KommuneRepository extends JpaRepository<Kommune, Integer> {

    List<Kommune> findKommuneByRegionKode(String regionKode);

    List<Kommune> findKommuneByKommune(String kommune);

}
*/