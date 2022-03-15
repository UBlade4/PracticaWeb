package com.dws.practicaweb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuarios {

    private long userId;
    private String phoneNumber;
    private String name;
    private String email;
    private boolean admin;
}
