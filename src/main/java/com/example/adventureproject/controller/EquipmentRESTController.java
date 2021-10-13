package com.example.adventureproject.controller;

import com.example.adventureproject.model.Equipment;
import com.example.adventureproject.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
public class EquipmentRESTController {

    @Autowired
    EquipmentRepository equipmentRepository;

    @PostMapping(value="/equipment", consumes = "application/json")
    public ResponseEntity<Equipment> newEquipment(@RequestBody Equipment equipment) {
        System.out.println("Udstyr:" + equipment);
        equipmentRepository.save(equipment);
        System.out.println("Done save equipment=" + equipment);
        return new ResponseEntity<Equipment>(equipment, HttpStatus.CREATED);
    }


}
