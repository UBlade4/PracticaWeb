package com.dws.practicaweb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    private long userId;
    private String phoneNumber;
    private String name;
    private String email;
    private boolean admin;

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
