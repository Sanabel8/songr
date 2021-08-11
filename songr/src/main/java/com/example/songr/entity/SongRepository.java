package com.example.songr.entity;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song,Long> {
//    Iterable<Song> findAllBysong(String title);
//    Iterable<Song> findAllByalbum(Album album);
}


