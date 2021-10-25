package auth.models.oidc;

import lombok.Data;

@Data
public class OidcConfiguration {
    private String issuer;
    private String authorizationEndpoint;
    private String jwksUri;
    private String[] responseTypesSupported;
    private String[] subjectTypesSupported;
    private String[] idTokenSigningAlgValuesSupported;
    private String tokenEndpoint;
    private String introspectionEndpoint;
    private String revocationEndpoint;

    public OidcConfiguration() {
        
    }
}
