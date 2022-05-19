package com.wizard.chat.controllers;


import com.wizard.chat.models.Room;
import com.wizard.chat.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    public RoomController() {}

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok().body(rooms);
    }

    @PostMapping(
            path = "/addNewRoom",
            consumes = "application/json"
    )
    public ResponseEntity<Room> addNewRoom(@RequestBody Room room) {
        Room addedRoom = roomService.addNewRoom(room);
        return ResponseEntity.ok().body(addedRoom);
    }

    @PostMapping(path = "/wizardToRoom")
    public ResponseEntity<Room> addWizardToRoom(
            @RequestParam(required = true) Long roomId,
            @RequestParam(required = true) Long wizardId) {
        roomService.addWizardToRoom(roomId, wizardId);
        return ResponseEntity.ok().build();
    }
}
