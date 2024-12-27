package org.example.springbootcountryserviceproject.controllers;

import jakarta.websocket.server.PathParam;
import org.example.springbootcountryserviceproject.beans.Country;
import org.example.springbootcountryserviceproject.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/getcountries")
    public String getCountries(){
        return "All Countries";
    }

    @GetMapping("/getcountries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") Integer id){
        try{
            Country country = countryService.getCountryById(id);
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getcountries/countryname")
    public ResponseEntity<Country> getCountryByName(@RequestParam(value = "name") String countryName){
        try{
            Country country = countryService.getCountryByName(countryName);
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addcountry")
    public Country addCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }

    @PutMapping("/updatecountry/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable(value = "id") Integer id,@RequestBody Country country){

        try {
            Country existCountry = countryService.getCountryById(id);

            existCountry.setCountryName(country.getCountryName());
            existCountry.setCountryCapital(country.getCountryCapital());

            Country updatedCountry = countryService.updateCountry(existCountry);
            return new ResponseEntity<>(updatedCountry,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("/deletecountry/{id}")
    public AddResponse deleteCountry(@PathVariable(value = "id") Integer id){

        return countryService.deleteCountry(id);

    }
}
