package pl.konrad.feak_news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.konrad.feak_news.model.forms.UserForm;
import pl.konrad.feak_news.model.services.UserService;

@Controller
public class UserController {

    final
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginTemp(Model model){
        model.addAttribute("user",new UserForm());

        return"/user/service/login";
    }

    @PostMapping("/login")
    public String logingNewUser(@ModelAttribute UserForm userForm){
        userService.checkIfUserExist(userForm);

        return"redirect:/login";
    }
}
