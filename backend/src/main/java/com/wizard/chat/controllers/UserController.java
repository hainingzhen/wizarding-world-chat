package com.wizard.chat.controllers;


import com.wizard.chat.models.Houses;
import com.wizard.chat.models.Wizard;
import com.wizard.chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/wizards/{id}")
    public ResponseEntity<Wizard> getWizard(@PathVariable Long id) {
        Optional<Wizard> wizardOptional = userService.getWizard(id);

        if (wizardOptional.isPresent()) {
            Wizard wizard = wizardOptional.get();
            return ResponseEntity.ok().body(wizard);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(
            value = "/addNewWizard",
            consumes = "application/json"
    )
    public ResponseEntity<Wizard> addNewWizard(@RequestBody Wizard wizard) {

        System.out.println(wizard.toString());

        userService.addNewWizard(wizard);

        return ResponseEntity.ok().build();
    }
}
