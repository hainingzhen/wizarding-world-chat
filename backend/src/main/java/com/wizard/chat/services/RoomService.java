package com.wizard.chat.services;

import com.wizard.chat.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomService() {}

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
}
