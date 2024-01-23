package models;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private List<Player> playerList;

    private int id;

    public Cell(List<Player> playerList, int id) {
        this.playerList = playerList;
        this.id = id;
    }
    public Cell(int id)
    {
        this.id = id;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
