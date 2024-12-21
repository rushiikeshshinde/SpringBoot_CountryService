package org.example.springbootcountryserviceproject.beans;

import jakarta.persistence.*;

@Entity
@Table(name = "Country")
public class Country {

    @Id
    @Column(name = "id")
    long id;

    @Column(name = "country_name")
    String countryName;

    @Column(name = "capital")
    String countryCapital;

    public Country() {

    }

    public Country(long id, String countryName, String countryCapital) {
        this.id = id;
        this.countryName = countryName;
        this.countryCapital = countryCapital;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }


}
