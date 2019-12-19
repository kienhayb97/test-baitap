package com.example.demo.service;

import com.example.demo.model.Lecturers;

import java.util.Optional;

public interface ILecturerService {
    Iterable<Lecturers> findAllLecturer();
    Optional<Lecturers> findById(Long id);
    void save(Lecturers lecturers);
    void remote(Long id);
}
