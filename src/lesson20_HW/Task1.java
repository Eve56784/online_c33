package lesson20_HW;

import java.util.Scanner;

public class Task1 {
    private static int max;
    private static int min;

    public static void main(String[] args) {
        int n= new Scanner(System.in).nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i]=new Scanner(System.in).nextInt();
        }
        System.out.println("Min: "+ findMin(arr));
        System.out.println("Max: "+ findMax(arr));
    }

    public static int findMax(int[] arr){
        max = arr[0];
        Thread minThread = new Thread(()->{
            for(int i =1; i<arr.length-1; i++){
                if(max<arr[i])
                    max=arr[i];
            }
        });
        minThread.start();
        try{
            minThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return max;
    }

    public static int findMin(int[] arr){
        min = arr[0];
        Thread maxThread = new Thread(()->{
            for(int i =1; i<arr.length-1; i++){
                if(min>arr[i])
                    min=arr[i];
            }
        });
        maxThread.start();
        try{
            maxThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return min;
    }
}
