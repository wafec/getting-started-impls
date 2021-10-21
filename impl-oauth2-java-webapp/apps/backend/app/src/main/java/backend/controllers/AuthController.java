package backend.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.models.auth.JavaWebToken;

@RestController("/oauth")
public class AuthController {
    @PostMapping
    public JavaWebToken Get() {
        return null;
    }
}
