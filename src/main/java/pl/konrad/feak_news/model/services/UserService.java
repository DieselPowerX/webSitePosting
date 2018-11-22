package pl.konrad.feak_news.model.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.konrad.feak_news.model.forms.UserForm;
import pl.konrad.feak_news.model.repositories.UserRepository;

@Service
public class UserService {

    final
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void logUserIn(UserForm userForm){

    }

    public boolean checkIfUserExist(UserForm userForm){
        if(userRepository.findByLoginAndPassword(userForm.getLogin(),userForm.getPassword()).isPresent()){
            return true;
        }
        return false;
    }
}
