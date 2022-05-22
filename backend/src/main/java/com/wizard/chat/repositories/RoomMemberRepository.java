package com.wizard.chat.repositories;

import com.wizard.chat.models.RoomMember;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomMemberRepository extends JpaRepository<RoomMember, Long> {

}
