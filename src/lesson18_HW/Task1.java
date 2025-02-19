package lesson18_HW;

import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,10,3,4,2,18,9,25,-4,-1,-8,-80);
        int sum = integerList.stream().distinct().filter(x -> x%2==0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum equals to " + sum);
    }
}
