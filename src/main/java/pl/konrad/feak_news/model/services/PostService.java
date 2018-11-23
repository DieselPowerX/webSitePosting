package pl.konrad.feak_news.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.konrad.feak_news.model.entities.PostEntity;
import pl.konrad.feak_news.model.forms.PostForm;
import pl.konrad.feak_news.model.repositories.PostRepository;

import java.io.IOException;


@Service
public class PostService {
    final
    PostRepository postRepository;
    ImageService imageService;

    @Autowired
    public PostService(PostRepository postRepository, ImageService imageService) {
        this.postRepository = postRepository;
        this.imageService = imageService;
    }

    public Page<PostEntity> loadAllFeaks(int page){
        return postRepository.findAllByOrderByIdDesc(PageRequest.of(page,2));
    }

    public boolean addNews(PostForm postForm) throws IOException {
        imageService.addImage(postForm.getImageHeader(), postRepository.save(new PostEntity(postForm)).getId());
        return true;
    }



    public PostEntity getPageOfNews(int id) {
        return postRepository.findById(id);
    }
}
