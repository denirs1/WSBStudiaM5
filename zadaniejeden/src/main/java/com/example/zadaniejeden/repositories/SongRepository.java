package com.example.zadaniejeden.repositories;

import com.example.zadaniejeden.model.Artist;
import com.example.zadaniejeden.model.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> getAllByArtistsIsContaining(Artist artist);
}
