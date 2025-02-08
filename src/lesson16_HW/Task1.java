package lesson16_HW;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        String[] s1 = {"Banana", "Apple","Pineapple", "Grape", "Aubergine", "Dragon Fruit"};
        String[] s2 = {"Dragon Fruit","Dragon Fruit"};
        String[] s3 = {"Banana", "Apple","Apple", "Grape", "Aubergine", "Dragon Fruit"};
        System.out.println(wordMultiple(s1)+"\n"+wordMultiple(s2)+"\n"+wordMultiple(s3));
    }

    public static Map<String, Boolean> wordMultiple(String[] words){
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Boolean> finalMap = new HashMap<>();
        for(String word : words)
            countMap.put(word, countMap.getOrDefault(word, 0)+1);
        for(Map.Entry<String, Integer> entry: countMap.entrySet())
            finalMap.put(entry.getKey(), entry.getValue()>=2);
        return finalMap;
    }
}
