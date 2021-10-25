package auth.models.auth;

import lombok.Data;

@Data
public class LoginModel {
    private String username;
    private String password;
    private String approvalPrompt;
    private String clientID;
    private String redirectUri;
    private String responseType;
    private String scope;
    private String state;

    public LoginModel() {

    }
}
