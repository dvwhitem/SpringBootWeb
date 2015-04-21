package springbootjpa.repository.jpa;

import org.springframework.stereotype.Repository;
import springbootjpa.domain.Book;
import springbootjpa.repository.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by vitaliy on 17.04.15.
 */
@Repository
public class JpaBookRepository implements BookRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Book> findAll() {
        return this.entityManager.createQuery("select b from Book b", Book.class)
                .getResultList();
    }
}
