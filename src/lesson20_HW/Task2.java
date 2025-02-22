package lesson20_HW;

import java.util.Arrays;

public class Task2 {

    private static int[] bubbleSort;
    private static int[] insertSort;
    private static int[] selectSort;

    public static void main(String[] args) {
        int[] arr = {6, -10, 3, 9, 4, 2, -2, -18, -11, 21};
        bubbleSort = Arrays.copyOf(arr, arr.length);
        insertSort = Arrays.copyOf(arr, arr.length);
        selectSort = Arrays.copyOf(arr, arr.length);

        Thread bubbleSortT = new Thread(() -> {
            bubbleSortMethod(bubbleSort);
            System.out.println(Arrays.toString(bubbleSort));
        });
        Thread insertSortT = new Thread(() -> {
            insertSortMethod(insertSort);
            System.out.println(Arrays.toString(insertSort));
        });
        Thread selectSortT = new Thread(() -> {
            selectSortMethod(selectSort);
            System.out.println(Arrays.toString(selectSort));
        });
        bubbleSortT.start();
        insertSortT.start();
        selectSortT.start();
    }

    public static void bubbleSortMethod(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertSortMethod(int[] array){
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void selectSortMethod(int[] array){
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }
}