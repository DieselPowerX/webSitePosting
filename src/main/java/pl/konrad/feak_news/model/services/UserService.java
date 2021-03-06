package pl.konrad.feak_news.model.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.konrad.feak_news.model.UserSession;
import pl.konrad.feak_news.model.entities.UserDetailsEntity;
import pl.konrad.feak_news.model.entities.UserEntity;
import pl.konrad.feak_news.model.forms.UserForm;
import pl.konrad.feak_news.model.repositories.UserRepository;

import java.util.Optional;


@Service
public class UserService {

    final
    private UserRepository userRepository;
    private PasswordHashService passwordHashService;
    private UserSession userSession;
    private WeatherApiSerivce weatherApiSerivce;

    @Autowired
    public UserService(UserRepository userRepository, PasswordHashService passwordHashService,
                       UserSession userSession, WeatherApiSerivce weatherApiSerivce) {
        this.userRepository = userRepository;
        this.passwordHashService = passwordHashService;
        this.userSession = userSession;
        this.weatherApiSerivce = weatherApiSerivce;
    }

    public void tryToLogIn(UserForm userForm){

        Optional<UserEntity> user = userRepository.getUserEntityByLogin(userForm.getLogin());
        if(user.isPresent()&& passwordHashService.matches(userForm.getPassword(),user.get().getPassword())){
            userSession.setLogin(true);
            userSession.setNick(user.get().getLogin());
            userSession.setStatus(user.get().getUserDetails().getStatus());
            userSession.setWeatherDto(weatherApiSerivce.loadWeatherForCity(user.get().getUserDetails().getCity()));
        }

    }


    public String addNewUser(UserForm user) {
        if(getError(user).equals("user added")) {
            userRepository.save(new UserEntity(getHashedPassword(user)));
            return "user added";
        }else {
            return getError(user);
        }
    }

    private String getError(UserForm user) {
        if(checkIfUserExist(user.getLogin())){
            return "User with this login already exist";
        }else if(!matchedPasswords(user)){
            return "Passwords are not matched";
        }else {
            return "user added";
        }

    }

    private boolean matchedPasswords(UserForm user) {
        return user.getPassword().equals(user.getPasswordRepeat());
    }


    private boolean checkIfUserExist(String login) {
        return userRepository.getUserEntityByLogin(login).isPresent();

    }

    public Optional<UserEntity> getUserByLogin(String login){
        return userRepository.getUserEntityByLogin(login);
    }

    private UserForm getHashedPassword(UserForm userForm){
        userForm.setPassword(passwordHashService.hash(userForm.getPassword()));
        return userForm;
    }

    public void logOut() {
        userSession.setStatus(null);
        userSession.setLogin(false);
        userSession.setNick(null);
        userSession.setWeatherDto(null);
    }
}
