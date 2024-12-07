package lesson5_HW;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int[][] snakeNum = snakeArrayCreation();
        output(snakeNum);
    }

    public static int[][] snakeArrayCreation() {
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rows: ");
        int n = scanner.nextInt();
        System.out.println("Enter columns: ");
        int m = scanner.nextInt();
        int[][] snakeArray = new int[n][m];
        for (int i = 0; i < snakeArray.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < snakeArray[i].length; j++) {
                    snakeArray[i][j] = num;
                    num++;
                }
            } else {
                for (int j = snakeArray[i].length - 1; j >= 0; j--) {
                    snakeArray[i][j] = num;
                    num++;
                }
            }
        }
        return snakeArray;
    }

    public static void output(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j]<10){
                    System.out.print(" " + array[i][j] + " ");
                }else {
                    System.out.print(array[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}



