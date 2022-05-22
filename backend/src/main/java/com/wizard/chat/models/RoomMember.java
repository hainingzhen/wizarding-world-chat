package com.wizard.chat.models;


import javax.persistence.*;

@Entity
@Table(name = "wizards_rooms")
public class RoomMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "wizard_id", nullable = false)
    private Wizard wizard;

    @Column(name = "left_room")
    private Boolean leftRoom;

    public RoomMember() {}

    public RoomMember(Long id,
                      Room room,
                      Wizard wizard,
                      Boolean leftRoom) {
        this.id = id;
        this.room = room;
        this.wizard = wizard;
        this.leftRoom = leftRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public Boolean getLeftRoom() {
        return leftRoom;
    }

    public void setLeftRoom(Boolean leftRoom) {
        this.leftRoom = leftRoom;
    }
}
