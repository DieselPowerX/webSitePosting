package pl.konrad.feak_news.model.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.konrad.feak_news.model.entities.UserDetailsEntity;
import pl.konrad.feak_news.model.entities.UserEntity;
import pl.konrad.feak_news.model.forms.UserForm;
import pl.konrad.feak_news.model.repositories.UserDetailsRepository;
import pl.konrad.feak_news.model.repositories.UserRepository;


@Service
public class UserService {

    final
    UserRepository userRepository;
    UserDetailsRepository userDetailsRepository;
    PasswordHashService passwordHashService;

    @Autowired
    public UserService(UserRepository userRepository, UserDetailsRepository userDetailsRepository, PasswordHashService passwordHashService) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.passwordHashService = passwordHashService;
    }

    public void logUserIn(UserForm userForm){

    }

    public boolean checkIfUserExist(UserForm userForm){
        if(userRepository.findByLoginAndPassword(userForm.getLogin(),userForm.getPassword()).isPresent()){
            return true;
        }
        return false;
    }

    public void addNewUser(UserForm user) {

        UserDetailsEntity userDetails = new UserDetailsEntity(user);
        userDetailsRepository.save(userDetails);
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
