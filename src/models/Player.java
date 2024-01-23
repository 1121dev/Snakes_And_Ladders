package models;

import java.util.Map;

public class Player {

    private String name;

    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int makeMove(int playerLastLoc, Map<Integer,Integer> snakes, Map<Integer,Integer>ladders,int rollDice)
    {
        Move move = new Move();
        int desiredLoc = move.executeMakeMove(playerLastLoc,snakes,ladders,rollDice);
        return desiredLoc;
    }
}
