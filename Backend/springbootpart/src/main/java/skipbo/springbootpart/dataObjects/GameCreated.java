package skipbo.springbootpart.dataObjects;

public class GameCreated {
    String gameRoom;

    public GameCreated(String gameRoom){
        this.gameRoom = gameRoom;
    }

    public String getGameRoom() {
        return gameRoom;
    }

    public void setGameRoom(String gameRoom) {
        this.gameRoom = gameRoom;
    }
}
