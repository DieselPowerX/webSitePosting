package pl.konrad.feak_news.model.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.konrad.feak_news.model.UserSession;
import pl.konrad.feak_news.model.entities.UserDetailsEntity;
import pl.konrad.feak_news.model.entities.UserEntity;
import pl.konrad.feak_news.model.forms.UserForm;
import pl.konrad.feak_news.model.repositories.UserDetailsRepository;
import pl.konrad.feak_news.model.repositories.UserRepository;

import java.util.Optional;


@Service
public class UserService {

    final
    UserRepository userRepository;
    UserDetailsRepository userDetailsRepository;
    PasswordHashService passwordHashService;
    UserSession userSession;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserDetailsRepository userDetailsRepository,
                       PasswordHashService passwordHashService, UserSession userSession) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.passwordHashService = passwordHashService;
        this.userSession = userSession;
    }

    public void tryToLogIn(UserForm userForm){

        Optional<UserEntity> user = userRepository.getUserEntityByLogin(userForm.getLogin());
        if(user.isPresent()&& passwordHashService.matches(userForm.getPassword(),user.get().getPassword())){
            userSession.setLogin(true);
            userSession.setNick(userForm.getLogin());
        }

    }


    public void addNewUser(UserForm user) {


        UserDetailsEntity userDetails = new UserDetailsEntity(user);
        userRepository.save(new UserEntity(getHashedPassword(user),userDetails));
    }

    public void getDetails(){
        System.out.println(userRepository.findById(1).toString());
    }

    private UserForm getHashedPassword(UserForm userForm){
        userForm.setPassword(passwordHashService.hash(userForm.getPassword()));
        return userForm;
    }
}
