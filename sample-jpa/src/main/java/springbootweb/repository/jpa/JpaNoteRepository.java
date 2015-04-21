package springbootweb.repository.jpa;

import org.springframework.stereotype.Repository;
import springbootweb.domain.Note;
import springbootweb.repository.NoteRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by vitaliy on 17.04.15.
 */
@Repository
public class JpaNoteRepository implements NoteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Note> findAll() {
        return this.entityManager.createQuery("SELECT n FROM Note n", Note.class)
                .getResultList();
    }
}
