package pl.konrad.feak_news.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.konrad.feak_news.model.entities.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE login=?1 AND password=?2")
    Optional<UserEntity> findByLoginAndPassword(String login, String password);

}
