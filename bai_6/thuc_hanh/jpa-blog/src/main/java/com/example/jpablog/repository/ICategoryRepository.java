package com.example.jpablog.repository;

import com.example.jpablog.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
