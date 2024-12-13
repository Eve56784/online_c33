package TicTacToe.Game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        getInitialMessage();

        if((getInputValue().nextLine()).equals("y")){
            System.out.println("--------------------------------");
            char[][] gameTable = createInitializeTable();
            drawTable(gameTable);


        }
    }

    public static void getInitialMessage(){
        System.out.println("\u001b[47m");
        System.out.println("!!![WIP]!!!\u001b[0m");
    }

    public static char[][] createInitializeTable(){
        return new char[][]{
                {'*','*','*'},
                {'*','*','*'},
                {'*','*','*'}
        };
    }

    public static void drawTable(char[][] gameTable){
        System.out.println("\u001b[35m");
        for(char[] outer : gameTable){
            for(char inner : outer){
                System.out.println("\t" + inner + " ");
            }
            System.out.println("\n");
        }
        System.out.println("\u001b[0m");
    }

    public static void makeAIMove(char[][] gameTable, char symbol){
        Random random = new Random();
        int cellAI, columnAI;
        while(true){
            cellAI = random.nextInt(2);
            columnAI = random.nextInt(2);
            if(gameTable[cellAI][columnAI]=='*'){
                gameTable[cellAI][columnAI]=symbol;
                break;
            }
        }
        System.out.println("AI has decided to make the following move: [" + cellAI + "][" + columnAI + "]");
        drawTable(gameTable);
    }


}