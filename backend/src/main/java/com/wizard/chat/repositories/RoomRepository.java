package com.wizard.chat.repositories;


import com.wizard.chat.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Transactional
    @Modifying
    @Query (
            value = "INSERT INTO WIZARDS_ROOMS (room_id, wizard_id) VALUES (?1, ?2);",
            nativeQuery = true
    )
    void addWizardToRoom(Long roomId, Long wizardId);
}
