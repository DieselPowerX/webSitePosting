package pl.konrad.feak_news.model.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.konrad.feak_news.model.entities.PostEntity;
import pl.konrad.feak_news.model.interfaceForm.AllPostsPerMod;
import pl.konrad.feak_news.model.interfaceForm.StatisticsOfPostsByModerators;
import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer> {
    Page<PostEntity> findAllByOrderByIdDesc(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM feak_news WHERE id=?1" )
    PostEntity findById(int id);

    @Query(nativeQuery = true, value = "SELECT login, COUNT(*) AS cnt FROM feak_news JOIN user_more ON user_more.id = feak_news.news_user JOIN users ON user_more.id = users.user_details GROUP BY users.login")
    List<StatisticsOfPostsByModerators> find();

    @Query(nativeQuery = true, value = "SELECT * FROM feak_news WHERE author=?1")
    List<PostEntity> findAllByAuthor(String someGuy);

    @Query(nativeQuery = true, value = "SELECT login, feak_news.id, title, date, views FROM feak_news JOIN user_more ON user_more.id = feak_news.news_user JOIN users ON user_more.id = users.user_details")
    List<AllPostsPerMod> findAllPostsPerMod();

    @Modifying
    @Transactional(readOnly=false)
    @Query(nativeQuery = true, value = "UPDATE feak_news SET views=views+1 WHERE id=?1")
    void updateViews(int id);

    @Query(nativeQuery = true, value = "SELECT count(*) maximum FROM `feak_news` GROUP BY author ORDER BY maximum DESC LIMIT 1")
    Optional<Integer> maxNumbersOfPostBySingleMod();
}
