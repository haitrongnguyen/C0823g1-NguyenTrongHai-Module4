package com.example.jpablog.service;

import com.example.jpablog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void remove(Blog blog);

    Blog findById(Long id);
}
