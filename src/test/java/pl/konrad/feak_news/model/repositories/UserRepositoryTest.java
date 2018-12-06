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

    UserForm userForm;
    UserDetailsEntity userDetailsEntity;
    UserEntity userEntity;

    @BeforeEach
    void setUp() {
        userForm = new UserForm("SomeGuy", "123", "123", "some@gmail.com", LocalDate.parse("1992-02-20", DateTimeFormatter.ofPattern("yyyy-MM-dd")), "Konrad", "Some", "Warsaw", UserDetailsEntity.Status.ADMIN);
        userDetailsEntity = new UserDetailsEntity(userForm);
        userEntity = new UserEntity(userForm, userDetailsEntity);
    }

    @AfterEach
    void after() {
        userRepository.delete(userEntity);
    }


    @Test
    void givenUser_FindByLogin_ThenRemoveUser(){
        userRepository.save(userEntity);
        assertEquals(userEntity,userRepository.getUserEntityByLogin(userForm.getLogin()).get());
    }

}