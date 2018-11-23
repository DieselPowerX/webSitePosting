package pl.konrad.feak_news.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.konrad.feak_news.model.entities.PostEntity;


@Repository
public interface PostRepository extends CrudRepository<PostEntity, Iterable> {
    Page<PostEntity> findAllByOrderByIdDesc(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM feak_news WHERE id=?1" )
    PostEntity findById(int id);
}
