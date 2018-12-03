package pl.konrad.feak_news.model.forms;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class PostForm {
    private String title;
    private String possibleFake;
    private String provement;
    private String feakSource;
    private MultipartFile imageHeader;

}
