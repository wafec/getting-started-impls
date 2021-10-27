package auth.controllers;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auth.models.auth.TokenModel;
import auth.services.auth.AuthService;

@RestController
public class AuthApi {
    private final AuthService authService;

    public AuthApi(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/token")
    public TokenModel token(@RequestParam MultiValueMap<String, String> body) {
        String accessToken = authService.createJWT(body.getFirst("client_secret"));
        return new TokenModel(accessToken);
    }
}
