package com.dws.practicaweb;

import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GameService {
    private Map<Long, Game> games = new ConcurrentHashMap<>();
    private AtomicLong lastid=new AtomicLong();

    public void addGame(Game game){
        long gameId=lastid.incrementAndGet();
        game.setGameId(gameId);
        games.put(gameId, game);
    }

    public Collection<Game> getGames(){
        return games.values();
    }

    public Game getGame(long gameId){
        return games.get(gameId);
    }

    public void deleteGame(long gameId){
        games.remove(gameId);
    }

    public void updateGame(long gameId, Game gameMod) {     //gameMod refers to the modified game

        if(gameMod.getName() == null){
            gameMod.setName(gameMod.getName());
        }
        if(gameMod.getRamMin() ==null) {
            gameMod.setRamMin(gameMod.getRamMin());
        }
        if(gameMod.getGraphicCardMin() ==null) {
            gameMod.setGraphicCardMin(gameMod.getGraphicCardMin());
        }

        if(gameMod.getCpuMin()==null){
            gameMod.setCpuMin(gameMod.getCpuMin());
        }

        if(gameMod.getRamMax()==null){
            gameMod.setRamMax(gameMod.getRamMax());
        }

        if(gameMod.getGraphicCardMax()==null){
            gameMod.setGraphicCardMax(gameMod.getGraphicCardMax());
        }

        if(gameMod.getCpuMax()==null){
            gameMod.setCpuMax(gameMod.getCpuMax());
        }
        gameMod.setGameId(gameId);
        games.put(gameId, gameMod);
    }

}
