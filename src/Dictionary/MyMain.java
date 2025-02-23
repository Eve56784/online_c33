package Dictionary;

import java.io.*;
import java.util.*;
//Не смогла подключить джаваfx, поэтому сделала через консоль :'D
public class MyMain {
    private static final Map<String, String> dataMap = new HashMap<>();
    private static final String fileName = "src/Dictionary/dict.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadFromFile();

        while (true) {
            System.out.println("Menu:");
            System.out.println("\t1. Add \n\t2. Delete \n\t3. Save\n\t4. Close");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter key (eng) and value (chinese): ");
                    System.out.print("Key: ");
                    String key = scanner.nextLine();
                    System.out.print("Value: ");
                    String value = scanner.nextLine();
                    dataMap.put(key, value);
                    break;
                case 2:
                    System.out.println("Enter key to delete : ");
                    String removeKey = scanner.nextLine();
                    dataMap.remove(removeKey);
                    break;
                case 3:
                    saveToFile();
                    break;
                case 4:
                    saveToFile();
                    System.out.println("You exited.");
                    return;
                default:
                    System.out.println("Error, try again.");
            }

            displayData();
        }
    }

    private static void displayData() {
        System.out.println("Current dictionary contents: ");
        if (dataMap.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (Map.Entry<String, String> entry:dataMap.entrySet()) {
                System.out.println("The word: " + entry.getKey() + ", Translation: " + entry.getValue());
            }
        }
    }

    private static void loadFromFile() {
        try(BufferedReader bufferedReader = new BufferedReader((new FileReader(fileName)))) {
            String line;
            while((line = bufferedReader.readLine())!=null){
                String[] keyAndValue = line.split("[:\\-, ]", 2);
                if(keyAndValue.length==2){
                    dataMap.put(keyAndValue[0], keyAndValue[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveToFile() {
        try(BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(fileName)))){
            for(Map.Entry<String, String> entry:dataMap.entrySet()){
                bufferedWriter.write(entry.getKey() + " - " + entry.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
