package pl.konrad.feak_news.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.konrad.feak_news.model.entities.PostEntitie;


@Repository
public interface PostRepository extends CrudRepository<PostEntitie, Iterable> {
    Page<PostEntitie> findAllByOrderByIdDesc(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM feak_news WHERE id=?1" )
    PostEntitie findById(int id);
}
