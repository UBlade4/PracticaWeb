package com.dws.practicaweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/apiPc")
public class PcRESTController {

    @Autowired
    private PcRepository repositoryPc;
    @Autowired
    private PcService servicePc;

    @GetMapping("/pcs")
    public HttpEntity<?> getPcs() {

        if (repositoryPc.findAll().isEmpty()) {
            return new ResponseEntity<>("No hay juego registrados", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(repositoryPc.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping("/{pcId}")
    public ResponseEntity<Pc> getPc(@PathVariable long pcId) {

        Pc pc = repositoryPc.getById(pcId);

        if ((repositoryPc.findById(pcId).isPresent())) {
            return new ResponseEntity<>(pc, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Pc createPc(@RequestBody Pc pc) {

        repositoryPc.save(pc);
        return pc;
    }

    @PutMapping("/{pcId}")
    public ResponseEntity<Pc> updatedPc(@PathVariable long pcId, @RequestBody Pc newPc) {

        if ((repositoryPc.findById(pcId).isPresent())) {
            servicePc.updatePc(pcId,newPc);
            return new ResponseEntity<>(newPc, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{pcId}")
    public HttpEntity<Pc> deletePc(@PathVariable long pcId) {

        Pc pc = repositoryPc.getById(pcId);

        if (repositoryPc.findById(pcId).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            repositoryPc.delete(pc);
            return new ResponseEntity<>(pc, HttpStatus.OK);
        }
    }
}

