package com.wizard.chat.controllers;


import com.wizard.chat.models.Room;
import com.wizard.chat.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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


    // Getting all chatrooms available
    /*
        endpoint:
            localhost:8080/rooms
     */
    @GetMapping(path = "/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok().body(rooms);
    }


    // Adding a new room
    /*
        endpoint:
            localhost:8080/addNewRoom

        JSON:
            {
                "name": ""
            }

     */
    @PostMapping(
            path = "/addNewRoom",
            consumes = "application/json"
    )
    public ResponseEntity<Room> addNewRoom(@RequestBody Room room) {
        Room addedRoom = roomService.addNewRoom(room);
        return ResponseEntity.ok().body(addedRoom);
    }


    // Adding a wizard to a chatroom
    /*
        endpoint:
            localhost:8080/wizardToRoom?roomId=<room_id>&wizardId=<wizard_id>
     */
    @PostMapping(path = "/wizardToRoom")
    public ResponseEntity<Room> addWizardToRoom(
            @RequestParam(required = true) Long roomId,
            @RequestParam(required = true) Long wizardId) {
        try {
            roomService.addWizardToRoom(roomId, wizardId);
        }
        catch (DataIntegrityViolationException dive) {
            System.out.println(dive);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }


    // Deleting a room


}
