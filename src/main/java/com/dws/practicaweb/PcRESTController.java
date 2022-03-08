package com.dws.practicaweb;

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

    private Map<Long, Pc> pcs = new ConcurrentHashMap<>();
    private AtomicLong lastId = new AtomicLong();



    @GetMapping("/")
    public Collection<Pc> getPcs() {
        return pcs.values();
    }

    @GetMapping("/{idPc}")
    public ResponseEntity<Pc> getPc(@PathVariable long idPc) {

        Pc pc = pcs.get(idPc);

        if (pc != null) {
            return new ResponseEntity<>(pc, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Pc createPc(@RequestBody Pc pc) {

        long idPc = lastId.incrementAndGet();
        pc.setIdPc(idPc);
        pcs.put(idPc, pc);

        return pc;
    }

    @PutMapping("/{idPc}")
    public ResponseEntity<Pc> updatePc(@PathVariable long idPc, @RequestBody Pc newPc) {

        Pc oldPc = pcs.get(idPc);

        if (oldPc != null) {

            newPc.setIdPc(idPc);
            pcs.put(idPc, newPc);

            return new ResponseEntity<>(newPc, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idPc}")
    public ResponseEntity<Pc> deletePc(@PathVariable long idPc) {

        Pc pc = pcs.remove(idPc);

        if (pc != null) {
            return new ResponseEntity<>(pc, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
