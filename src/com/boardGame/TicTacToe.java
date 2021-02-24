package com.boardGame;

import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPosition=new ArrayList<>();
    static ArrayList<Integer> cpuPosition=new ArrayList<>();

    public static void main(String[] args)
    {
        char [] [] gameBoard={{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},};

        while(true)
        {
            Scanner input=new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            int playerPos= input.nextInt();
            while(playerPosition.contains(playerPos)|| cpuPosition.contains(playerPos))
            {
                System.out.println("Position taken! Enter a new position");
                playerPos=input.nextInt();
            }
            placeX(playerPos,gameBoard,"player");
            String result=checkWinner();
            if(result.length()>0)
            {
                System.out.println(result);
                break;
            }

            Random rand=new Random();
            int cpuPos=rand.nextInt(9)+1;
            while(playerPosition.contains(cpuPos)|| cpuPosition.contains(cpuPos))
            {
                cpuPos=rand.nextInt(9)+1;
            }
            placeX(cpuPos,gameBoard,"cpu");
            result=checkWinner();
            if(result.length()>0)
            {
                System.out.println(result);
                break;
            }
            printGameBoard(gameBoard);

        }


    }
    public static void printGameBoard(char[][] gameBoard)
    {
        for(char [] row:gameBoard)
        {
            for(char column:row)
            {
                System.out.print(column);
            }
            System.out.println();
        }
    }
    public static void placeX(int xPosition,char[][] gameBoard,String user)
    {
        char symbol=' ';
        if(user.equals("player"))
        {
            symbol='X';
            playerPosition.add(xPosition);
        }
        else if (user.equals("cpu"))
        {
            symbol='O';
            cpuPosition.add(xPosition);
        }

        switch(xPosition)
        {
            case 1:
                gameBoard[0][0]=symbol;
                break;
            case 2:
                gameBoard[0][2]=symbol;
                break;
            case 3:
                gameBoard[0][4]=symbol;
                break;
            case 4:
                gameBoard[2][0]=symbol;
                break;
            case 5:
                gameBoard[2][2]=symbol;
                break;
            case 6:
                gameBoard[2][4]=symbol;
                break;
            case 7:
                gameBoard[4][0]=symbol;
                break;
            case 8:
                gameBoard[4][2]=symbol;
                break;
            case 9:
                gameBoard[4][4]=symbol;
                break;
            default:
                break;
        }
    }
    public static String checkWinner()
    {
        List topRow= Arrays.asList(1,2,3);
        List midRow= Arrays.asList(4,5,6);
        List botRow= Arrays.asList(7,8,9);
        List leftCol=Arrays.asList(1,4,7);
        List midCol=Arrays.asList(2,5,8);
        List rightCol=Arrays.asList(3,6,9);
        List cross1=Arrays.asList(1,5,9);
        List cross2=Arrays.asList(3,5,7);

        List<List> winning=new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for(List l: winning)
        {
            if(playerPosition.containsAll(l))
            {
                return "Congratulations you won!";
            }
            else if(cpuPosition.containsAll(l))
            {
                return "CPU wins! Sorry :(";
            }
            else if(playerPosition.size()+cpuPosition.size()==9)
            {
                return "CAT!";
            }

        }

        return "";
    }
}
