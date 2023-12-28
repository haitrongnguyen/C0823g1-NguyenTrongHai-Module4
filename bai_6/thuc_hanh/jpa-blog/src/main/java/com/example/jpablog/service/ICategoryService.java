package com.example.jpablog.service;

import com.example.jpablog.model.Blog;
import com.example.jpablog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(Long id);
}
