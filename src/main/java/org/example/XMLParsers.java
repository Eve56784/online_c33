package org.example;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class XMLParsers {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter 1 for SAX, 2 for DOM:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: parseWithSAX("src/main/resources/sonnets.xml"); break;
                case 2: parseWithDOM("src/main/resources/sonnets.xml"); break;
                default: System.out.println("Input error"); break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseWithSAX(String filePath) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        SAXHandler handler = new SAXHandler();
        saxParser.parse(new File(filePath), handler);

        handler.writeToFile();
    }

    public static void parseWithDOM(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(filePath));

        String firstName = document.getElementsByTagName("firstName").item(0).getTextContent();
        String lastName = document.getElementsByTagName("lastName").item(0).getTextContent();
        String title = document.getElementsByTagName("title").item(0).getTextContent();
        String nationality = document.getElementsByTagName("nationality").item(0).getTextContent();
        String yearOfBirth = document.getElementsByTagName("yearOfBirth").item(0).getTextContent();
        String yearOfDeath = document.getElementsByTagName("yearOfDeath").item(0).getTextContent();

        String fileName = firstName + "_" + lastName + "_" + title + ".txt";
        NodeList lines = document.getElementsByTagName("line");

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
                writer.write("Author: " + firstName + " " + lastName + "\n");
                writer.write("Nationality: " + nationality + "\n");
                writer.write("Year of Birth: " + yearOfBirth + "\n");
                writer.write("Year of Death: " + yearOfDeath + "\n");
                writer.write("\nTitle: " + title + "\n\n");
                writer.write("Lines:\n");
                for(int i = 0; i< lines.getLength(); i++){
                    writer.write(lines.item(i).getTextContent() + "\n");
                }
            }
        System.out.println("Information was put in a file: " + fileName);
    }
}
