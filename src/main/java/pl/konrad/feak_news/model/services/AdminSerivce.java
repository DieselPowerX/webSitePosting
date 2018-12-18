package pl.konrad.feak_news.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.konrad.feak_news.model.entities.PostEntity;
import pl.konrad.feak_news.model.entities.UserDetailsEntity;
import pl.konrad.feak_news.model.entities.UserEntity;
import pl.konrad.feak_news.model.forms.PostForm;
import pl.konrad.feak_news.model.forms.UserForm;
import pl.konrad.feak_news.model.interfaceForm.AllPostsPerMod;
import pl.konrad.feak_news.model.interfaceForm.StatisticsOfPostsByModerators;
import pl.konrad.feak_news.model.repositories.PostRepository;
import pl.konrad.feak_news.model.repositories.UserRepository;

import java.io.IOException;
import java.util.List;

@Service
public class AdminSerivce {
    final
    PostRepository postRepository;
    ImageService imageService;
    UserService userService;
    UserRepository userRepository;

    @Autowired
    public AdminSerivce(PostRepository postRepository, ImageService imageService, UserService userService, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.imageService = imageService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public void removePostById(int id) throws IOException {
        postRepository.deleteById(id);
        imageService.removeImage(id);
    }

    public boolean addNews(PostForm postForm, String nick) throws IOException {
        imageService.addImage(postForm.getImageHeader(), postRepository.save(new PostEntity(postForm,userService.getUserByLogin(nick).get())).getId());
        return true;
    }

    public List<StatisticsOfPostsByModerators> showCount(){

        return postRepository.find();
    }

    public List<AllPostsPerMod> findAllPostsPerMod(){

        return postRepository.findAllPostsPerMod();
    }

    public int countMaxPostBySingleUser(){
        return postRepository.maxNumbersOfPostBySingleMod().isPresent()? postRepository.maxNumbersOfPostBySingleMod().get():0;
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public void removeUserById(int id) {

        userRepository.deleteById(id);

    }

    public void editUser(UserForm userForm, int id) {
        UserEntity user = userRepository.findById(id).get();
        UserDetailsEntity userDetails = user.getUserDetails();

        user.setLogin(userForm.getLogin());
        userDetails.setName(userForm.getName());
        userDetails.setSurname(userForm.getSurname());
        userDetails.setEmail(userForm.getEmail());
        userDetails.setBirthDay(userForm.getBirthDate());
        userDetails.setCity(userForm.getCity());
        userDetails.setStatus(userForm.getStatus());

        user.setUserDetails(userDetails);

        userRepository.save(user);
    }
}
