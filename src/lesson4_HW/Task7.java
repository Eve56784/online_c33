package lesson4_HW;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        addOne();
    }

    public static void addOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desirable size of an array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        int[] newArray = new int [size+1];
        boolean useNewArray = false;

        for (int i = 0; i < size; i++) {
            System.out.print("Enter your element number " + (i + 1) + " (element should be integer [0;9]): ");
            array[i] = scanner.nextInt();
        }

        for (int i = size - 1; i >= 0; i--) {
            if (array[i] < 9) {
                array[i]++;
                break;
            }
            array[i] = 0;
            if (i == 0) {
                newArray[0] = 1;
                useNewArray = true;
            }
        }

        System.out.println("Resulting array: ");
        if (useNewArray) {
            for (int i : newArray) {
                System.out.print(i + " ");
            }
        } else {
            for (int i : array) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}
