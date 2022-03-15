package com.dws.practicaweb;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pc {

    private long idPc;
    private String ram;
    private String graphicCard;
    private String cpu;

    @Override
    public String toString() {
        return "El pc tiene estos componentes:" + "Ram= " + ram + "grafica: " + graphicCard + "procesador: " + cpu;
    }
}