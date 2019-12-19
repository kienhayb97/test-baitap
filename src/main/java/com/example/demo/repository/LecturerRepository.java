package com.example.demo.repository;

import com.example.demo.model.Lecturers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturers, Long> {
}
