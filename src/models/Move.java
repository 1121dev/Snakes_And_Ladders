package models;

import java.util.Map;
import java.util.Random;
import java.util.List;
public class Move{

    public int executeMakeMove(int playerLastLoc,Map<Integer,Integer> snakes, Map<Integer,Integer>ladders,int rollDice)
    {
        int desiredLoc = rollDice+playerLastLoc;
        if(desiredLoc>100)
            return playerLastLoc;
        if(snakes.containsKey(desiredLoc))
            return snakes.get(desiredLoc);
        if(ladders.containsKey(desiredLoc))
            return ladders.get(desiredLoc);
        return desiredLoc;
    }

}
