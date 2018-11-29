package pl.konrad.feak_news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.konrad.feak_news.model.UserSession;
import pl.konrad.feak_news.model.forms.UserForm;
import pl.konrad.feak_news.model.services.PostService;

@Controller
public class MainController {
    final
    PostService postService;
    UserSession userSession;

    @Autowired
    public MainController(PostService postService, UserSession userSession) {
        this.postService = postService;
        this.userSession = userSession;
    }

    @GetMapping("/")
    public String index(){

        return "redirect:/page/0";
    }

    @GetMapping("/page/{id}")
    public String indexOfPage(Model model, @PathVariable("id") int id ){
        model.addAttribute("news", postService.loadAllFeaks(id))
                .addAttribute("user",new UserForm())
                .addAttribute("loggedUser", userSession);

        return "user/posts/index";
    }

    @GetMapping("/post/news/{id}")
    public String indexOfNews(@PathVariable("id")int id, Model model){
        model.addAttribute("feakData", postService.getPageOfNews(id))
                .addAttribute("user",new UserForm())
                .addAttribute("loggedUser", userSession);

        return"user/post/index";
    }

}
