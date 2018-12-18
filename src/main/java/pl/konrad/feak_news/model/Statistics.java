package pl.konrad.feak_news.model;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.konrad.feak_news.model.repositories.PostRepository;

import java.time.LocalDateTime;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Data
public class Statistics {
    final
    PostRepository postRepository;
    Map<LocalDateTime,Integer> ammountOfViews;


    @Autowired
    public Statistics(PostRepository postRepository){
        ammountOfViews = new LinkedHashMap<>();
        this.postRepository = postRepository;
    }

    @Scheduled(fixedDelay = 60000)
    public void countAmounOfViews(){
        if (postRepository.getAllViews().isPresent()) {
            ammountOfViews.put(LocalDateTime.now(), postRepository.getAllViews().get());
        }
    }

    public void resetCounterOfViews(){
        ammountOfViews.clear();
    }
}
