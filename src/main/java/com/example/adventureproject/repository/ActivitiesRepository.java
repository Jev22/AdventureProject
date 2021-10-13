package com.example.adventureproject.repository;

import com.example.adventureproject.model.Activities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivitiesRepository extends JpaRepository<Activities, Integer> {

        List<Activities> findActivitiesByActivities(String Activities);
}


/*
public interface KommuneRepository extends JpaRepository<Kommune, Integer> {

    List<Kommune> findKommuneByRegionKode(String regionKode);

    List<Kommune> findKommuneByKommune(String kommune);

}
*/