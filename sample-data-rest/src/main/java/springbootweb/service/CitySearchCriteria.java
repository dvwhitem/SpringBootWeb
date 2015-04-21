package springbootweb.service;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * Created by vitaliy on 18.04.15.
 */
public class CitySearchCriteria implements Serializable {

    private static final long serialVersionUID = 1924031703857710831L;

    private String name;

    public CitySearchCriteria() {}

    public CitySearchCriteria(String name) {
        Assert.notNull(name, "Name must not be null");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
