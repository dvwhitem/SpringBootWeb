package springbootweb.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import springbootweb.domain.Car;
import springbootweb.domain.Country;

/**
 * Created by vitaliy on 20.04.15.
 */
@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
interface CarRepository extends PagingAndSortingRepository<Car, Long> {

    Car findByCountryAndBrand(Country country, String brand);

    Page<Car> findByBrandContainingAllIgnoringCase(@Param("brand") String brand, Pageable pageable);
}
