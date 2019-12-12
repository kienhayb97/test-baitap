package com.example.demo.service;

import com.example.demo.model.Clazz;

public interface ClazzService {
    Iterable<Clazz> findAllClazz();
    void save(Clazz clazz);
}
