package com.example.jpablog.service.impl;

import com.example.jpablog.model.Blog;
import com.example.jpablog.repository.IBlogRepository;
import com.example.jpablog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByOrderByTime(Pageable pageable) {
        return blogRepository.findAllByOrderByTime(pageable);
    }

    @Override
    public Page<Blog> searchBlogByNameContains(Pageable pageable,String name) {
        return blogRepository.searchBlogByNameContains(pageable,name);
    }

    @Override
    public Page<Blog> searchBlogByCategory_Id(Pageable pageable, Long name) {
        return blogRepository.searchBlogByCategory_Id(pageable,name);
    }


}
