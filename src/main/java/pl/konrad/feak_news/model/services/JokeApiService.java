package pl.konrad.feak_news.model.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.konrad.feak_news.dtos.JokesDto;

@Service
public class JokeApiService {

    public String loadRandomJoke(){
        return loadChackAppi().getValue();
    }

    public JokesDto loadChackAppi(){
        return getRestTemplate().getForObject("https://api.chucknorris.io/jokes/random?category=dev",JokesDto.class);
    }
    private RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
