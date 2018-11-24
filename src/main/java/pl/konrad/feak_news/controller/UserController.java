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

    @PostMapping("/login")
    public String logingNewUser(@ModelAttribute UserForm userForm){

        userService.tryToLogIn(userForm);

        return"redirect:/page/0";
    }

    @GetMapping("/registry")
    public String showRegistryTemp(Model model){
        model.addAttribute("user", new UserForm());
        return"/user/service/registry";
    }

    @PostMapping("/registry")
    public String registryUser(@ModelAttribute("user") UserForm user ){
        userService.addNewUser(user);

        return"redirect:/registry";
    }

}
