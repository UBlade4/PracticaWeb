package com.dws.practicaweb;

import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class JuegoService {
    private Map<Long, Juego> juegos = new ConcurrentHashMap<>();
    private AtomicLong lastId = new AtomicLong();

    public void addJuego(long idJuego, Juego juego){
        juego.setIdJuego(idJuego);
        this.juegos.put(idJuego, juego);
    }

    public Collection<Juego> getJuegos(){
        return this.juegos.values();
    }

    public Juego getJuego(long idJuego){
        return this.juegos.get(idJuego);
    }

    public Juego deleteJuego(long idJuego){
        Juego aux = this.juegos.get(idJuego);
        this.juegos.remove(idJuego);
        return aux;
    }

    public Juego modifyJuego(long idJuego, Juego juegoModificado) {
        Juego juego = this.juegos.get(idJuego);
        if(juegoModificado.getNombre() == null){
            juegoModificado.setNombre(juego.getNombre());
        }
        if(juegoModificado.getRequisitosMin() ==null) {
            juegoModificado.setRequisitosMin(juego.getRequisitosMin());
        }
        if(juegoModificado.getRequisitosMax() ==null) {
            juegoModificado.setRequisitosMax(juego.getRequisitosMax());
        }

        juegoModificado.setIdJuego(idJuego);
        this.juegos.put(idJuego, juegoModificado);

        return juegoModificado;
    }

}
