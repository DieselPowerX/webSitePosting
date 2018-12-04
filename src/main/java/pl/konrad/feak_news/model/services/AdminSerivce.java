package pl.konrad.feak_news.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.konrad.feak_news.model.entities.PostEntity;
import pl.konrad.feak_news.model.forms.PostForm;
import pl.konrad.feak_news.model.forms.PostsByUserData;
import pl.konrad.feak_news.model.repositories.PostRepository;

import java.io.IOException;
import java.util.Map;

@Service
public class AdminSerivce {
    final
    PostRepository postRepository;
    ImageService imageService;
    UserService userService;

    @Autowired
    public AdminSerivce(PostRepository postRepository, ImageService imageService, UserService userService) {
        this.postRepository = postRepository;
        this.imageService = imageService;
        this.userService = userService;
    }

    public void removePostById(int id) {
        postRepository.deleteById(id);
    }

    public boolean addNews(PostForm postForm, String nick) throws IOException {
        imageService.addImage(postForm.getImageHeader(), postRepository.save(new PostEntity(postForm,userService.getUserByLogin(nick).get())).getId());
        return true;
    }

    public void showCount(){
        System.out.println(postRepository.find().get(1).entrySet());
    }
}
