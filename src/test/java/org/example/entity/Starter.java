package org.example.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Starter {
    public static void main(String[] args) throws JsonProcessingException {
        Student student1 = new Student();
        student1.setAge(18);
        student1.setName("Eva");
        student1.setSubjects(List.of("Math", "CS"));
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student1);
        System.out.println(json);
    }
}
