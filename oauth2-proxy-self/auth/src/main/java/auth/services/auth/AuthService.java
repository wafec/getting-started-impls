package auth.services.auth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.ParseException;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.util.IOUtils;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;

@Service
public class AuthService {
    @Value("${application.secrets.rsa.private}")
    private String rsaPrivateKey;
    @Value("${application.secrets.rsa.public}")
    private String rsaPublicKey;

    public AuthService() {

    }

    public String createJWT(String apiKeySecret) {
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = Decoders.BASE64.decode(apiKeySecret);
        Key key = new SecretKeySpec(apiKeySecretBytes, algorithm.getJcaName());
        JwtBuilder builder = Jwts.builder()
            .setSubject("Joe")
            .signWith(key)
            .setIssuer("http://auth.localhost:8080")
            .setAudience("proxy")
            .setExpiration(DateUtils.addDays(new Date(), 1));
        
        return builder.compact();
    }

    public String createIdToken() throws
    NoSuchAlgorithmException, InvalidKeySpecException,
    FileNotFoundException, IOException,
    ParseException, JOSEException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("/static/.well-known/jwks.json");
        String jwksString = IOUtils.readInputStreamToString(in);
        
        JWKSet jwks = JWKSet.parse(jwksString);
        
        SignatureAlgorithm algorithm = SignatureAlgorithm.RS256;
        /*byte[] secretBytes = Decoders.BASE64.decode(rsaPrivateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(secretBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = kf.generatePrivate(keySpec);*/
        PrivateKey privateKey = jwks.getKeys().get(0).toRSAKey().toPrivateKey();
        JwtBuilder builder = Jwts.builder()
            .setSubject("Joe")
            .signWith(privateKey, algorithm)
            .setIssuer("http://auth.localhost:8080")
            .setAudience("proxy")
            .setExpiration(DateUtils.addDays(new Date(), 1));
        return builder.compact();
    }
}
