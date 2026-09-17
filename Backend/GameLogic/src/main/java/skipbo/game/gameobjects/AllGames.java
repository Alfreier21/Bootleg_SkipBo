package skipbo.game.gameobjects;

import java.util.HashMap;
import java.util.Map;

public class AllGames {

    static Map<String, Game> allgames = new HashMap<>();

    public static void joinGame(String gameName, String playerName){
        if(!allgames.containsKey(gameName)){
            allgames.put(gameName, new Game(gameName, new Player(playerName)));
        }else {
            allgames.get(gameName).playerJoin(new Player(playerName));
        }
    }
}
