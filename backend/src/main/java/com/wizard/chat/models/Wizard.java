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
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "house")
    private String house;
    @Column(name = "username")
    private String username;

    @JsonIgnoreProperties({"wizard"})
    @OneToMany(mappedBy = "wizard")
    private List<Message> messages;

    @ManyToMany(mappedBy = "wizards")
    @JsonIgnoreProperties(value = {"wizards"})
    private Set<Room> rooms;

    public Wizard() {}

    public Wizard(Long id,
                  String firstname,
                  String lastname,
                  String house,
                  String username,
                  List<Message> messages,
                  Set<Room> rooms) {
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
