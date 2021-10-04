package authserver;

import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authservice")
public class AuthServiceController {
    @Data
    static class User {
        private String name;
    }

    @GetMapping
    public String index() {
        return "Hello";
    }

    @GetMapping("/test/{name}")
    public User test(@PathVariable("name") String name) {
        User user = new User();
        user.setName(name);
        return user;
    }
}