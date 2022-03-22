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

    public void updateGame(long gameId, Game gameMod) {
        gameMod.setGameId(gameId);
        games.put(gameId, gameMod);
    }

}
