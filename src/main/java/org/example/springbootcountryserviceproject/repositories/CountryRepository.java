package org.example.springbootcountryserviceproject.repositories;

import org.example.springbootcountryserviceproject.beans.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
