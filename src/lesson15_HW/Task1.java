package lesson15_HW;

import java.util.Scanner;
import java.util.TreeSet;

public class Task1 {
    public static void main(String[] args) {
        TreeSet<Integer> integerSet = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of Integers you want to enter: ");
        int quantity = scanner.nextInt();
        if (quantity == 0) quantity++;
        for (int i = 0; i < quantity; i++)
            integerSet.add(scanner.nextInt());
        System.out.println(integerSet);
    }
}
