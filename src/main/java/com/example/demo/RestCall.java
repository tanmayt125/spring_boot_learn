package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class RestCall {

    private final WebClient webClient;

    public RestCall(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }
    @GetMapping("/restCallToHello")
    public String call(){
        System.out.println("Hello");
        try {
            Mono<String> response = this.webClient
                    .get()
                    .uri("/hello") // Add your endpoint here
                    .headers(headers -> headers.setBasicAuth("admin", "admin"))
                    .retrieve()
                    .bodyToMono(String.class);

            return response.block();
        }
        catch (Exception e){
            return "Sorry exception occurs" + e.getMessage();
        }
    }

    @PostMapping("/sendStudent")
    public Mono<Student> sendStudentToMain(@RequestBody Student student) {
        return this.webClient.post()
                .uri("/main") // This is the endpoint of your MainController
                .headers(headers -> headers.setBasicAuth("admin", "admin"))
                .body(Mono.just(student), Student.class)
                .retrieve()
                .bodyToMono(Student.class);
    }

}
