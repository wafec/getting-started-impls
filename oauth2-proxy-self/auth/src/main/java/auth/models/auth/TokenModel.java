package auth.models.auth;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenModel {
    private String accessToken;
    private String idToken;
    private Date createdAt;
    private Date expiresOn;
    private String tokenType;
}
