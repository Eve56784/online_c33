package lesson11_HW;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string 1: ");
        String str1 = scanner.nextLine();
        System.out.println("Enter string 2: ");
        String str2 = scanner.nextLine();
        System.out.println("Enter string 3: ");
        String str3 = scanner.nextLine();
        //task 1.1
        outputTask1(str1, 1);
        outputTask1(str2, 2);
        outputTask1(str3, 3);
        System.out.println("-----------------------------");
        //task 1.2
        outputTask2(str1, str2, str3);
        System.out.println("-----------------------------");
        //task 1.3
        outputTask3(str1, str2, str3);
    }
    public static void outputTask1(String string, int num){
        System.out.println("String"+num+" ("+string+") length is "+string.length());
    }
    public static void outputTask2(String a, String b, String c){
        if(a.length()<=b.length() && a.length()<=c.length()){
            if (b.length()<=c.length())
                System.out.println(a+"\n"+b+"\n"+c);
            else
                System.out.println(a+"\n"+c+"\n"+b);
        } else if (b.length()<=a.length() && b.length()<=c.length()) {
            if (a.length()<=c.length())
                System.out.println(b+"\n"+a+"\n"+c);
            else
                System.out.println(b+"\n"+c+"\n"+a);
        }
        else{
            if (a.length()<=b.length())
                System.out.println(c+"\n"+a+"\n"+b);
            else
                System.out.println(c+"\n"+b+"\n"+a);
        }
    }
    public static void outputTask3(String a, String b, String c){
        int averageLength = (a.length()+b.length()+c.length())/3;
        if(a.length()<averageLength)
            outputTask1(a, 1);
        if(b.length()<averageLength)
            outputTask1(b, 2);
        if(c.length()<averageLength)
            outputTask1(c, 3);
    }
}
