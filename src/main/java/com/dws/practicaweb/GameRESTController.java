package com.dws.practicaweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiGame")
public class GameRESTController {

    @Autowired
    private GameService service;

    @GetMapping("/games")
    public HttpEntity<?> getGames() {

        if (service.getGames().isEmpty()) {
            return new ResponseEntity<>("No hay juego registrados", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.getGames(), HttpStatus.OK);
        }
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable long gameId) {

        Game game = service.getGame(gameId);

        if ((service.getGame(gameId)==null)) {
            return new ResponseEntity<>(game, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody Game game) {

        service.addGame(game);
        return game;
    }

    @PutMapping("/{gameId}")
    public ResponseEntity<Game> updatedGame(@PathVariable long gameId, @RequestBody Game newGame) {

        if ((service.getGame(gameId)==null)) {
            service.updateGame(gameId,newGame);
            return new ResponseEntity<>(newGame, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{gameId}")
    public HttpEntity<Game> deleteGame(@PathVariable long gameId) {

        Game game = service.getGame(gameId);

        if (game==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            service.deleteGame(gameId);
            return new ResponseEntity<>(game, HttpStatus.OK);
        }
    }
}

