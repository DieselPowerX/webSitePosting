package pl.konrad.feak_news.model.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.konrad.feak_news.dtos.WeatherDto;

@Service
public class WeatherApiSerivce {


    @Value("${api.key}")
    String apiKey;

    public WeatherDto loadWeatherForCity(String city){
        return getRestTemplate().getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey ,WeatherDto.class);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
