package com.example.jpablog.service;

import com.example.jpablog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void delete(Blog blog);

    Blog findById(Long id);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByOrderByTime(Pageable pageable);
    Page<Blog> searchBlogByNameContains(Pageable pageable,String name);
    Page<Blog> searchBlogByCategory_Id(Pageable pageable,Long name);
}
