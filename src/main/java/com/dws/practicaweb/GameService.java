package com.dws.practicaweb;

import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameService {
    private Map<Long, Game> games = new ConcurrentHashMap<>();

    public void addGame(long gameId, Game game){
        game.setGameId(gameId);
        this.games.put(gameId, game);
    }

    public Collection<Game> getGames(){
        return this.games.values();
    }

    public Game getGame(long gameId){
        return this.games.get(gameId);
    }

    public Game deleteGame(long gameId){
        Game aux = this.games.get(gameId);
        this.games.remove(gameId);
        return aux;
    }

    public Game updateGame(long gameId, Game gameMod) {     //gameMod refers to the modified game
        Game game = this.games.get(gameId);
        if(gameMod.getName() == null){
            gameMod.setName(game.getName());
        }
        if(gameMod.getRamMin() ==null) {
            gameMod.setRamMin(game.getRamMin());
        }
        if(gameMod.getGraphicCardMin() ==null) {
            gameMod.setGraphicCardMin(game.getGraphicCardMin());
        }

        if(gameMod.getCpuMin()==null){
            gameMod.setCpuMin(game.getCpuMin());
        }
        
        if(gameMod.getRamMax()==null){
            gameMod.setRamMax(game.getRamMax());
        }
        
        if(gameMod.getGraphicCardMax()==null){
            gameMod.setGraphicCardMax(game.getGraphicCardMax());
        }
        
        if(gameMod.getCpuMax()==null){
            gameMod.setCpuMax(game.getCpuMax());
        }
        
        gameMod.setGameId(gameId);
        this.games.put(gameId, gameMod);

        return gameMod;


    }

}