//package com.wizard.chat.models;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.persistence.Table;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class RoomMemberKey implements Serializable {
//
//    @Column(name = "room_id")
//    Long roomId;
//    @Column(name = "wizard_id")
//    Long wizardId;
//
//    public RoomMemberKey() {}
//
//    public RoomMemberKey(Long roomId,
//                         Long wizardId) {
//        this.roomId = roomId;
//        this.wizardId = wizardId;
//    }
//
//    public Long getRoomId() {
//        return roomId;
//    }
//
//    public void setRoomId(Long roomId) {
//        this.roomId = roomId;
//    }
//
//    public Long getWizardId() {
//        return wizardId;
//    }
//
//    public void setWizardId(Long wizardId) {
//        this.wizardId = wizardId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        RoomMemberKey that = (RoomMemberKey) o;
//        return roomId.equals(that.roomId) && wizardId.equals(that.wizardId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(roomId, wizardId);
//    }
//}
