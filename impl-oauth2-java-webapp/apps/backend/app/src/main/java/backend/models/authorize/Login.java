package backend.models.authorize;

import lombok.Data;

@Data public class Login {
    private String user;
    private String password;
    private String redirectUrl;
}
