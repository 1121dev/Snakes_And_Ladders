package controller;
import models.Board;
import models.Game;
import models.GameState;
import models.Player;
import service.GameService;

import java.util.List;
import java.util.Map;

public class GameController {
    private List<Player> playerList;
    private Map<Integer,Integer> snakes;
    private Map<Integer,Integer>ladders;

    public Game createGame(List<Player> playerList,Map<Integer,Integer> snakes,Map<Integer,Integer>ladders)
    {
        return new Game(playerList,snakes,ladders);
    }

    public void display(Game game)
    {
        Board board = game.getBoard();
        board.displayBoard();
    }

    public GameState getGameStatus(Game game)
    {
        return game.getGameState();
    }

    public Player getWinner(Game game)
    {
        return game.getWinner();
    }

    public void executeNextTurn(Game game)
    {
        GameService gameService = new GameService(game);
        gameService.executeMove();
    }





}
