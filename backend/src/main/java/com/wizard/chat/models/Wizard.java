package com.wizard.chat.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "wizards")
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name = "firstname", nullable = false)
    private String firstname;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    @Column(name = "house", nullable = false)
    private String house;
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @JsonIgnoreProperties({"wizard"})
    @OneToMany(mappedBy = "wizard")
    private List<Message> messages;

    @OneToMany(mappedBy = "room")
    private List<RoomMember> rooms;

    public Wizard() {}

    public Wizard(Long id,
                  String firstname,
                  String lastname,
                  String house,
                  String username,
                  List<Message> messages,
                  List<RoomMember> rooms) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.house = house;
        this.username = username;
        this.messages = messages;
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<RoomMember> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomMember> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", house='" + house + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
