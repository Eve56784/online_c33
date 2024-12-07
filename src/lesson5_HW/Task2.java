package lesson5_HW;

public class Task2 {
    public static void main(String[] args) {
        String[][] chessBoard = createChessBoard();
        printChessBoard(chessBoard);
    }
    public static String[][] createChessBoard(){
        String[][] array = new String[8][8];
        for(int i=0; i<8; i++){
            for(int j = 0; j<8; j++){
                if(((i+j)%2 == 0)){
                    array[i][j] = "W";
                }else{
                    array[i][j] = "B";
                }
            }
        }
        return array;
    }
    public static void printChessBoard(String[][] chessBoard){
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}
