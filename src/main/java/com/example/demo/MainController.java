package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/main")
    public Student getMein(@RequestBody Student student){
        Student obj = new Student();
        obj.setName(student.getName()+" is verified");
        return obj;
    }

}
