package pl.konrad.feak_news.model.forms;

import lombok.Data;


@Data

public class PostsByUserData {
    long count;
    String login;

    public PostsByUserData(long count, String login) {
        this.count = count;
        this.login = login;
    }
}
