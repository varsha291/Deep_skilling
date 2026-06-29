package com.library.ormlearn.repository;

import com.library.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    Country findByCode(String code);

    List<Country> findByNameContainingIgnoreCase(String name);

    // Search by containing text and sort ascending
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String name);

    // Search by starting alphabet
    List<Country> findByNameStartingWithIgnoreCase(String alphabet);

}