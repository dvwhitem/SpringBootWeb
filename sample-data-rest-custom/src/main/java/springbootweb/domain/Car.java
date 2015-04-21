package springbootweb.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vitaliy on 19.04.15.
 */
@Entity
public class Car implements Serializable {

    private static final long serialVersionUID = 2635587179121452677L;

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @NaturalId
    private Country country;

    @Column(nullable = false)
    @NaturalId
    private String brand;

    private Integer year;

    public Car() {}

    public Car(Country country, String brand) {
        this.country = country;
        this.brand = brand;
    }

    public Country getCountry() {
        return country;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getYear() {
        return year;
    }
}
