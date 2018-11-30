package pl.konrad.feak_news.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JokesDto {

    @JsonProperty("value")
    private String value;

}
