package lesson18_HW;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        for(int i = 1; i<15; i++)
            hashMap.put(i, "Eve"+i);
        List<String> result = hashMap.entrySet().stream()
                .filter(entry -> Arrays.asList(1,2,5,8,9,13).contains(entry.getKey()))
                .map(Map.Entry::getValue)
                .filter(entry -> entry.length()%2 != 0)
                .map(entry -> new StringBuilder(entry).reverse().toString())
                .toList();
        System.out.println(result);
    }
}
