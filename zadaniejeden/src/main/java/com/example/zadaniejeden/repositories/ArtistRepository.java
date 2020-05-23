package com.example.zadaniejeden.repositories;

import com.example.zadaniejeden.model.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArtistRepository extends CrudRepository<Artist, Long>{
    Optional<Artist> getFirstByFirstNameAndLastName(String firstName, String lastName);
}
