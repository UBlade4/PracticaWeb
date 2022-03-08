package com.dws.practicaweb;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pc {

    private long idPc;
    private Componentes componentes;

    public Pc(Componentes componentes){
        this.componentes=componentes;
    }

    @Override
    public String toString() {
        return "El pc tiene estos componentes:" + componentes;
    }
}