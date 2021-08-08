package com.example.songr.controller;

import com.example.songr.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumsController {
    @GetMapping("/albums")
    public String getAlbums(Model model){
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Prince and the Revolution","Purple Rain",5,1,"https://pbs.twimg.com/media/Eihki4LWoAAcvjk?format=png&name=small"));
        albums.add(new Album("Bob Dylan","Blood on the Tracks",2,7,"https://www.gannett-cdn.com/presto/2020/09/22/USAT/e2251973-e248-43f1-866f-dca07466dba5-XXX_E01_DYLAN_BLOOD_TRACKES_COVER_17_COMING.JPG?width=600&height=600&fit=crop&format=pjpg&auto=webp"));
        albums.add(new Album("Blue","Joni Mitchell",3,8,"https://www.gannett-cdn.com/presto/2020/06/14/USAT/936733cd-b251-4abd-a7cb-b55637a4fe29-XXX_D_WK_MARVIN_GAYE_COVERS_BEST_ALBUMS_14.JPG?width=660&height=594&fit=crop&format=pjpg&auto=webp"));

        model.addAttribute("albums",albums);
        return "albums.html";
    }
}
