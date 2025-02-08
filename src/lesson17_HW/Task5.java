package lesson17_HW;

import java.util.Scanner;
import java.util.function.Supplier;

public class Task5 {
    public static void main(String[] args) {
        String string = new Scanner(System.in).nextLine();
        Supplier<String> viceVersa = () -> new StringBuilder(string).reverse().toString();
        System.out.println(viceVersa.get());
    }
}
