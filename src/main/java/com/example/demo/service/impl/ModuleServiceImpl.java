package com.example.demo.service.impl;

import com.example.demo.model.Module;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    ModuleRepository moduleRepository;

    @Override
    public Iterable<Module> findAllModule() {
        return moduleRepository.findAll();
    }

    @Override
    public Optional<Module> findById(Long id) {
        return moduleRepository.findById(id);
    }

    @Override
    public void save(Module module) {
        moduleRepository.save(module);
    }

    @Override
    public void remote(Long id) {
        moduleRepository.deleteById(id);
    }
}
