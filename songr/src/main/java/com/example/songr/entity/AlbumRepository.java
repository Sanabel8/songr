package com.example.songr.entity;
import org.springframework.data.repository.CrudRepository;
import com.example.songr.Album;

public interface AlbumRepository extends  CrudRepository<Album,Long>{
}
