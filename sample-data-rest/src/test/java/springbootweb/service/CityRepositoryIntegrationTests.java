package springbootweb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springbootweb.SampleDataRestApplication;
import springbootweb.domain.City;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by vitaliy on 19.04.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleDataRestApplication.class)
public class CityRepositoryIntegrationTests {

    @Autowired
    CityRepository cityRepository;

    @Test
    public void findsFirstPageOfCities() {
        Page<City> cities = this.cityRepository.findAll(new PageRequest(0, 10));
        assertThat(cities.getTotalElements(), is(greaterThan(20L)));

    }

    @Test
    public void findByNameAndCountry() {
        City city = this.cityRepository
                .findByNameAndCountryAllIgnoringCase("Melbourne", "Australia");
        assertThat(city, notNullValue());
        assertThat(city.getName(), is(equalTo("Melbourne")));
    }

    @Test
    public void findContaining() {
        Page<City> cities = this.cityRepository
                .findByNameContainingAndCountryContainingAllIgnoringCase("", "UK", new PageRequest(0, 10));

        assertThat(cities.getTotalElements(), is(equalTo(3L)));
    }
}
