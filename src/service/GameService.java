package service;

import models.Game;
import models.GameState;
import models.Player;
import models.Cell;
import java.util.List;

public class GameService {
    Game game;
    public GameService(Game game)
    {
        this.game = game;
    }
    public void executeMove()
    {
        Player player = game.currentPlayerTurn();
        int rollDice = game.DiceRoll();
        int playerLastLoc = game.getPlayerLastLoc().get(player).getId();
        int desiredLoc = player.makeMove(playerLastLoc,game.getSnakes(),game.getLadders(),rollDice);
        Cell cell = game.getBoard().updateBoard(player,playerLastLoc,desiredLoc);
        game.getPlayerLastLoc().put(player,cell);
        System.out.println();
        System.out.printf("Player %s have played the move- Rolled the dice and got %d" +
                " - moved from %d to %d",player.getName(),rollDice,playerLastLoc,desiredLoc);
        System.out.println();
        Cell fcell = game.getBoard().getGameBoard()[0][0];
        if(fcell.getPlayerList().size()==1)
        {
            game.setWinner(player);
            game.setGameState(GameState.Win);
            return;
        }
        if(fcell.getPlayerList().size()>1)
        {
            game.setGameState(GameState.Draw);
            return;
        }
        game.nextPlayerTurn();
    }
}
