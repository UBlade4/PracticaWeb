package com.dws.practicaweb;

import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class JuegoController {

    @PostConstruct
    public void init() {
        Juego juego1 = new Juego("Red Dead 2", (new Componentes(12, "1080 GTX 4GB", "Intel I5 8va Gen")), (new Componentes(16, "2070 RTX 6GB", "Intel I7 9na Gen")));
        Juego juego2 = new Juego("Minecraft", (new Componentes(4, "126 MB", "Intel I4 5va Gen")), (new Componentes(8, "1070 GTX 4GB", "Intel I5 8va Gen")));

    }
}
