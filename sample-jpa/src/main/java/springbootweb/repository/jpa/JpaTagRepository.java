package springbootweb.repository.jpa;

import org.springframework.stereotype.Repository;
import springbootweb.domain.Tag;
import springbootweb.repository.TagRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by vitaliy on 17.04.15.
 */
@Repository
public class JpaTagRepository implements TagRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Tag> findAll() {
        return this.entityManager.createQuery("SELECT t FROM Tag t", Tag.class)
                .getResultList();
    }
}
