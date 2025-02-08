package lesson17_HW;

import java.util.Scanner;
import java.util.function.Function;

public class Task3 {
    public static void main(String[] args) {
        double exchangeRate = 0.3056;
        Function<String, Double> convertToUSD = x ->{
            double BYN = Double.parseDouble(x.split(" ")[0]);
            return BYN*exchangeRate;
        };
        String amount = new Scanner(System.in).nextLine();
        System.out.printf("%.2f USD", convertToUSD.apply(amount));
    }
}
