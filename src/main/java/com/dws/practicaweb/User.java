package com.dws.practicaweb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String phoneNumber;
    private String name;
    private String email;
    private boolean admin;

    @ManyToOne
    private Pc pc;

    public User(String name, String email, String phoneNumber, boolean admin) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.admin = admin;
    }

    @Override
    public String toString() {
        return name;
    }

}
