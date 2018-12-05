package pl.konrad.feak_news.model.forms;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@NoArgsConstructor
public class PostForm {
    private String title;
    private String possibleFake;
    private String provement;
    private String feakSource;
    private MultipartFile imageHeader;

    public PostForm(String title, String possibleFake, String provement, String feakSource) {
        this.title = title;
        this.possibleFake = possibleFake;
        this.provement = provement;
        this.feakSource = feakSource;
    }
}
