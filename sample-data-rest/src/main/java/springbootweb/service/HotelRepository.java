package springbootweb.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import springbootweb.domain.City;
import springbootweb.domain.Hotel;

/**
 * Created by vitaliy on 17.04.15.
 */
@RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
public interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {

    Hotel findByCityAndName(City city, String name);
}
