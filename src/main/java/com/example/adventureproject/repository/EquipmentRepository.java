package com.example.adventureproject.repository;

import com.example.adventureproject.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    List<Equipment> findEquipmentByID(String ID);

}
