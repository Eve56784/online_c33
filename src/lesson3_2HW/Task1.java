package lesson3_2HW;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter integer: ");
        int num = scanner.nextInt();
        if (num%2==0)
            System.out.println("\tNumber " + num + " is even.");
        else
            System.out.println("\tNumber " + num + " is odd.");
}
}
