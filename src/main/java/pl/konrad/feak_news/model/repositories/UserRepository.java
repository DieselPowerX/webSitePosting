package pl.konrad.feak_news.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.konrad.feak_news.model.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
