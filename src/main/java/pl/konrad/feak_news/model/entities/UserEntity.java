package pl.konrad.feak_news.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;

    private String login;
    private String password;

}
