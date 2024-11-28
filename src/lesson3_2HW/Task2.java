package lesson3_2HW;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        int temp = scanner.nextInt();
        if (temp>5) //ig it was supposed to be 5 instead of -5
            System.out.println("Warm");
        else if (temp<=-20) //<= instead of >=
            System.out.println("Cold");
        else
            System.out.println("Normal");
    }
}
