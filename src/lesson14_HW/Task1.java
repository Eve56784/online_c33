package lesson14_HW;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Task1 {
    public static void main(String[] args) {
        String output = "src/lesson14_HW/TextForTask1";
        String input = "src/lesson14_HW/NewFileForTask1";
        String theLongestWord = "";
        try(Scanner scanner = new Scanner(new File(output))){
            while(scanner.hasNext()){
                String word = scanner.next();
                if(word.length()>theLongestWord.length())
                    theLongestWord = word;
            }
        }catch(FileNotFoundException e){
            System.out.println("Can't open the file: "+ e.getMessage());
        }
        try(FileWriter writer = new FileWriter(input)){
            writer.append(theLongestWord);
        }catch(IOException e){
            System.out.println("Can't open the file: "+ e.getMessage());
        }
    }
}
