package pl.konrad.feak_news.model.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.konrad.feak_news.model.entities.PostEntity;
import pl.konrad.feak_news.model.entities.UserDetailsEntity;
import pl.konrad.feak_news.model.entities.UserEntity;
import pl.konrad.feak_news.model.forms.PostForm;
import pl.konrad.feak_news.model.forms.UserForm;
import static org.junit.jupiter.api.Assertions.*;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class PostRepositoryTest {


    @Resource
    private PostRepository postRepository;
    private UserRepository userRepository;

    @Before
    public void setup(){
        UserForm userForm = new UserForm("SomeGuy","123","123","some@gmail.com", LocalDate.parse("1992-02-02"),"Konrad","Some","Warsaw", UserDetailsEntity.Status.ADMIN);

        UserEntity userEntity = new UserEntity(userForm, new UserDetailsEntity(userForm));
        userRepository.save(userEntity);
        postRepository.save(new PostEntity(new PostForm("test","yes","non","random"),userEntity));
        postRepository.save(new PostEntity(new PostForm("test","yes","non","random"),userEntity));
        postRepository.save(new PostEntity(new PostForm("test","yes","non","random"),userEntity));
    }

    @Test
    public void givenPost_WhenFindByAuthor_ThenOk(){
        List<PostEntity> postsList = postRepository.findAllByAuthor("SomeGuy");
        assertEquals("size incorrect", postsList.size());
    }
}