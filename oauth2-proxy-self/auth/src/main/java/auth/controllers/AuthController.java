package auth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import auth.models.auth.LoginModel;
import auth.services.auth.AuthService;

@Controller
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/auth/authorize")
    public String login(Model model) {
        model.addAttribute("login", new LoginModel());
        return "login";
    }

    @PostMapping("/auth/authorize")
    public ModelAndView login(@ModelAttribute LoginModel login,
        @RequestParam("state") String state,
        @RequestParam("redirect_uri") String redirectUri) {
        if (login.getUsername().equals("wallace") && login.getPassword().equals("wallace-123")) {
            String targetUri = UriComponentsBuilder
                .fromUriString(redirectUri)
                .queryParam("state", state)
                .queryParam("code", "1000").toUriString();
            return new ModelAndView("redirect:" + targetUri);
        }
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("login", login);
        return modelAndView;
    }
}
