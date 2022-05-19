package com.wizard.chat.services;

import com.wizard.chat.models.Room;
import com.wizard.chat.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomService() {}

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room addNewRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room addWizardToRoom(Long roomId, Long wizardId) {
        roomRepository.addWizardToRoom(roomId, wizardId);
        return null;
    }
}
