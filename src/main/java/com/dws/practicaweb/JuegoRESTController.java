package com.dws.practicaweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

    @GetMapping("/juegos")
    public HttpEntity<?> getJuegos() {
        if (service.getJuegos().isEmpty()) {
            return new ResponseEntity<>("No hay juego registrados", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.getJuegos(), HttpStatus.OK);
        }
    }

    @GetMapping("/{idJuego}")
    public ResponseEntity<Juego> getJuego(@PathVariable long idJuego) {

        Juego juego = service.getJuego(idJuego);

        if (juego != null) {
            return new ResponseEntity<>(juego, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Juego createJuego(@RequestBody Juego juego) {
        service.addJuego(juego.getIdJuego(), juego);
        return juego;
    }

    @PutMapping("/{idJuego}")
    public ResponseEntity<Juego> updateJuego(@PathVariable long idJuego, @RequestBody Juego newJuego) {

        Juego oldJuego = service.getJuego(idJuego);

        if (oldJuego != null) {
            service.addJuego(idJuego,newJuego);
            return new ResponseEntity<>(newJuego, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idJuego}")
    public ResponseEntity<Juego> deleteJuego(@PathVariable long idJuego) {

        Juego juego = service.getJuego(idJuego);

        if (juego != null) {
            service.deleteJuego(idJuego);
            return new ResponseEntity<>(juego, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
