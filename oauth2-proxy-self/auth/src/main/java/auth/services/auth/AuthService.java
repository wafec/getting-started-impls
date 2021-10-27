package auth.services.auth;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;

@Service
public class AuthService {
    public AuthService() {

    }

    public String createJWT(String apiKeySecret) {
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = Decoders.BASE64.decode(apiKeySecret);
        Key key = new SecretKeySpec(apiKeySecretBytes, algorithm.getJcaName());
        JwtBuilder builder = Jwts.builder().setSubject("Joe").signWith(key);
        
        return builder.compact();
    }
}
