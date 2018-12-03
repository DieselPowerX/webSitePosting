package pl.konrad.feak_news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.konrad.feak_news.model.services.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostsController {

    final
    PostService postService;

    @Autowired
    public PostsController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/post/delete/{id}")
    public String removePost(@PathVariable("id") int id, HttpServletRequest request){
        postService.removePostById(id);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
