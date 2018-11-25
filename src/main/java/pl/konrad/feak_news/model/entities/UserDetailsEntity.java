package pl.konrad.feak_news.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.konrad.feak_news.model.forms.UserForm;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="user_more")
public class UserDetailsEntity {
    @Id
    @GeneratedValue
    private int id;

    private String email;
    @Column(name="date_of_birth")
    private String birthDay;

    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private UserEntity.Status status;


    public UserDetailsEntity (UserForm user){
        this.email = user.getEmail();
        this.birthDay = user.getBirthDate();
        this.name = user.getName();
        this.surname = user.getSurname();
    }
}
