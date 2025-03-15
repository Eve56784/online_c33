package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SAXHandler extends DefaultHandler {
    private String currentElement;
    private String firstName;
    private String lastName;
    private String title;
    private StringBuilder content;
    private StringBuilder lines;
    private String nationality;
    private String yearOfBirth;
    private String yearOfDeath;

    public SAXHandler() {
        this.content = new StringBuilder();
        this.lines = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String data = content.toString().trim();
        switch (qName.toLowerCase()) {
            case "firstname":
                firstName = data; break;
            case "lastname":
                lastName = data; break;
            case "title":
                title = data; break;
            case "nationality":
                nationality = data; break;
            case "yearofbirth":
                yearOfBirth = data; break;
            case "yearofdeath":
                yearOfDeath = data; break;
            case "line":
                lines.append(data).append(System.lineSeparator()); break;
        }
        content.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content.append(ch, start, length);
    }

    public void writeToFile(){
        if (firstName == null || lastName == null || title == null)
            System.out.println("Data is missing");
        String fileName = firstName + "_" + lastName + "_" + title + ".txt";
        try(BufferedWriter writer = Files.newBufferedWriter(Path.of(fileName))) {
            writer.write("Author: " + firstName + " " + lastName + "\n");
            writer.write("Nationality: " + nationality + "\n");
            writer.write("Year of Birth: " + yearOfBirth + "\n");
            writer.write("Year of Death: " + yearOfDeath + "\n");
            writer.write("\nTitle: " + title + "\n\n");
            writer.write("Lines:\n");
            writer.write(lines.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
}
