package skipbo.game.gameobject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import skipbo.game.gameobjects.Game;
import skipbo.game.gameobjects.Player;

import java.util.List;

public class CurrentPlayerCanMakeTurnTests {

    Game game;

    @Before
    public void setup(){
        Player p1 = new Player("Player1", "ID1");
        Player p2 = new Player("Player2", "ID2");
        game = new Game("Game", p1);
        game.playerJoin(p2);
        game.gameInitialisation();

        p1.getPlayerHand().addAll(List.of(1,2,3,4,5));
        p2.getPlayerHand().addAll(List.of(1,2,3,4,5));
        //to really test it we just need to et the player hands
    }

    @Test
    public void true_playerOneMoveFirst(){
        Assert.assertTrue(game.playerMove("Player1", "H:1", "P:1"));
    }

    @Test
    public void false_playerTwoMoveFirst(){
        Assert.assertFalse(game.playerMove("Player2", "H:1", "P:1"));
    }

    @Test
    public void true_playerOneMoveAfterBeforeMoveDidntEndInReservoir(){
        Assert.assertTrue(game.playerMove("Player1", "H:1", "P:1"));
        Assert.assertTrue(game.playerMove("Player1", "H:2", "P:1"));
    }

    @Test
    public void false_playerOneMoveAfterBeforeMoveEndsInReservoir(){
        Assert.assertTrue(game.playerMove("Player1", "H:1", "R:1"));
        Assert.assertFalse(game.playerMove("Player1", "H:2", "P:1"));
    }

    @Test
    public void false_playerTwoMoveAfterPlayerOneDidntEndInReservoir(){
        Assert.assertTrue(game.playerMove("Player1", "H:1", "P:1"));
        Assert.assertFalse(game.playerMove("Player2", "H:2", "P:1"));
    }

    @Test
    public void true_playerTwoMoveAfterPlayerOneEndInReservoir(){
        Assert.assertTrue(game.playerMove("Player1", "H:1", "R:1"));
        Assert.assertTrue(game.playerMove("Player2", "H:1", "P:1"));
    }


}