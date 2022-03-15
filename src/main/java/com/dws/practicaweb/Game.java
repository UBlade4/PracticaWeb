package com.dws.practicaweb;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Game {

    private String name;
    private long gameId;
    private String ramMin;
    private String cpuMin;
    private String graphicCardMin;
    private String ramMax;
    private String cpuMax;
    private String graphicCardMax;

    public Game(String name, String ramMin, String graphicCardMin, String cpuMin, String ramMax, String graphicCardMax, String cpuMax){
        this.name=name;
        this.ramMin=ramMin;
        this.graphicCardMin=graphicCardMin;
        this.cpuMin=cpuMin;
        this.ramMax=ramMax;
        this.graphicCardMax=graphicCardMax;
        this.cpuMax=cpuMax;
        gameId=0;
    }

    @Override
    public String toString() {
        return "El juego " + name + "Tiene estos requsitos minimos:" + "Ram= " + ramMin + "grafica: " + graphicCardMin + "procesador: " + cpuMin + "Y estos requisitos recomendados: " + "Ram= " + ramMax + "grafica: " + graphicCardMax + "procesador: " + cpuMax;
    }
}