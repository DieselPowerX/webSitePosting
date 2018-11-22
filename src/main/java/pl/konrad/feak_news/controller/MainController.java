package pl.konrad.feak_news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.konrad.feak_news.model.services.PostService;

@Controller
public class MainController {
    final
    PostService postService;

    @Autowired
    public MainController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String index(){

        return "redirect:/page/0";
    }
    @GetMapping("/page/{id}")
    public String indexOfPage(Model model, @PathVariable("id") int id){
        model.addAttribute("news", postService.loadAllFeaks(id));

        return "user/posts/index";
    }

    @GetMapping("/post/news/{id}")
    public String indexOfNews(@PathVariable("id")int id, Model model){
        model.addAttribute("feakData", postService.getPageOfNews(id));
        return"user/post/index";
    }

}
