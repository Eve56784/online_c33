package lesson3_2HW;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        int num = 0;

        while (num <= 0) {
            System.out.print("Enter positive integer: ");
            num = scanner.nextInt();
            if (num <= 0) {
                System.out.println("Input error. Please enter a positive integer.");
            }
        }

        while (i < num) {
            System.out.print(i + " ");
            i++;
        }
    }
}
