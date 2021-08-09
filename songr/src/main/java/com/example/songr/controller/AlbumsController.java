package com.example.songr.controller;

import com.example.songr.Album;
import com.example.songr.entity.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumsController {
    @Autowired
    AlbumRepository albumRepository;
    @GetMapping("/albums")
    public String getAlbums(Model model){
//        List<Album> albums = new ArrayList<>();
//        albums.add(new Album("Prince and the Revolution","Purple Rain",5,1,"https://pbs.twimg.com/media/Eihki4LWoAAcvjk?format=png&name=small"));
//        albums.add(new Album("Bob Dylan","Blood on the Tracks",2,7,"https://www.gannett-cdn.com/presto/2020/09/22/USAT/e2251973-e248-43f1-866f-dca07466dba5-XXX_E01_DYLAN_BLOOD_TRACKES_COVER_17_COMING.JPG?width=600&height=600&fit=crop&format=pjpg&auto=webp"));
//        albums.add(new Album("Blue","Joni Mitchell",3,8,"https://www.gannett-cdn.com/presto/2020/06/14/USAT/936733cd-b251-4abd-a7cb-b55637a4fe29-XXX_D_WK_MARVIN_GAYE_COVERS_BEST_ALBUMS_14.JPG?width=660&height=594&fit=crop&format=pjpg&auto=webp"));

        model.addAttribute("albums", albumRepository.findAll());
        return "albums.html";
    }
//    @GetMapping("/addalbum")
//    public RedirectView addAlbum(){
//        Album album = new Album("Prince and the Revolution","Purple Rain",5,1,"https://pbs.twimg.com/media/Eihki4LWoAAcvjk?format=png&name=small");
//        albumRepository.save(album);
//        return new RedirectView("/album");
//    }
    @GetMapping("/addAlbum")
    public String addAlbum(){
        return "addedAlbums.html";
    }
    @PostMapping("/albums")
    public RedirectView addAlbum(@RequestParam(value = "title") String title,
                                 @RequestParam(value = "artist") String artist,
                                 @RequestParam(value="songCount") int songCount,
                                 @RequestParam(value="imageUrl") String imageUrl,
                                 @RequestParam(value="length") long length){
Album album = new Album(title,artist,songCount, (int) length,imageUrl);

        albumRepository.save(album);
        return new RedirectView("/albums");
    }

}
