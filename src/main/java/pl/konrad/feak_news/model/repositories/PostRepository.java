package pl.konrad.feak_news.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.konrad.feak_news.model.entities.PostEntity;
import java.util.List;
import java.util.Map;


@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer> {
    Page<PostEntity> findAllByOrderByIdDesc(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM feak_news WHERE id=?1" )
    PostEntity findById(int id);

    @Query(nativeQuery = true, value = "SELECT login,COUNT(*) FROM feak_news JOIN user_more ON user_more.id = feak_news.news_user JOIN users ON user_more.id = users.user_details GROUP BY users.login")
    List<Map<String,String>> find();

    @Query(nativeQuery = true, value = "SELECT * FROM feak_news WHERE author=?1")
    List<PostEntity> findAllByAuthor(String someGuy);
}
