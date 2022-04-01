package com.dws.practicaweb;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Game {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gameId;
    private String ramMin;
    private String cpuMin;
    private String graphicCardMin;
    private String ramMax;
    private String cpuMax;
    private String graphicCardMax;

    @ManyToMany
    private List<Pc> pcs;

    public Game(String name, String ramMin, String graphicCardMin, String cpuMin, String ramMax, String graphicCardMax, String cpuMax){
        this.name=name;
        this.ramMin=ramMin;
        this.graphicCardMin=graphicCardMin;
        this.cpuMin=cpuMin;
        this.ramMax=ramMax;
        this.graphicCardMax=graphicCardMax;
        this.cpuMax=cpuMax;
    }

    @Override
    public String toString() {
        return  name + ": Id= " + gameId;
    }
}