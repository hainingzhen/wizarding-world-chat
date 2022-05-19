package com.wizard.chat.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "datetime")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "wizard_id", nullable = false)
    private Wizard wizard;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public Message() {}

    public Message(Long id,
                   String content,
                   LocalDateTime dateTime,
                   Wizard wizard,
                   Room room) {
        this.id = id;
        this.content = content;
        this.dateTime = dateTime;
        this.wizard = wizard;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
