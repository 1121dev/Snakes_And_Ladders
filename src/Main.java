import controller.GameController;
import models.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //number of snakes and coordinates of the same on the board
        System.out.println("Enter the number of snakes");
        int numberOfSnakes = sc.nextInt();
        Map<Integer, Integer> snakeCo = new HashMap<>();
        for(int i = 0; i<numberOfSnakes; i++)
        {
            Integer snakeHead = sc.nextInt();
            Integer snakeTail = sc.nextInt();
            snakeCo.put(snakeHead,snakeTail);
        }
        //number of ladders and coordinates of the same on the board
        System.out.println("Enter the number of Ladders");
        int numberOfLadders = sc.nextInt();
        Map<Integer,Integer>ladderCo = new HashMap<>();
        for(int i = 0; i<numberOfLadders; i++)
        {
            Integer ladderStart = sc.nextInt();
            Integer ladderEnd = sc.nextInt();
            ladderCo.put(ladderStart,ladderEnd);
        }

        //number of players
        System.out.println("Enter the number of players");
        int numberOfPlayers = sc.nextInt();
        List<Player> playerList = new ArrayList<>();
        for(int i = 0; i<numberOfPlayers; i++)
        {
            System.out.println("Enter the name of the player");
            String name = sc.next();
            System.out.println("Enter the symbol for the player");
            String symbol = sc.next();
            Player p = new Player(name,symbol.charAt(0));
            playerList.add(p);
        }

        GameController gameController = new GameController();
        Game game = gameController.createGame(playerList,snakeCo,ladderCo);
        while(game.getGameState().equals(GameState.In_progress))
        {

            gameController.executeNextTurn(game);
            System.out.println();

            gameController.display(game);
        }
        System.out.println();
        if(game.getGameState().equals(GameState.Draw))
            System.out.println("The match is a draw");
        if(game.getGameState().equals(GameState.Win))
            System.out.printf("%s has won this match",game.getWinner().getName());













//        Player p = new Player(0,"super", PlayerType.Human,'$');
//        List<Player> pl = new ArrayList<>();
//        pl.add(p);
//        Game g = new Game(pl);
//        g.launch();
//        g.getBoard().displayBoard();
////        //Move m = new Move();
////        m.makeMove(p);
////        b.displayBoard();
    }
}