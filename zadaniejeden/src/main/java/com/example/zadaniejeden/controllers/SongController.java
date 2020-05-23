package com.example.zadaniejeden.controllers;


import com.example.zadaniejeden.commands.SongCommand;
import com.example.zadaniejeden.converters.SongCommandToSong;
import com.example.zadaniejeden.model.Song;
import com.example.zadaniejeden.repositories.ArtistRepository;
import com.example.zadaniejeden.repositories.SongRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SongController {

    private SongRepository songRepository;
    private SongCommandToSong songCommandToSong;


    public SongController(SongRepository songRepository, SongCommandToSong songCommandToSong, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.songCommandToSong = songCommandToSong;
    }

    @GetMapping
    @RequestMapping(value = {"/songs" , "song/list"})
    public String getSongs(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "song/list";
    }

    @GetMapping
    @RequestMapping("/song/{id}/show")
    public String getSongDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("song", songRepository.findById(id).get());
        return "song/show";
    }

    @GetMapping
    @RequestMapping("/song/{id}/delete")
    public String deleteSong(@PathVariable("id") Long id) {
        songRepository.deleteById(id);
        return "redirect:/songs";
    }

    @GetMapping
    @RequestMapping("/song/new")
    public String newSong(Model model){
        model.addAttribute("song", new SongCommand());
        return "song/addedit";
    }

    @PostMapping("song")
    public String saveOrUpdate(@ModelAttribute SongCommand command){
        Song detachedSong = songCommandToSong.convert(command);
        Song savedSong = songRepository.save(detachedSong);

        return "redirect:/song/" + savedSong.getId() + "/show";
    }
}

