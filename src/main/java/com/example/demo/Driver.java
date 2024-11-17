package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {
    public static void main(String[] args) throws Exception {
        String jsonResponse = "{\"Name\": \"John is verified\", \"age\": 20}";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Student student = objectMapper.readValue(jsonResponse, Student.class);
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
        } catch (Exception e) {
//            throw new Exception("Issue in Json Parsing");
        }
    }
}
