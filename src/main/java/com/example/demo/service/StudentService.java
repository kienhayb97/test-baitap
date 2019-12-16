package com.example.demo.service;


import com.example.demo.model.Student;

import java.util.Optional;

public interface StudentService {
    Iterable<Student> findAllStudent();
    Optional<Student> findById(Long id);
    void save(Student student);
    void remote(Long id);
}
