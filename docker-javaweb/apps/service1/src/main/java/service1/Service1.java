package service1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service1 {
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}