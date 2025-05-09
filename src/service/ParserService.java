package service;

import file_operations.IOOperations;
import model.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserService {
    private static final Pattern pattern = Pattern.compile("(\\d{5}-\\d{5}).*?(\\d{5}-\\d{5}).*?(\\d+)");

    public List<Transaction> parseFile(String inputDir, String outputDir) throws IOException {
        List<File> files = IOOperations.getFileList(inputDir);
        List<Transaction> transactions = new ArrayList<>();

        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        String sender = matcher.group(1);
                        String receiver = matcher.group(2);
                        int amount = Integer.parseInt(matcher.group(3));
                        if (amount <= 0) {
                            continue;
                        }
                        transactions.add(new Transaction(sender, receiver, amount));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error parsing file: " + file.getName() + e.getMessage());
            }
            IOOperations.moveFileToArchive(file, outputDir);
        }

        return transactions;
    }
}