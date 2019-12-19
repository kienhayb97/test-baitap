package com.example.demo.service.impl;

import com.example.demo.model.Lecturers;
import com.example.demo.repository.LecturerRepository;
import com.example.demo.service.ILecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LecturerService implements ILecturerService {
    @Autowired
    LecturerRepository lecturerRepository;
    @Override
    public Iterable<Lecturers> findAllLecturer() {
        return lecturerRepository.findAll();
    }

    @Override
    public Optional<Lecturers> findById(Long id) {
        return lecturerRepository.findById(id);
    }

    @Override
    public void save(Lecturers lecturers) {
        lecturerRepository.save(lecturers);
    }

    @Override
    public void remote(Long id) {
        lecturerRepository.deleteById(id);
    }
}
