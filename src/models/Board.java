package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    Cell[][]board = new Cell[10][10];

    public Board()
    {
        int flag = 0;
        int id = 100;
        for(int i = 0; i<10; i++)
        {
            if(flag==0)
            {
                int j = 0;
                for(;j<10; j++)
                {
                    this.board[i][j] = new Cell(new ArrayList<>(),id--);
                }
            }
            else if(flag==1)
            {
                int j = 9;
                for(;j>=0; j--)
                {
                    this.board[i][j] = new Cell(new ArrayList<>(),id--);
                }
            }
            flag^=1;
        }
    }
    public Cell[][] getGameBoard()
    {
        return board;
    }
    public void displayBoard()
    {
        for(int i = 0; i<10; i++)
        {
            for(int j = 0; j<10; j++)
            {
                Cell cell = board[i][j];
                    if(cell.getPlayerList().isEmpty())
                    System.out.print(cell.getId()+" ");
                    else
                    {
                        List<Player>playerList = cell.getPlayerList();
                        for(Player player : playerList)
                        {
                            System.out.print(player.getSymbol());
                        }
                        System.out.print(" ");
                    }

            }
            System.out.println();
        }
    }
    public Cell updateBoard(Player player, int playerLastLoc, int desiredLoc)
    {
        if(playerLastLoc!=0)
        {
            for(int i = 0; i<10; i++)
            {
                for(int j = 0; j<10; j++)
                {
                    int id = board[i][j].getId();
                    if(id==playerLastLoc)
                    {
                        board[i][j].getPlayerList().remove(player);
                    }
                }
            }
        }
        Cell finalCell;
        for(int i = 0; i<10; i++)
        {
            for(int j = 0; j<10; j++)
            {
                int id = board[i][j].getId();
                if(id==desiredLoc)
                {
                    board[i][j].getPlayerList().add(player);
                    finalCell = board[i][j];
                    return finalCell;
                }
            }
        }

        return null;
    }

}
