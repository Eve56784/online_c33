package lesson4_HW;

import java.util.Scanner;
import java.util.Random;

public class Task1_2_3_4_5_6 {
    public static void main(String[] args) {
        arrayOperations();
    }

    public static void arrayOperations() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 26, max = -21, minIndex = -1, maxIndex = -1, zeroCounter = 0;
        boolean isIncreasing = true;

        System.out.println("Enter the desirable size of an array: ");
        int size = scanner.nextInt();
        int[] ourArray = new int[size];

        System.out.println("Press 1 to use Random, 2 to input the array contents manually: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                for (int i = 0; i < size; i++) {
                    ourArray[i] = random.nextInt(46) - 20;
                }
                break;
            case 2:
                for (int i = 0; i < size; i++) {
                    System.out.println("Enter element number " + (i + 1) + ": ");
                    ourArray[i] = scanner.nextInt();
                }
                break;
            default:
                System.out.println("Input error. Try again.");
                return;
        }

        System.out.print("\nTask1: Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(ourArray[i] + " ");
            if (ourArray[i]<min) {
                min = ourArray[i];
                minIndex = i;
            }
            if (ourArray[i]>max) {
                max = ourArray[i];
                maxIndex = i;
            }
            if (ourArray[i] == 0)
                zeroCounter++;
        }

        System.out.print("\nTask1: Array elements in reverse order: ");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(ourArray[i] + " ");
        }

        System.out.println("\nTask2: min equals to " + min + " max equals to " + max);
        System.out.println("Task3: minIndex equals to " + (minIndex+1) + " maxIndex equals to " + (maxIndex+1));
        if (zeroCounter!=0)
            System.out.println("Task4: there are " + zeroCounter + " zeroes in the array");
        else
            System.out.println("Task4: there seem to be no zeroes...");

        for (int i = 0; i<size/2; i++){
            int placeHolder = ourArray[i];
            ourArray[i] = ourArray[size-1-i];
            ourArray[size-1-i] = placeHolder;
        }

        System.out.print("Task5: the changed array is: ");
        for (int i = 0; i < size; i++) {
            System.out.print(ourArray[i] + " ");
        }

        for (int i = 0; i<size/2; i++){ //return the array to its original state after completing Task5:
            int placeHolder = ourArray[i];
            ourArray[i] = ourArray[size-1-i];
            ourArray[size-1-i] = placeHolder;
        }

        for (int i = 0; i < size-1; i++){
            if (ourArray[i]>=ourArray[i+1]) {
                isIncreasing = false;
                break;
            }
        }

        if (isIncreasing)
            System.out.print("\nTask6: The array is increasing");
        else
            System.out.print("\nTask6: The array is not increasing");
        scanner.close();
    }
}

