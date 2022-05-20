package com.wizard.chat.controllers;


import com.wizard.chat.models.Room;
import com.wizard.chat.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    public RoomController() {}

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    // Getting all chat rooms available
    /*
        endpoint:
            localhost:8080/rooms
     */
    @GetMapping(path = "/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok().body(rooms);
    }


    // Get a chat room
    /*
        endpoint:
            localhost:8080/rooms/<id>
     */
    @GetMapping(path = "/rooms/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable Long id) {
        Optional<Room> roomOptional = roomService.getRoom(id);

        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            return ResponseEntity.ok().body(room);
        }
        return ResponseEntity.notFound().build();
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
            return ResponseEntity
                    .ok()
                    .body(roomService.getRoom(roomId).get());
        }
        catch (DataIntegrityViolationException dive) {
            return ResponseEntity.badRequest().build();
        }
    }


    // Deleting a room


}
