package com.example.songvalidate.service;

import com.example.songvalidate.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
}
