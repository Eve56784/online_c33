import model.Transaction;
import service.ParserService;
import service.TransactionService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionService ts;
        ParserService ps = new ParserService();
        try{
            ts = new TransactionService();
        } catch (IOException e) {
            System.err.println("Error loading accounts: " + e.getMessage()); return;
        }
        while(true){
            System.out.println("\t\tMenu\n1. Parse transactions\n2. Print successful transactions\n3. Exit");
            String choice = scanner.nextLine();
            switch(choice){
                case "1":
                    try{
                        List<Transaction> transactions = ps.parseFile("src/input", "src/archive");
                        ts.applyTransactions(transactions);
                    } catch (IOException e) {
                        System.err.println("Error parsing transactions: " + e.getMessage());
                    }
                    break;
                case "2": try{
                    ts.printValid();
                }catch(IOException e){
                    System.err.println("Error printing transactions: " + e.getMessage());
                }
                    break;
                case "3": System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}
