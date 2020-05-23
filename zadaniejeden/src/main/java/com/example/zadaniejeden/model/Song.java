package com.example.zadaniejeden.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String genre;
    private String ismn;
    private String year;

    @ManyToMany
    private Set<Artist> artists = new HashSet<>();

    public Song() {
    }
    public Song(String title, String genre, String ismn, String year) {
        this.title = title;
        this.genre = genre;
        this.ismn = ismn;
        this.year = year;
    }

}
