package lesson14_HW;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        /*if(args.length<1){
            System.out.println("No file path provided");
            return;
        }
        не смогла ввести с консоли путь к файлу*/
        String invalidTXT = "C:\\Users\\mayia\\IdeaProjects\\project123\\src\\lesson14_HW\\InvalidNums";
        String validTXT = "C:\\Users\\mayia\\IdeaProjects\\project123\\src\\lesson14_HW\\ValidNums";
        //String inputFile = args[0];
        try(Scanner scanner = new Scanner(new File("C:\\Users\\mayia\\IdeaProjects\\project123\\src\\lesson14_HW\\FileForTask2"))){
            FileWriter fileWriterValid = new FileWriter(validTXT);
            FileWriter fileWriterInvalid = new FileWriter(invalidTXT);
            while (scanner.hasNextLine()){
                String docNumber = scanner.nextLine();
                if(isValid(docNumber))
                    fileWriterValid.append(docNumber).append("\n");
                else {
                    fileWriterInvalid.append(docNumber).append(" The reason: ").append(getTheReason(docNumber)).append("\n");
                }
            }
            fileWriterValid.close();
            fileWriterInvalid.close();
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static boolean isValid (String str){
        return str.length()==15 && (str.startsWith("docnum") || str.startsWith("contract"))
                && str.matches("^[a-zA-Z0-9]+$");
    }
    private static String getTheReason(String str){
        if(str.length()!=15)
            return "Length is invalid";
        else if (!str.startsWith("docnum") || !(str.startsWith("contract")))
            return "Prefix is invalid";
        else if (!str.matches("^[a-zA-Z0-9]+$")) {
            return "Contains invalid characters";
        } else
            return "Something's wrong";
    }
}