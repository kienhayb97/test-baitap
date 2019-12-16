package com.example.demo.service.impl;


import com.example.demo.model.Clazz;
import com.example.demo.repository.ClazzRepository;
import com.example.demo.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClazzServiceImpl implements ClazzService {
  @Autowired
  ClazzRepository clazzRepository;

  @Override
  public Iterable<Clazz> findAllClazz() {
    return clazzRepository.findAll();
  }

  @Override
  public Optional<Clazz> findById(Long id) {
    return clazzRepository.findById(id);
  }

  @Override
  public void save(Clazz clazz) {
    clazzRepository.save(clazz);
  }

  @Override
  public void remote(Long id) {
  clazzRepository.deleteById(id);
  }
}
