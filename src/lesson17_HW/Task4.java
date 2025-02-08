package lesson17_HW;

import java.util.Scanner;
import java.util.function.Consumer;

public class Task4 {
    public static void main(String[] args) {
        double exchangeRate = 0.3056;
        String amount = new Scanner(System.in).nextLine();
        Consumer<String> convertToUSD= x -> {
            double BYN = Double.parseDouble(x.split(" ")[0]);
            System.out.printf("%.2f USD", BYN*exchangeRate);
        };
        convertToUSD.accept(amount);
    }
}
