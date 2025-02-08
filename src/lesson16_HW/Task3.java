package lesson16_HW;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(isBalanced("(())"));
        System.out.println((isBalanced("{[])(}")));
    }

    public static boolean isBalanced(String str){
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        StringBuilder stringBuilder = new StringBuilder();
        String opening = "{([";
        String closing = "}])";
        for(char ch:str.toCharArray()){
            if(opening.indexOf(ch)!=-1)
                stringBuilder.append(ch);
            else if (closing.indexOf(ch)!=-1) {
                if(stringBuilder.isEmpty() || stringBuilder.charAt(stringBuilder.length()-1)!=map.get(ch))
                    return false;
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }
        return stringBuilder.isEmpty();
    }
}
