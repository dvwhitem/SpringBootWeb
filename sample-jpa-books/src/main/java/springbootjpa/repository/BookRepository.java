package springbootjpa.repository;

import springbootjpa.domain.Book;

import java.util.List;

/**
 * Created by vitaliy on 17.04.15.
 */
public interface BookRepository {

    List<Book> findAll();
}
