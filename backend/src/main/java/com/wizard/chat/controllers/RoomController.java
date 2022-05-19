package com.wizard.chat.controllers;


import com.wizard.chat.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    public RoomController() {}

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
}
