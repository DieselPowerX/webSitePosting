package pl.konrad.feak_news.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.konrad.feak_news.model.forms.PostForm;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "feak_news")
@NoArgsConstructor
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
    private int views;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="news_user")
    private UserEntity userEntity;


    public PostEntity(PostForm postForm, UserEntity userEntity){
        this.title = postForm.getTitle();
        this.possibleFake = postForm.getPossibleFake();
        this.provement = postForm.getProvement();
        this.feakSource = postForm.getFeakSource();
        this.author = userEntity.getLogin();
        this.userEntity = userEntity;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public PostEntity(PostForm postForm){
        this.title = postForm.getTitle();
        this.possibleFake = postForm.getPossibleFake();
        this.provement = postForm.getProvement();
        this.feakSource = postForm.getFeakSource();
    }
}
