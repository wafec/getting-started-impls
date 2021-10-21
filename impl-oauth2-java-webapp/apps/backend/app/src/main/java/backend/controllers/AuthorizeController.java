package backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import backend.models.authorize.Login;

@Controller
@RequestMapping("/authorize")
public class AuthorizeController {
    @GetMapping
    public String get(Model model) {
        Login login = new Login();
        model.addAttribute("login", login);
        return "authorize";
    }
    
    @PostMapping
    public ModelAndView post(@ModelAttribute Login login) {
        if (login.getUser() != null && !login.getUser().isEmpty() &&
        login.getPassword() != null && !login.getPassword().isEmpty()) {
            return new ModelAndView("redirect:" + login.getRedirectUrl());
        } else {
            ModelAndView modelAndView = new ModelAndView("authorize");
            modelAndView.addObject("login", login);
            return modelAndView;
        }
    }
}
