package com.wizard.chat.services;

import com.wizard.chat.models.Room;
import com.wizard.chat.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Room> getRoom(Long id) {
        return roomRepository.findById(id);
    }

    public Room addNewRoom(Room room) {
        return roomRepository.save(room);
    }

    public void addWizardToRoom(Long roomId, Long wizardId) throws DataIntegrityViolationException {
        roomRepository.addWizardToRoom(roomId, wizardId);
    }
}
