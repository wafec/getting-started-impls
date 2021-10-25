package auth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.models.oidc.OidcConfiguration;

@RestController
public class OidcController {
    @GetMapping("/.well-known/openid-configuration")
    public OidcConfiguration configuration() {
        OidcConfiguration configuration = new OidcConfiguration();
        configuration.setIssuer("http://auth.localhost:8080");
        configuration.setAuthorizationEndpoint("http://auth.localhost:8080/auth/authorize");
        configuration.setTokenEndpoint("http://auth.localhost:8080/auth/token");
        configuration.setIntrospectionEndpoint("http://auth.localhost:8080/auth/introspect");
        configuration.setRevocationEndpoint("http://auth.localhost:8080/auth/revoke");
        configuration.setJwksUri("http://auth.localhost:8080/.well-known/jwks.json");
        return configuration;
    }
}
