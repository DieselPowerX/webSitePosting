/*
package pl.konrad.feak_news.model.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.konrad.feak_news.model.entities.PostEntity;
import pl.konrad.feak_news.model.entities.UserDetailsEntity;
import pl.konrad.feak_news.model.entities.UserEntity;
import pl.konrad.feak_news.model.forms.PostForm;
import pl.konrad.feak_news.model.forms.UserForm;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PostRepositoryTest {


    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    UserForm userForm;
    UserEntity userEntity;

    @BeforeEach
    void setup(){
        userForm = new UserForm("random","123","123","some@gmail.com", LocalDate.parse("1992-02-02"),"random","random","Warsaw", UserDetailsEntity.Status.ADMIN);
        userEntity = new UserEntity(userForm, new UserDetailsEntity(userForm));
    }

    @AfterEach

    @Test
    void givenPost_WhenFindByAuthor_ThenOk(){
        postRepository.save(new PostEntity(new PostForm("test","yes","non","random"),userRepository.getUserEntityByLogin(userEntity.getLogin()).get()));
        postRepository.save(new PostEntity(new PostForm("test","yes","non","random"),userRepository.getUserEntityByLogin(userEntity.getLogin()).get()));
        postRepository.save(new PostEntity(new PostForm("test","yes","non","random"),userRepository.getUserEntityByLogin(userEntity.getLogin()).get()));
        List<PostEntity> postsList = postRepository.findAllByAuthor("random");
        assertEquals(3, postsList.size());
    }
}
*/

//todo
