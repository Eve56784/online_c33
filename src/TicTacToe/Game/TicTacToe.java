package TicTacToe.Game;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        boolean newbie = true;
        Scanner scanner = getInputValue();
        while (true) {
            if (newbie) {
                getInitialMessage();
            }
            if (scanner.nextLine().equals("y")) {
                newbie = false;
                boolean win = false;
                System.out.println("✄┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
                char[][] gameTable = createInitializeTable();
                drawTable(gameTable);

                int dice = getRandomNumbers().nextInt(2);
                if (dice == 0) {
                    makeAIMove(gameTable, 'X');
                } else {
                    makePlayerMove(gameTable, 'X');
                }

                int moveCount = 1;
                while (moveCount < 9) {
                    if (dice == 0) {
                        makePlayerMove(gameTable, 'O');
                        moveCount++;
                        if (checkGameStatus(gameTable, 'O')) {
                            System.out.println("\u001b[32;1mYou have won!! ദി(˵ •̀ ᴗ - ˵ ) " +
                                    "✧\nDo you wanna play again? (y/n): \u001b[0m");
                            win = true;
                            break;
                        }
                        makeAIMove(gameTable, 'X');
                        moveCount++;
                        if (checkGameStatus(gameTable, 'X')) {
                            System.out.println("\u001b[34;1mAI has won... (¬`‸´¬)" +
                                    "\nDo you wanna take revenge? (y/n): \u001b[0m");
                            win = true;
                            break;
                        }
                    } else {
                        makeAIMove(gameTable, 'O');
                        moveCount++;
                        if (checkGameStatus(gameTable, 'O')) {
                            System.out.println("\u001b[34;1mAI has won... (¬`‸´¬)" +
                                    "\nDo you wanna take revenge? (y/n): \u001b[0m");
                            win = true;
                            break;
                        }
                        makePlayerMove(gameTable, 'X');
                        moveCount++;
                        if (checkGameStatus(gameTable, 'X')) {
                            System.out.println("\u001b[32;1mYou have won!! ദി(˵ •̀ ᴗ - ˵ )✧" +
                                    "\nDo you wanna play again? (y/n): \u001b[0m");
                            win = true;
                            break;
                        }
                    }
                }
                if (moveCount == 9 && !win) {
                    System.out.println("\u001b[33;1mIt's a DRAW. Would you like to play again? (y/n): \u001b[0m");
                }
            } else {
                System.out.println("See ya!");
                break;
            }

            if (!scanner.nextLine().equals("y")) {
                System.out.println("See ya!");
                break;
            }
        }
    }


    public static void getInitialMessage(){
        System.out.print("\u001b[36m");
        System.out.println("""
                The game is played on a 3x3 grid.
                One player is 'X' and the other player is 'O'.\
                
                The goal is to be the first player to get three of your marks in a row (horizontally, vertically, or diagonally). \
                
                Players take turns placing their mark (X or O) in an empty cell. \
                
                The game continues until one player gets three marks in a row or all cells are filled.\
                
                A player wins by placing three of their marks in a row, column, or diagonal. \
                
                If all cells are filled and no player has three marks in a row, the game ends in a draw. \
                
                If the game ends in a win or draw, players can choose to start a new game.
                \u001b[34mGOOD LUCK! (type y to start and n to exit)\u001b[0m""");
    }

    public static char[][] createInitializeTable(){
        return new char[][]{
                {'*','*','*'},
                {'*','*','*'},
                {'*','*','*'}
        };
    }

    public static void drawTable(char[][] gameTable){
        System.out.print("\u001b[35m");
        for(char[] outer : gameTable){
            for(char inner : outer){
                System.out.print("\t" + inner + " ");
            }
            System.out.println();
        }
        System.out.print("\u001b[0m");
    }

    public static void makeAIMove(char[][] gameTable, char symbol){
        int rowAI, columnAI;
        while(true){
            rowAI = getRandomNumbers().nextInt(3);
            columnAI = getRandomNumbers().nextInt(3);
            if(gameTable[rowAI][columnAI]=='*'){
                gameTable[rowAI][columnAI]=symbol;
                break;
            }
        }
        System.out.println("✄┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
        System.out.println("AI has decided to make the following move: [" + (rowAI+1) + "]["
                + (columnAI+1) + "]");
        drawTable(gameTable);
    }
    public static void makePlayerMove(char[][] gameTable, char symbol){
        Scanner scanner = getInputValue();
        int rowPlayer, columnPlayer;
        System.out.println("✄┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈");
        while(true){
            System.out.println("Enter the row number (1-3): ");
            rowPlayer = scanner.nextInt()-1;
            System.out.println("Enter the column number (1-3): ");
            columnPlayer = scanner.nextInt()-1;

            if(rowPlayer>=0 && rowPlayer <= 2 && columnPlayer >=0 && columnPlayer <=2) {
                if (gameTable[rowPlayer][columnPlayer] == '*') {
                    gameTable[rowPlayer][columnPlayer] = symbol;
                    System.out.println("You have decided to make the following move: [" + (rowPlayer + 1) + "]["
                            + (columnPlayer + 1) + "]");
                    drawTable(gameTable);
                    break;
                }
            }
            System.out.println("\u001b[43m\u001b[30mYou have entered the wrong value...\u001b[0m");
        }
    }

    public static boolean checkGameStatus(char[][] gameTable, char symbol){
        for(int i=0; i<3; i++){
            if((gameTable[i][0] == symbol && gameTable[i][1] == symbol && gameTable[i][2] == symbol) ||
                    (gameTable[0][i] == symbol && gameTable[1][i] == symbol && gameTable[2][i] == symbol) ||
                    (gameTable[0][0] == symbol && gameTable[1][1] == symbol && gameTable[2][2] == symbol) ||
                    (gameTable[0][2] == symbol && gameTable [1][1] == symbol && gameTable[2][0] == symbol))
                return true;
        }
        return false;
    }

    public static Random getRandomNumbers(){
        return new Random();
    }

    public static Scanner getInputValue(){
        return new Scanner(System.in);
    }
}