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

    }
    public static boolean isEMail(String word){

    }
    public static boolean isPhoneNum(String word){

    }
}
