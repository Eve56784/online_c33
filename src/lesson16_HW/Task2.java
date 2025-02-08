package lesson16_HW;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        String[] s = {"sun","son","morning", "daylight"};
        System.out.println(pairs(s));
    }
    public static Map<String, String> pairs(String[] array){
        Map<String,String> finalMap = new HashMap<>();
        for(String str : array){
            String key = String.valueOf(str.charAt(0));
            String value = String.valueOf(str.charAt(str.length()-1));
            finalMap.put(key, value);
        }
        return finalMap;
    }
}
