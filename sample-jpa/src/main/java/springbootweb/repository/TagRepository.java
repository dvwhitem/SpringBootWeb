package springbootweb.repository;

import springbootweb.domain.Tag;

import java.util.List;

/**
 * Created by vitaliy on 17.04.15.
 */
public interface TagRepository {

    List<Tag> findAll();
}
