package com.wilbursandwilma.footlocker.model;
import javax.persistence.*;


@Entity
@Table(name = "items")

public class Admin {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "type")
    private String type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Admin (){}

    public Admin(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }
}
