package skipbo.springbootpart.services;


import org.springframework.stereotype.Service;
import skipbo.game.gameobjects.Game;
import skipbo.springbootpart.dataObjects.GameCreated;

import java.util.HashMap;
import java.util.Map;

@Service
public class AllGamesService {

    Map<String, Game> allGames = new HashMap<>();

    public GameCreated createGame(String roomName){
        if(!allGames.containsKey(roomName)){
            allGames.put(roomName, new Game(roomName));
        }
        return new GameCreated(roomName);
    }



}
