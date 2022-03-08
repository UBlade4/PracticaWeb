package com.dws.practicaweb;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Juego {

    private String nombre;
    private long idJuego;
    private Componentes requisitos;

    public Juego(String nombre, Componentes requisitos){
        this.nombre=nombre;
        this.requisitos=requisitos;
    }

    @Override
    public String toString() {
        return "El juego " + nombre + "Tiene estos requsitos:" + requisitos;
    }
}