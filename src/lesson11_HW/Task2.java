package lesson11_HW;

import java.util.Objects;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int num;
        StringBuilder sb;
        boolean isPal;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = scanner.nextLine();
        String[] splitStr = str.split(" ");
        do{
            System.out.print("Enter the number of the word you'd like to check: ");
            num = scanner.nextInt();
            scanner.nextLine();
            if(num > splitStr.length || num <= 0){
                System.out.println("\u001B[34mError. Try again\u001B[0m");
                continue;
            }
            sb = new StringBuilder(splitStr[num-1]);
            int left = 0;
            int right = sb.length() - 1;
            isPal = true;
            while(left < right){
                if(sb.charAt(left) != sb.charAt(right)) {
                    System.out.println("The word '"+sb+"' is not a palindrome");
                    isPal = false;
                    break;
                }
                left++;
                right--;
            }
            if(isPal) {
                System.out.println("The word '"+sb+"' is a palindrome");
            }
            System.out.println("Want to continue? (yes/no)");
            String answer = scanner.nextLine();
            if(Objects.equals(answer, "no"))
                break;
        }while(true);
    }
}
