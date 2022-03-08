package com.dws.practicaweb;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Juego {

    private String nombre;
    private long idJuego;
    private Componentes requisitosMax;
    private Componentes requisitosMin;

    public Juego(String nombre, Componentes requisitosMin, Componentes requisitosMax){
        this.nombre=nombre;
        this.requisitosMax=requisitosMin;
        this.requisitosMin=requisitosMax;
    }

    @Override
    public String toString() {
        return "El juego " + nombre + "Tiene estos requsitos minimos:" + requisitosMin + "Y estos requisitos recomendados: " + requisitosMax;
    }
}