package pl.konrad.feak_news.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.konrad.feak_news.model.forms.UserForm;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="user_more")
public class UserDetailsEntity {
    public enum Status{
        USER,ADMIN,MODERATOR
    }

    @Id
    @GeneratedValue
    private int id;

    private String email;
    @Column(name="date_of_birth")
    private LocalDate birthDay;

    private String name;
    private String surname;
    private String city;

    @Enumerated(EnumType.STRING)
    private Status status;



    public UserDetailsEntity (UserForm user){
        this.email = user.getEmail();
        this.birthDay = user.getBirthDate();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.city = user.getCity();
        this.status = user.getStatus();
    }
}
