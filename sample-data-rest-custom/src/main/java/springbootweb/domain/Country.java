package springbootweb.domain;


import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Created by vitaliy on 19.04.15.
 */
@Entity
public class Country implements Serializable {

    private static final long serialVersionUID = -7525494753171405611L;

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String capital;

    @Column(nullable = false)
    private String headquarters;

    private String language;

    public Country() {}

    public Country(String capital, String headquarters) {
        this.capital = capital;
        this.headquarters = headquarters;
    }

    public Long getId() {
        return id;
    }

    public String getCapital() {
        return capital;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Country{" +
                "language='" + language + '\'' +
                ", headquarters='" + headquarters + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }
}
