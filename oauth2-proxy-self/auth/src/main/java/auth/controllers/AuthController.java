package auth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView login(@ModelAttribute LoginModel login) {
        
        return new ModelAndView("redirect:" + login.getRedirectUri());
    }
}
