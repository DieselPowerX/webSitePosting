package pl.konrad.feak_news.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.konrad.feak_news.model.UserSession;
import pl.konrad.feak_news.model.entities.PostEntity;
import pl.konrad.feak_news.model.forms.PostForm;
import pl.konrad.feak_news.model.repositories.PostRepository;

import java.io.IOException;


@Service
public class PostService {
    final
    PostRepository postRepository;


    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<PostEntity> loadAllFeaks(int page){
        return postRepository.findAllByOrderByIdDesc(PageRequest.of(page,2));
    }

    public PostEntity getPageOfNews(int id) {
        postRepository.updateViews(id);
        return postRepository.findById(id);
    }

}
