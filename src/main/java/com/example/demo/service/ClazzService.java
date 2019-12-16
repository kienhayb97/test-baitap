package com.example.demo.service;

import com.example.demo.model.Clazz;

import java.util.Optional;

public interface ClazzService {
    Iterable<Clazz> findAllClazz();
    Optional<Clazz> findById(Long id);
    void save(Clazz clazz);
    void remote(Long id);
}
