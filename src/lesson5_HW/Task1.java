package lesson5_HW;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int[][] array = randomNumbersFill();
        addNumsSumOutput(array);
    }
    public static int[][] randomNumbersFill() {
        int rows = 3;
        int cols = 2;
        int[][] array = new int[rows][cols];
        Random random = new Random();
        System.out.print("{ ");
        for (int i = 0; i<rows; i++){
            for (int j = 0; j<cols; j++) {
                array[i][j] = random.nextInt(20);
                System.out.print(array[i][j] + " ");
            }

        }
        System.out.print("}");
        return array;
    }
    public static void addNumsSumOutput(int[][] array){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the number you wanna add to all the array elements: ");
        int numToAdd = scanner.nextInt(), sum = 0;

        for (int [] row: array){
            for (int element:row){
                sum+=element + numToAdd;
            }

        }
        System.out.println("The sum is equal to " + sum);
    }
}

