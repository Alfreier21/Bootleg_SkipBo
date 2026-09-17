package skipbo.springbootpart.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import skipbo.game.gameobjects.AllGames;
import skipbo.springbootpart.dataObjects.JoinGame;


@RestController
public class GameController {

    @PostMapping("/joinGame")
    public String joinGame(@RequestBody JoinGame joinGame){
        //maybe it makes more sense to join the player later when we get the socket ids as well but will find that out later on.
        AllGames.joinGame(joinGame.getGameName(), joinGame.getPlayerName());
        return "successfully created game";
    }
}
