package com.example.demo.service;

import com.example.demo.model.Module;

import java.util.Optional;

public interface ModuleService {
    Iterable<Module> findAllModule();
    Optional<Module> findById(Long id);
    void save(Module module);
    void remote(Long id);
}
