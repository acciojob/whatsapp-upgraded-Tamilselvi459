package com.driver;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private String content;

    private Date timestamp;

    public Message( String content, Date timestamp) {
      //  this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    @ManyToOne
    @JoinColumn
    User user;

    @ManyToOne
    @JoinColumn
    Group group;
}
