package skipbo.game.gameobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {

    private String playerName;
    private String id;
    private Stack<Integer> stack;
    private List<Integer> playerHand;
    private List<Stack<Integer>> reservoir;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<Stack<Integer>> getReservoir() {
        return reservoir;
    }

    public void setReservoir(List<Stack<Integer>> reservoir) {
        this.reservoir = reservoir;
    }

    public List<Integer> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(List<Integer> playerHand) {
        this.playerHand = playerHand;
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player(String playerName, String id){
        this.playerName = playerName;
        this.id = id;
        playerHand = new ArrayList<Integer>();
        reservoir = new ArrayList<Stack<Integer>>();
        for(int i = 0; i<4; i ++){
            reservoir.add(new Stack<Integer>());
        }
    }

    public void setStack(Stack<Integer> stack){
        this.stack = stack;
    }

    public void fillHand(List<Integer> cards){
        playerHand.addAll(cards);
    }

    public Integer getCardValue(String from){
        String[] split = from.split(":");
        if(split[0]=="H"){
            return playerHand.get(Integer.valueOf(split[1]));
        }else if(split[0]=="R"){
            return reservoir.get(Integer.valueOf(split[1])).peek();
        }
        return stack.peek();
    }

    public Integer takeCardFromPlayerHand(Integer index){
        Integer card = playerHand.get(index);
        playerHand.set(index, null);
        return card;
    }


}
