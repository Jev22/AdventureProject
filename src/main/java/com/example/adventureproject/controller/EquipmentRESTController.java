package com.example.adventureproject.controller;

import com.example.adventureproject.model.Equipment;
import com.example.adventureproject.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(value = "*")
@CrossOrigin("*")
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


    @GetMapping("/equipment")
    public List<Equipment> allEquipments() {
        return equipmentRepository.findAll();
    }

    @GetMapping("/equipment/{id}")
    public Equipment getEquipment(@PathVariable int id) {
        Optional<Equipment> obj = equipmentRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        }
        Equipment equipment = new Equipment();
        equipment.setActivity("Not Found");
        return equipment;
    }

    @GetMapping("equipmentDelete/{id}")
    public ResponseEntity<Object> deleteEquipment(@PathVariable int id) {
        System.out.println("Delete kaldt: ID=" + id);
        try {
            equipmentRepository.deleteById(id);
        } catch (Exception err) {
            return new ResponseEntity<>("Udstyr ikke fundet", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/equipment/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable int id, @RequestBody Equipment equipment) {
        System.out.println(id);
        Optional<Equipment> equipmentData = equipmentRepository.findById(id);
        if (equipmentData.isPresent()) {
            Equipment _equipment = equipmentData.get();
            _equipment.setActivity(equipment.getActivity()); //Denne linje opdaterer aktivitetsnavnet
            _equipment = equipmentRepository.save(_equipment);
            return new ResponseEntity<>(_equipment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
