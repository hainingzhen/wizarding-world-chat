package com.wizard.chat.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnoreProperties({"room"})
    @OneToMany(mappedBy = "room")
    private List<Message> messages;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "wizards_rooms",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "wizard_id")
    )
    @JsonIgnoreProperties(value = {"rooms", "messages"})
    private Set<Wizard> wizards;

    public Room() {}

    public Room(Long id,
                String name,
                List<Message> messages,
                Set<Wizard> wizards) {
        this.id = id;
        this.name = name;
        this.messages = messages;
        this.wizards = wizards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Set<Wizard> getWizards() {
        return wizards;
    }

    public void setWizards(Set<Wizard> wizards) {
        this.wizards = wizards;
    }
}
