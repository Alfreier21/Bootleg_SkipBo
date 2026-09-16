package skipbo.game.gameobject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import skipbo.game.gameobjects.Game;
import skipbo.game.gameobjects.PlayAreaCard;
import skipbo.game.gameobjects.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidCardMovementTests {
    //one player is enough. Can check all of them using one player
    Player p1;
    Game game;

    @Before
    public void setup(){
        p1 = new Player("Player1", "Id1");
        Stack<Integer> p1Stack = new Stack<>();
        p1Stack.addAll(List.of(9,2,4,7,1));
        p1.setStack(p1Stack);
        List<Integer> cards = new ArrayList<>();
        cards.addAll(List.of(1,1,99,1,2));
        p1.setPlayerHand(cards);
        game = new Game("game", p1);
    }

    @Test
    public void false_playerPlaceStackCardInReservoir(){
        Assert.assertFalse(game.validationCardMovement(p1, new String[]{"S"}, new String[]{"R","1"}));
    }

    @Test
    public void false_playerPlaceReservoirCardToOtherReservoirCard(){
        Assert.assertFalse(game.validationCardMovement(p1, new String[]{"R", "2"}, new String[]{"R","1"}));
    }

    @Test
    public void true_playerPlaceStackCardValue1ToEmptyPlayArea(){
        Assert.assertTrue(game.validationCardMovement(p1, new String[]{"S"}, new String[]{"P", "1"}));
    }

    @Test
    public void false_playerStackCardValue9ToEmptyPlayArea(){
        p1.getStack().add(9);
        Assert.assertFalse(game.validationCardMovement(p1, new String[]{"S"}, new String[]{"P", "1"}));
    }

    @Test
    public void false_playerPlaceHandToHand(){
        Assert.assertFalse(game.validationCardMovement(p1, new String[]{"H", "1"}, new String[]{"H", "2"}));
    }

    @Test
    public void true_playerPlaceHand1ToEmptyPlayArea(){
        Assert.assertTrue(game.validationCardMovement(p1, new String[] {"H", "1"}, new String[] {"P", "1"}));
    }

    @Test
    public void false_playerPlaceHand2ToEmptyPlayArea(){
        Assert.assertFalse(game.validationCardMovement(p1, new String[] {"H", "5"}, new String[] {"P", "1"}));
    }

    @Test
    public void true_playerPlaceHandJokerToEmptyPlayArea(){
        Assert.assertTrue(game.validationCardMovement(p1, new String[]{"H", "3"}, new String[]{"P", "1"}));
    }

    //Testing if the cards are removed correctly and play Area is correctly adjusted
    @Test
    public void playerPlaceHand1ToEmptyPlayArea(){
        game.playerMove("Player1", "H:1", "P:1");
        Assert.assertEquals(new PlayAreaCard(1, false), game.getPlayArea().get(0));
        Assert.assertNull(p1.getPlayerHand().get(0));
    }

    @Test
    public void playerPlaceHandJokerToEmptyPlayArea(){
        game.playerMove("Player1", "H:3", "P:1");
        Assert.assertEquals(new PlayAreaCard(1, true), game.getPlayArea().get(0));
        Assert.assertNull(p1.getPlayerHand().get(2));
    }

    @Test
    public void playerPlaceHandJokerToReservoir(){
        game.playerMove("Player1", "H:3", "R:1");
        Assert.assertEquals(99, p1.getReservoir().get(0).peek().intValue());
    }
}
