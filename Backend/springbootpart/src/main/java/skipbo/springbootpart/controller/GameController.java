package skipbo.springbootpart.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import skipbo.game.gameobjects.AllGames;
import skipbo.springbootpart.dataObjects.GameCreated;
import skipbo.springbootpart.dataObjects.JoinGame;
import skipbo.springbootpart.services.AllGamesService;


@RestController
public class GameController {

    AllGamesService ags = new AllGamesService();

    @PostMapping("/joinGame")
    public GameCreated joinGame(@RequestBody JoinGame joinGame){
        //maybe it makes more sense to join the player later when we get the socket ids as well but will find that out later on.

        return ags.createGame(joinGame.getGameName());
    }
}
