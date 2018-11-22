package pl.konrad.feak_news.model.entities;

import lombok.Data;
import pl.konrad.feak_news.model.forms.PostForm;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "feak_news")
public class PostEntitie {
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


    public PostEntitie(PostForm postForm){
        this.title = postForm.getTitle();
        this.possibleFake = postForm.getPossibleFake();
        this.provement = postForm.getProvement();
        this.feakSource = postForm.getFeakSource();
        this.author = postForm.getAuthor();

    }

    public PostEntitie(){}

}
