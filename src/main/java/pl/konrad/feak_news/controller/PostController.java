package pl.konrad.feak_news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.konrad.feak_news.model.forms.PostForm;
import pl.konrad.feak_news.model.services.PostService;

import java.io.IOException;

@Controller
public class PostController {
    final
    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/admin/index")
    public String showAdminPage(Model model){
        model.addAttribute("newFeak", new PostForm());

        return "admin/index";

    }

    @PostMapping("/admin/index")
    public String addNewFeak(@ModelAttribute PostForm postForm, RedirectAttributes redirectAttributes){
        try {
            redirectAttributes.addFlashAttribute("info", postService.addNews(postForm));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/index";
    }
}
