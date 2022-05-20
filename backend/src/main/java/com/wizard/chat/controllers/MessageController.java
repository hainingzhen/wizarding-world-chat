package com.wizard.chat.controllers;


import com.wizard.chat.models.Message;
import com.wizard.chat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    public MessageController() {}

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    // Get all messages
    /*
        endpoint:
            localhost:8080/messages
     */
    @GetMapping(path = "/messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        return ResponseEntity.ok().body(messages);
    }


    // Send a message
    /*
           endpoint:
                localhost:8080/sendMessage?userId=<user_id>&roomId=<room_id>

            JSON:
                {
                    "content": ""
                }
     */
    @PostMapping(
            path = "/sendMessage",
            consumes = "application/json"
    )
    public ResponseEntity<Message> sendMessage(
            @RequestParam(required = true) Long userId,
            @RequestParam(required = true) Long roomId,
            @RequestBody Map<String, String> payload) {

        System.out.println(payload.toString());

        // check if wizard is in that room

        // if so then append message

        // if not return error response

        return ResponseEntity.ok().build();
    }
}
