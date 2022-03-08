package com.dws.practicaweb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuarios {

    private long idUsuario;
    private String telefono;
    private String nombre;
    private String correo;
    private boolean administrador;
}
