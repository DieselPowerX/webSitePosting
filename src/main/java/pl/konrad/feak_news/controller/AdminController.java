package pl.konrad.feak_news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.konrad.feak_news.model.UserSession;
import pl.konrad.feak_news.model.forms.PostForm;
import pl.konrad.feak_news.model.services.PostService;

import java.io.IOException;

@Controller
public class AdminController {
    final
    private PostService postService;
    private UserSession userSession;

    @Autowired
    public AdminController(PostService postService, UserSession userSession) {
        this.postService = postService;
        this.userSession = userSession;
    }


    @GetMapping("/admin/index")
    public String showAdminPage(Model model){
        model.addAttribute("newFeak", new PostForm())
                .addAttribute("author",userSession.getNick());

        return "admin/index";

    }

    @PostMapping("/admin/index")
    public String addNewFeak(@ModelAttribute PostForm postForm, RedirectAttributes redirectAttributes){
        try {
            redirectAttributes.addFlashAttribute("info", postService.addNews(postForm,userSession.getNick()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/index";
    }
}
