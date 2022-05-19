package com.wizard.chat.controllers;

import com.wizard.chat.models.Houses;
import com.wizard.chat.models.Wizard;
import com.wizard.chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {}

    public UserController(UserService userService) {
        this.userService = userService;
    }



    // Get all wizards or get wizards by their house
    /*
        endpoint:
            localhost:8080/wizards
            localhost:8080/wizards?house=<house name>
     */
    @GetMapping("/wizards")
    public ResponseEntity<List<Wizard>> getAllWizards(
            @RequestParam(required = false, defaultValue = "") String house) {

        String noWhitespace = house.trim();

        if (noWhitespace.length() == 0) {
            List<Wizard> wizards = userService.getAllWizards();
            return ResponseEntity.ok().body(wizards);
        }

        try {
            Houses houses = Houses.valueOf(noWhitespace.toUpperCase());
            List<Wizard> wizards = userService.findWizardsByHouse(houses.getHouseName());
            return ResponseEntity.ok().body(wizards);
        }
        catch (IllegalArgumentException iae) {
            return ResponseEntity.notFound().build();
        }
    }


    // Get a single wizard by its ID
    /*
        endpoint:
            localhost:8080/<id>
     */
    @GetMapping("/wizards/{id}")
    public ResponseEntity<Wizard> getWizard(@PathVariable Long id) {
        Optional<Wizard> wizardOptional = userService.getWizard(id);

        if (wizardOptional.isPresent()) {
            Wizard wizard = wizardOptional.get();
            return ResponseEntity.ok().body(wizard);
        }
        return ResponseEntity.notFound().build();
    }


    // Adding one new wizard
    /*

        endpoint:
            localhost:8080/addNewWizard

        JSON:
            {
                "firstname": "",
                "lastname": "",
                "house": "",
                "username": ""
            }

     */
    @PostMapping(
            value = "/addNewWizard",
            consumes = "application/json"
    )
    public ResponseEntity<Wizard> addNewWizard(@RequestBody Wizard wizard) {

        Wizard addedWizard;

        try {
            addedWizard = userService.addNewWizard(wizard);
        }
        catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(addedWizard);
    }



    // Delete a wizard



}
