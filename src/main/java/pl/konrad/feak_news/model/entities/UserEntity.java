package pl.konrad.feak_news.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.konrad.feak_news.model.forms.UserForm;
import javax.persistence.*;



@Entity
@NoArgsConstructor
@Data
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue
    private int id;

    private String login;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details")
    private UserDetailsEntity userDetails;

    public UserEntity(UserForm user, UserDetailsEntity userDetails){
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.userDetails = userDetails;
    }





}
