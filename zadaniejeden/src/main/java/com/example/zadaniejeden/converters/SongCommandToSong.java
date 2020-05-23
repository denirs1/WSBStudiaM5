package com.example.zadaniejeden.converters;


import com.example.zadaniejeden.commands.SongCommand;
import com.example.zadaniejeden.model.Artist;
import com.example.zadaniejeden.model.Song;
import com.example.zadaniejeden.repositories.ArtistRepository;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;


@Component
public class SongCommandToSong implements Converter<SongCommand, Song> {

    private ArtistRepository artistRepository;

    public SongCommandToSong(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Synchronized
    @Nullable
    @Override
    public Song convert(SongCommand source) {
        if (source == null) {
            return null;
        }

        final Song song = new Song();
        song.setId(source.getId());
        song.setTitle(source.getTitle());
        song.setGenre(source.getGenre());
        song.setYear(source.getYear());
        song.setIsmn(source.getIsmn());

        return song;
    }
}

