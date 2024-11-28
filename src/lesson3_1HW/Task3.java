package lesson3_1HW;

public class Task3 {
    public static void main (String[] args){
        int n = 123;
        int sum = n%10 + (n/10)%10 + (n/100);
        System.out.println("The sum is: " + sum);
    }
}
