package pl.konrad.feak_news.model.entities;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import pl.konrad.feak_news.model.forms.PostForm;
import pl.konrad.feak_news.model.services.UserService;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "feak_news")
public class PostEntity {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    @Column(name= "possible_fake")
    private String possibleFake;
    private String provement;
    @Column(name= "feak_source")
    private String feakSource;
    private String author;
    private LocalDateTime date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="news_user")
    private UserEntity userEntity;



    public PostEntity(PostForm postForm, UserEntity userEntity){
        this.title = postForm.getTitle();
        this.possibleFake = postForm.getPossibleFake();
        this.provement = postForm.getProvement();
        this.feakSource = postForm.getFeakSource();
        this.author = postForm.getAuthor();
        this.userEntity = userEntity;

    }

    public PostEntity(){}

}
