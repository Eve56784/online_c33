package lesson13_HW;

public class Task2 {
    public static void main(String[] args) {
        try {
            System.out.println("Inside the try block");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Inside the try block");
        } finally {
            System.out.println("Inside the finally block");
        }
    }
}
