package springbootjpa.repository.jpa;

import org.springframework.stereotype.Repository;
import springbootjpa.domain.Author;
import springbootjpa.repository.AuthorRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by vitaliy on 17.04.15.
 */
@Repository
public class JpaAuthorRepository implements AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Author> findAll() {
        return this.entityManager.createQuery("select a from Author a", Author.class)
                .getResultList();
    }
}
