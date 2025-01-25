package lesson12_HW;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Enter string: ");
        String str = new Scanner(System.in).nextLine();
        String[] words = str.split("[ ,]+");
        for (String word : words){
            if(isAbbreviation(word))
                System.out.println(word);
        }
    }
    public static boolean isAbbreviation(String word){
        return word.length() >= 2 && word.length() < 6 && word.matches("[A-Z]+");
    }
}