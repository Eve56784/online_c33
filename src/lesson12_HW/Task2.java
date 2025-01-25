package lesson12_HW;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Enter string: ");
        String str = new Scanner(System.in).nextLine();
        String[] words = str.split("[ ,]+");
        for (String word : words){
            if(isDocNum(word))
                System.out.println("Document number: "+word);
            else if(isEMail(word))
                System.out.println("EMail: "+word);
            else if(isPhoneNum(word))
                System.out.println("Phone number: "+word);
        }
    }
    public static boolean isDocNum(String word){
        return word.matches("\\d{4}-\\d{4}-\\d{2}");
    }
    public static boolean isEMail(String word){
        return word.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }
    public static boolean isPhoneNum(String word){
        return word.matches("\\+\\(\\d{2}\\)\\d{8}");
    }
}
