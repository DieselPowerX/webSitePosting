package pl.konrad.feak_news.model.forms;

import lombok.Data;
import pl.konrad.feak_news.model.entities.UserDetailsEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Data
public class UserForm {

    private String login;
    private String password;
    private String passwordRepeat;
    private String email;
    private LocalDate birthDate;
    private String name;
    private String surname;
    private String city;
    private UserDetailsEntity.Status status;

    public void setBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
