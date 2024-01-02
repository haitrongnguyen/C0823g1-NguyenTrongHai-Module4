package com.example.customerprovince.service;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface IGenerateService<T> {
    List<T> findAll();

    void save(T t);

    T findById(Long id);

    void remove(Long id);
}
