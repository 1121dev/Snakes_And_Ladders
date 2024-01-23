package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game extends Dice{
   private GameState gameState;
   private List<Player>playerList;
    private Map<Integer,Integer> snakes;
    private Map<Integer,Integer>ladders;
    private Player winner;
    private Board board;
    private int currentPlayerIdx;
    private Map<Player,Cell>playerLastLoc;
    public Game(List<Player> playerList, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.gameState = GameState.In_progress;
        this.playerList = playerList;
        this.snakes = snakes;
        this.ladders = ladders;
        board = new Board();
        this.currentPlayerIdx = 0;
        this.playerLastLoc = new HashMap<>();
        for(Player player : playerList)
        {
            playerLastLoc.put(player,new Cell(0));
        }
    }

    public Board getBoard()
    {
        return this.board;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void nextPlayerTurn()
    {
        this.currentPlayerIdx = (currentPlayerIdx+1)%playerList.size();
    }

    public Player currentPlayerTurn()
    {
        return this.playerList.get(currentPlayerIdx);
    }

    public Map<Player, Cell> getPlayerLastLoc() {
        return playerLastLoc;
    }

    public void setPlayerLastLoc(Map<Player, Cell> playerLastLoc) {
        this.playerLastLoc = playerLastLoc;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

    public int DiceRoll()
    {
        Random random = new Random();
        int number = random.nextInt(6)+1;
        return number;
    }


}
