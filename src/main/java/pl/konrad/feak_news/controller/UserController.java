package pl.konrad.feak_news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;
import pl.konrad.feak_news.model.forms.UserForm;
import pl.konrad.feak_news.model.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    final
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String logingNewUser(HttpServletRequest request, @ModelAttribute UserForm userForm){
        userService.tryToLogIn(userForm);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @GetMapping("/registry")
    public String showRegistryTemp(Model model){
        model.addAttribute("user", new UserForm());
        return"/user/services/registry";
    }

    @PostMapping("/registry")
    public String registryUser(@ModelAttribute("user") UserForm user ){
        userService.addNewUser(user);

        return"redirect:/registry";
    }

    @GetMapping("/logout")
    public String logOut(HttpServletRequest request){
        userService.logOut();
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

}
