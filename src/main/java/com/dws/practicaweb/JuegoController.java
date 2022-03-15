package com.dws.practicaweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/juegos")
public class JuegoController {

    @Autowired
    JuegoService service;

    @PostConstruct
    public void init() {
        Juego juego1 = new Juego("Red Dead 2", (new Componentes("12", "1080 GTX 4GB", "Intel I5 8va Gen")), (new Componentes("16", "2070 RTX 6GB", "Intel I7 9na Gen")));
        Juego juego2 = new Juego("Minecraft", (new Componentes("4", "126 MB", "Intel I4 5va Gen")), (new Componentes("8", "1070 GTX 4GB", "Intel I5 8va Gen")));

        service.addJuego(juego1.getIdJuego(), juego1);
        service.addJuego(juego2.getIdJuego(), juego2);
    }

    @GetMapping("/nuevoJuego")
    public String newGame(Model model, @RequestParam String nombre, @RequestParam Componentes requisitosMax, @RequestParam Componentes requisitosMin){
        Juego aux = new Juego(nombre, requisitosMax, requisitosMin);
        service.addJuego(aux.getIdJuego(), aux);
        return "juegoCreado";
    }

    @GetMapping("/mostrarJuegos")
    public String showGames(Model model){
        model.addAttribute("juegos", service.getJuegos());
        return "verJuegos";
    }

    @GetMapping("/{idJuego}")
    public String showGame(Model model, @PathVariable long idJuego){
        model.addAttribute("idJuego", idJuego);
        Juego juego = this.service.getJuego(idJuego);
        if (juego==null){
            return "error";
        }
        model.addAttribute("juego", juego);
        return "verJuego";
    }

    @GetMapping("/{idJuego}/modJuego")
    public String modJuego(Model model, @PathVariable long idJuego) {
        model.addAttribute("idJuego", idJuego);
        return "modJuego";
    }

    @GetMapping("/modificarJuego")
    public String modificarJuego(Model model, @RequestParam String nombre, @RequestParam Componentes requisitosMax, @RequestParam Componentes requisitosMin){
        Juego aux = new Juego(nombre, requisitosMax, requisitosMin);
        service.modifyJuego(aux.getIdJuego(), aux);
        return "modificarJuego";

    }



}