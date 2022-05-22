package com.wizard.chat.controllers;

import com.wizard.chat.services.RoomMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomMemberController {

    @Autowired
    private RoomMemberService roomMemberService;

    public RoomMemberController() {}

    public RoomMemberController(RoomMemberService roomMemberService) {
        this.roomMemberService = roomMemberService;
    }


}
