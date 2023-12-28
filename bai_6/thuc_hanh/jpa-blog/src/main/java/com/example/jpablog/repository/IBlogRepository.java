package com.example.jpablog.repository;

import com.example.jpablog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface IBlogRepository extends PagingAndSortingRepository<Blog,Long> {
    Page<Blog> findAllByOrderByTime(Pageable pageable);
    Page<Blog> searchBlogByNameContains(Pageable pageable,String name);
    Page<Blog> searchBlogByCategory_Id(Pageable pageable,Long name);
}
