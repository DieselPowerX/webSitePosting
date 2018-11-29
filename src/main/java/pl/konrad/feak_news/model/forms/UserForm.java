package pl.konrad.feak_news.model.forms;

import lombok.Data;
import pl.konrad.feak_news.model.entities.UserDetailsEntity;



@Data
public class UserForm {

    private String login;
    private String password;
    private String email;
    private String birthDate;
    private String name;
    private String surname;
    private UserDetailsEntity.Status status;


}
