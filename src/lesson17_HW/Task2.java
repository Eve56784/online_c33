package lesson17_HW;

import java.util.function.Predicate;

public class Task2 {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0;
        int[] array = {0, -1, 3, -50, 2, 8};
        for(Integer integer:array) {
            if(isPositive.test(integer))
                System.out.println(integer);
        }
    }
}
