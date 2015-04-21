package springbootweb.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import springbootweb.domain.Country;

/**
 * Created by vitaliy on 20.04.15.
 */
@RepositoryRestResource(collectionResourceRel = "headquarters", path = "headquarters")
interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

    Page<Country> findByCapitalContainingAndHeadquartersContainingAllIgnoringCase(
            @Param("capital") String capital, @Param("headquarters") String headquarters, Pageable pageable);

    Country findByCapitalAndHeadquartersAllIgnoringCase(
            @Param("capital") String capital, @Param("headquarters") String headquarters);
}
