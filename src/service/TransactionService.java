package service;

import model.Account;
import model.Transaction;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionService {
    private Map<String, Account> accounts = new HashMap<>();
    private static final String accountsFile = "accounts.txt";
    private static final String backupFile = "accounts_backup.txt";
    private static final String validFile = "valid.txt";
    private static final String invalidFile = "invalid.txt";
    private static final Pattern accountPattern = Pattern.compile("^(\\d{5}-\\d{5})\\s+(\\d+)$");

    public TransactionService() throws IOException {
        loadAccounts();
    }

    private void loadAccounts() throws IOException {
        File file = new File(accountsFile);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = accountPattern.matcher(line);
                if (matcher.matches()) {
                    String accNumber = matcher.group(1);
                    int balance = Integer.parseInt(matcher.group(2));
                    accounts.put(accNumber, new Account(accNumber, balance));
                }
            }
        }
    }

    private void saveAccounts() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(accountsFile))) {
            for (Account account : accounts.values()) {
                bw.write(account.getAccNumber() + " " + account.getBalance());
                bw.newLine();
            }
        }
    }

    private void saveBackup() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(backupFile))) {
            for (Account account : accounts.values()) {
                bw.write(account.getAccNumber() + " " + account.getBalance());
                bw.newLine();
            }
        }
    }

    public void applyTransactions(List<Transaction> transactions) throws IOException {
        saveBackup();

        int validCount = 0;
        int invalidCount = 0;

        for (Transaction transaction : transactions) {
            Account sender = accounts.get(transaction.getSender());
            Account receiver = accounts.get(transaction.getReceiver());

            if (sender == null || receiver == null) {
                addToInvalid("Account(s) not found: ", transaction);
                invalidCount++;
                continue;
            }

            if (sender.getBalance() < transaction.getAmount()) {
                addToInvalid("Insufficient funds: ", transaction);
                invalidCount++;
                continue;
            }

            if (transaction.getAmount() <= 0) {
                addToInvalid("Negative amount, transaction cancelled: ", transaction);
                invalidCount++;
                continue;
            }

            sender.setBalance(sender.getBalance() - transaction.getAmount());
            receiver.setBalance(receiver.getBalance() + transaction.getAmount());
            addToValid(transaction);
            validCount++;
        }
        saveAccounts();
        System.out.println("Valid transactions: " + validCount + "; Invalid transactions: " + invalidCount);
    }

    private void addToValid(Transaction transaction) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(validFile, true))) {
            bw.write(String.format("%s sent %d to %s",
                    transaction.getSender(), transaction.getAmount(), transaction.getReceiver()));
            bw.newLine();
        }
    }

    private void addToInvalid(String msg, Transaction transaction) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(invalidFile, true))) {
            bw.write(String.format("%s attempted to send %d to %s\nError: %s",
                    transaction.getSender(), transaction.getAmount(), transaction.getReceiver(), msg));
            bw.newLine();
            bw.newLine();
        }
    }

    public void printValid() throws FileNotFoundException {
        File valid = new File(validFile);
        if(!valid.exists()) { return; }
        try(BufferedReader br = new BufferedReader(new FileReader(valid))){
            String line;
            while((line = br.readLine())!=null)
                System.out.println(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
