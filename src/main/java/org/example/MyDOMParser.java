package org.example;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import org.w3c.dom.*;


public class MyDOMParser {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = (Document) builder.parse(new File("src/main/resources/students.xml"));
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            NodeList nodeList = root.getElementsByTagName("student");
            for(int i=0; i<nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element student = (Element) node;
                    String id = student.getAttribute("id");
                    String name = student.getElementsByTagName("name").item(0).getTextContent();
                    String age = student.getElementsByTagName("age").item(0).getTextContent();
                    String subject = student.getElementsByTagName("subject").item(0).getTextContent();
                    System.out.println(id + " " + name + " " + age + " " + subject);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
