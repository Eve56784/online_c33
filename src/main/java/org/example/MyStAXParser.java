package org.example;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyStAXParser {
    public static void main(String[] args) {
        try{
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                  factory.createXMLEventReader(Files.newInputStream(Paths.get("src/main/resources/students.xml")));
            String currentID;
            String currentElement = null;
            while(eventReader.hasNext()){
                XMLEvent event = eventReader.nextEvent();
                if(event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    currentElement = startElement.getName().getLocalPart();
                    if (currentElement.equalsIgnoreCase("students")) {
                        if (startElement.getAttributeByName(QName.valueOf("id")) != null) {
                            currentID = startElement.getAttributeByName(QName.valueOf("id")).getValue();
                            System.out.print(currentID + " ");
                        }
                    }
                }
                if(event.isCharacters()&&currentElement!=null){
                    Characters characters = event.asCharacters();
                    if(currentElement.equalsIgnoreCase("name"))
                        System.out.print(characters.getData().trim() + " ");
                    else if(currentElement.equalsIgnoreCase("age"))
                        System.out.print(characters.getData().trim() + " ");
                    else if(currentElement.equalsIgnoreCase("subject"))
                        System.out.print(characters.getData().trim() + " \n");
                }
                if(event.isEndElement())
                    currentElement=null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
