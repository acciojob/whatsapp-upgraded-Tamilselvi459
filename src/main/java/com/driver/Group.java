package com.driver;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group_table")
public class Group {
    public Group(int id, String name, int numberOfParticipants) {
        this.id = id;
        this.name = name;
        this.numberOfParticipants = numberOfParticipants;
    }

    public Group() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int numberOfParticipants;


    public Group(String name, int numberOfParticipants) {
        this.name = name;
        this.numberOfParticipants = numberOfParticipants;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }
    @OneToMany(mappedBy = "group" , cascade = CascadeType.ALL)
    List<User> userList = new ArrayList<>();

    @OneToMany(mappedBy = "group" , cascade = CascadeType.ALL)
    List<Message> messageList = new ArrayList<>();
}
