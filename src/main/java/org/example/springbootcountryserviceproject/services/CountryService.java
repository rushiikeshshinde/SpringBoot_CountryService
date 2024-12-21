package org.example.springbootcountryserviceproject.services;

import org.example.springbootcountryserviceproject.beans.Country;
import org.example.springbootcountryserviceproject.controllers.AddResponse;
import org.example.springbootcountryserviceproject.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class CountryService {

    @Autowired
    CountryRepository countryrep;

    public List<Country> getAllCountries(){
        return countryrep.findAll();
    }

    public Country getCountryById(long id){
        return countryrep.findById(id).get();
    }

    public Country getCountryByName(String countryName){
        List<Country> countries = countryrep.findAll();
        Country country = null;
        for (Country c : countries) {
            if (c.getCountryName().equals(countryName)) {
                country = c;
            }
        }
        return country;
    }

    public Country addCountry(Country country){
        country.setId(getMaxId());
        countryrep.save(country);
        return country;
    }

    public int getMaxId(){
        return countryrep.findAll().size()+1;
    }

    public Country updateCountry(Country country){
        countryrep.save(country);
        return country;
    }

    public AddResponse deleteCountry(long id){
        countryrep.deleteById(id);
        AddResponse addResponse = new AddResponse();
        addResponse.setMessage("Country Deleted!");
        addResponse.setId(id);
        return addResponse;
    }

}
