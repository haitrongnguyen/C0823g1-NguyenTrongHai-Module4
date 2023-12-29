package com.example.songvalidate.repository;

import com.example.songvalidate.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ISongRepository extends JpaRepository<Song,Long> {
    Page<Song> findAll(Pageable pageable);
}
