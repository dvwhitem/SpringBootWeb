package springbootweb.repository;

import springbootweb.domain.Note;

import java.util.List;

/**
 * Created by vitaliy on 17.04.15.
 */
public interface NoteRepository {

    List<Note> findAll();
}
