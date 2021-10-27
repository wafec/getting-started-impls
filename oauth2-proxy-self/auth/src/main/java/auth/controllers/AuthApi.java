package auth.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

import com.nimbusds.jose.JOSEException;

import org.apache.commons.lang3.time.DateUtils;
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
    public TokenModel token(@RequestParam MultiValueMap<String, String> body) throws
        NoSuchAlgorithmException, InvalidKeySpecException,
        FileNotFoundException, IOException,
        ParseException, JOSEException {
        for (String k : body.keySet()) {
            System.out.println(String.format("%s: %s", k, body.getFirst(k)));
        }
        String accessToken = authService.createJWT(body.getFirst("client_secret"));
        String idToken = authService.createIdToken();
        TokenModel token = new TokenModel();
        token.setAccessToken(accessToken);
        token.setCreatedAt(new Date());
        token.setTokenType("Bearer");
        token.setIdToken(idToken);
        token.setExpiresOn(DateUtils.addDays(new Date(), 1));
        return token;
    }
}
