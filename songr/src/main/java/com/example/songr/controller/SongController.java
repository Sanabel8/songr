package com.example.songr.controller;

import com.example.songr.entity.Album;
import com.example.songr.entity.AlbumRepository;
import com.example.songr.entity.Song;
import com.example.songr.entity.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @GetMapping("/songs")
    public String getAllSongs(Model song) {
        song.addAttribute("songs", songRepository.findAll());
        return "song";
    }

    @GetMapping("/addSong")
    public String getAddSong() {
        return "addSongs";
    }
    @PostMapping("/SumSongs")
    public RedirectView addSong(@RequestParam(value = "title") String title ,
                                @RequestParam(value = "length") int length ,
                                @RequestParam(value = "trackNumber") int trackNumber ,
                                @RequestParam(value = "albumId") Long albumId, Model song){


            Album album = albumRepository.findById(albumId).get();
            Song songs = new Song(title,length,trackNumber,album);
            songRepository.save(songs);
            Album newAlbum = albumRepository.findById(album.getId()).get();
            song.addAttribute("songs", newAlbum.getSong());
            return  new RedirectView("/songs");
    }
}