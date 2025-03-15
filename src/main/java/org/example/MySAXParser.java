package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class MySAXParser {
    public static void main(String[] args) {
        try{
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            StudentHandler studentHandler = new StudentHandler();
            saxParser.parse(new File("src/main/resources/students.xml"), studentHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class StudentHandler extends DefaultHandler {
    private String currentID;
    private String currentElement;
    private StringBuilder text;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        text = new StringBuilder();
        if(qName.equalsIgnoreCase("students")){
            currentID = attributes.getValue("id");
            System.out.println(currentID);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("name"))
            System.out.println(text.toString().trim());
        else if(qName.equalsIgnoreCase("age"))
            System.out.println(text.toString().trim());
        else if(qName.equalsIgnoreCase("subject"))
            System.out.println(text.toString().trim());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(text!=null)
            text.append(ch, start, length);
    }
}

