package com.dws.practicaweb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pcId;
    private String ram;
    private String graphicCard;
    private String cpu;

    @ManyToMany
    private List<Game> games;

    @OneToMany(mappedBy = "pc")
    private List<User> users;


    public Pc(String ram, String graphicCard, String cpu) {
        this.ram=ram;
        this.graphicCard=graphicCard;
        this.cpu=cpu;
    }

    @Override
    public String toString() {
        return "Pc:"+pcId;
    }
}