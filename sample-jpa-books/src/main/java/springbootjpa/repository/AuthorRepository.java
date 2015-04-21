package springbootjpa.repository;

import springbootjpa.domain.Author;

import java.util.List;

/**
 * Created by vitaliy on 17.04.15.
 */
public interface AuthorRepository {

    List<Author> findAll();
}
