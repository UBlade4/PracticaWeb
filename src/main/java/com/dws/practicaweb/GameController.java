package com.dws.practicaweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameRepository repository;

    @Autowired
    private GameService service;


    @PostConstruct
    public void init() {
        repository.save(new Game("Red Dead 2", "12", "1080 GTX 4GB", "Intel I5 8va Gen", "16", "2070 RTX 6GB", "Intel I7 9na Gen"));
        repository.save(new Game("Minecraft", "4", "126 MB", "Intel I4 5va Gen", "8", "1070 GTX 4GB", "Intel I5 8va Gen"));
    }

    @GetMapping("/newGame")
    public String newGame(Model model, @RequestParam String name, @RequestParam String ramMin, @RequestParam String graphicCardMin, @RequestParam String cpuMin, @RequestParam String ramMax, @RequestParam String graphicCardMax, @RequestParam String cpuMax){
        Game aux = new Game(name, ramMin, graphicCardMin, cpuMin, ramMax, graphicCardMax, cpuMax);
        repository.save(aux);
        return "gameCreated";
    }

    @GetMapping("/showGames")
    public String showGames(Model model){
        model.addAttribute("games", repository.findAll());
        return "showGames";
    }

    @GetMapping("/{gameId}")
    public String showGame(Model model, @PathVariable long gameId){
        Game game = repository.findById(gameId).get();
        if (repository.findById(gameId).isEmpty()){
          return "error";
        }
        model.addAttribute("game", game);
        return "showGame";
    }

    @GetMapping("/{gameId}/updatedGame")
    public String updatedGame(Model model, @PathVariable long gameId) {
        model.addAttribute("gameId", gameId);
        return "updateGame";
    }

    @GetMapping("/updateGame")
    public String updateGame(Model model,@RequestParam long gameId, @RequestParam String name, @RequestParam String ramMin, @RequestParam String graphicCardMin, @RequestParam String cpuMin, @RequestParam String ramMax, @RequestParam String graphicCardMax, @RequestParam String cpuMax){
        Game aux = new Game(name, ramMin, graphicCardMin, cpuMin, ramMax, graphicCardMax, cpuMax);
        service.updateGame(gameId,aux);
        return "updatedGame";

    }

    @GetMapping ("/deleteGame/{gameId}")
    public String deleteGame(Model model, @PathVariable long gameId){
        model.addAttribute("gameId", gameId);
        Game game =repository.findById(gameId).get();
        repository.delete(game);
        return "/deleteGame";
    }
}