package com.example.jpablog.repository;

import com.example.jpablog.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();

    void save(Blog blog);

    void remove(Blog blog);

    Blog findById(Long id);
}
