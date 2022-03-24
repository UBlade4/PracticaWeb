package com.dws.practicaweb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pc {

    private long pcId;
    private String ram;
    private String graphicCard;
    private String cpu;

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