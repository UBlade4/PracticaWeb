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
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameService service;

    @PostConstruct
    public void init() {
        Game game1 = new Game("Red Dead 2", "12", "1080 GTX 4GB", "Intel I5 8va Gen", "16", "2070 RTX 6GB", "Intel I7 9na Gen");
        Game game2 = new Game("Minecraft", "4", "126 MB", "Intel I4 5va Gen", "8", "1070 GTX 4GB", "Intel I5 8va Gen");

        service.addGame(game1.getGameId(), game1);
        service.addGame(game2.getGameId(), game2);
    }

    @GetMapping("/newGame")
    public String newGame(Model model, @RequestParam String name, @RequestParam String ramMin, @RequestParam String graphicCardMin, @RequestParam String cpuMin, @RequestParam String ramMax, @RequestParam String graphicCardMax, @RequestParam String cpuMax){
        Game aux = new Game(name, ramMin, graphicCardMin, cpuMin, ramMax, graphicCardMax, cpuMax);
        service.addGame(aux.getGameId(), aux);
        return "gameCreated";
    }

    @GetMapping("/showGamess")
    public String showGames(Model model){
        model.addAttribute("games", service.getGames());
        return "showGames";
    }

    @GetMapping("/{gameId}")
    public String showGame(Model model, @PathVariable long gameId){
        model.addAttribute("gameId", gameId);
        Game game = this.service.getGame(gameId);
        if (game==null){
            return "error";
        }
        model.addAttribute("game", game);
        return "showGame";
    }

    @GetMapping("/{gameId}/updatedGame")
    public String updatedGame(Model model, @PathVariable long gameId) {
        model.addAttribute("gameId", gameId);
        return "updatedGame";
    }

    @GetMapping("/updateGame")
    public String updateGame(Model model, @RequestParam String name, @RequestParam String ramMin, @RequestParam String graphicCardMin, @RequestParam String cpuMin, @RequestParam String ramMax, @RequestParam String graphicCardMax, @RequestParam String cpuMax){
        Game aux = new Game(name, ramMin, graphicCardMin, cpuMin, ramMax, graphicCardMax, cpuMax);
        service.updateGame(aux.getGameId(), aux);
        return "updateGame";

    }
}