package com.dws.practicaweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/apiJuego")
public class JuegoRESTController {

    @Autowired
    JuegoService service;

    @GetMapping("/")
    public Collection<Juego> getJuegos() {
        return juegos.values();
    }

    @GetMapping("/{idJuego}")
    public ResponseEntity<Juego> getJuego(@PathVariable long idJuego) {

        Juego juego = juegos.get(idJuego);

        if (juego != null) {
            return new ResponseEntity<>(juego, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Juego createJuego(@RequestBody Juego juego) {

        long idJuego = lastId.incrementAndGet();
        juego.setIdJuego(idJuego);
        juegos.put(idJuego, juego);

        return juego;
    }

    @PutMapping("/{idJuego}")
    public ResponseEntity<Juego> updateJuego(@PathVariable long idJuego, @RequestBody Juego newJuego) {

        Juego oldJuego = juegos.get(idJuego);

        if (oldJuego != null) {

            newJuego.setIdJuego(idJuego);
            juegos.put(idJuego, newJuego);

            return new ResponseEntity<>(newJuego, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idJuego}")
    public ResponseEntity<Juego> deleteJuego(@PathVariable long idJuego) {

        Juego juego = juegos.remove(idJuego);

        if (juego != null) {
            return new ResponseEntity<>(juego, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
