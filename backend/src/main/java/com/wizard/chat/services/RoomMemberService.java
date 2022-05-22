package com.wizard.chat.services;

import com.wizard.chat.repositories.RoomMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomMemberService {

    @Autowired
    private RoomMemberRepository roomMemberRepository;

    public RoomMemberService() {}

    public RoomMemberService(RoomMemberRepository roomMemberRepository) {
        this.roomMemberRepository = roomMemberRepository;
    }

}
