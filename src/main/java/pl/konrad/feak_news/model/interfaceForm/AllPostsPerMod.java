package pl.konrad.feak_news.model.interfaceForm;

import java.time.LocalDateTime;

public interface AllPostsPerMod {
    String getLogin();
    int getId();
    String getTitle();
    LocalDateTime getDate();
    int getViews();

}

