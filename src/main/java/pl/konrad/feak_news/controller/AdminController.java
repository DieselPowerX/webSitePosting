package pl.konrad.feak_news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.konrad.feak_news.model.UserSession;
import pl.konrad.feak_news.model.forms.PostForm;
import pl.konrad.feak_news.model.services.AdminSerivce;
import pl.konrad.feak_news.model.services.PostService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class AdminController {
    final
    private AdminSerivce adminSerivce;
    private UserSession userSession;

    @Autowired
    public AdminController(AdminSerivce adminSerivce, UserSession userSession) {
        this.adminSerivce = adminSerivce;
        this.userSession = userSession;
    }


    @GetMapping("/admin/index")
    public String showAdminPage(Model model){
        model.addAttribute("newFeak", new PostForm())
                .addAttribute("loggedUser",userSession);
        adminSerivce.showCount();

        return "admin/index";

    }

    @PostMapping("/admin/index")
    public String addNewFeak(@ModelAttribute PostForm postForm, RedirectAttributes redirectAttributes){
        try {
            redirectAttributes.addFlashAttribute("info", adminSerivce.addNews(postForm,userSession.getNick()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/index";
    }

    @GetMapping("/post/delete/{id}")
    public String removePost(@PathVariable("id") int id, HttpServletRequest request){
        adminSerivce.removePostById(id);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

}
