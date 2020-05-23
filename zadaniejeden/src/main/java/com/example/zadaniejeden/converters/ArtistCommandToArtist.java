package com.example.zadaniejeden.converters;

import com.example.zadaniejeden.commands.ArtistCommand;
import com.example.zadaniejeden.commands.SongCommand;
import com.example.zadaniejeden.model.Artist;
import com.example.zadaniejeden.model.Song;
import com.example.zadaniejeden.repositories.ArtistRepository;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ArtistCommandToArtist implements Converter<ArtistCommand, Artist> {

    @Synchronized
    @Nullable
    @Override
    public Artist convert(ArtistCommand source) {
        if (source == null) {
            return null;
        }

        final Artist artist = new Artist();
        artist.setFirstName(source.getFirstName());
        artist.setLastName(source.getLastName());
        artist.setNick(source.getNick());

        return artist;
    }
}
