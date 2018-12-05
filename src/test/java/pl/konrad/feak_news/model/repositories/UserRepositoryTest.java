package pl.konrad.feak_news.model.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.konrad.feak_news.model.entities.UserDetailsEntity;
import pl.konrad.feak_news.model.entities.UserEntity;
import pl.konrad.feak_news.model.forms.UserForm;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    UserForm userFo;
    UserDetailsEntity userDetailsEnti;
    UserEntity userEnti;

    @BeforeEach
    void setUp() {
        userFo = new UserForm("SomeGuy", "123", "123", "some@gmail.com", LocalDate.parse("1992-02-20", DateTimeFormatter.ofPattern("yyyy-MM-dd")), "Konrad", "Some", "Warsaw", UserDetailsEntity.Status.ADMIN);
        userDetailsEnti = new UserDetailsEntity(userFo);
        userEnti = new UserEntity(userFo, userDetailsEnti);
    }

    @AfterEach
    void after() {
        userRepository.delete(userEnti);
    }


    @Test
    void givenPost_WhenFindByAuthor_ThenOk(){

        userRepository.save(userEnti);
        assertNotNull(userRepository.findByLogin("SomeGuy"));
    }

}