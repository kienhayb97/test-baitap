package com.example.demo.controller;

import com.example.demo.model.Lecturers;
import com.example.demo.model.Module;
import com.example.demo.service.impl.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/lecturers")
public class LecturerController {
    @Autowired
    LecturerService lecturerService;

    @GetMapping("home")
    public ResponseEntity<Iterable<Lecturers>> showListLecturer() {
        Iterable<Lecturers> lecturers = lecturerService.findAllLecturer();
        return new ResponseEntity<Iterable<Lecturers>>(lecturers, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addNewLecturer(@Valid @RequestBody Lecturers lecturers) {
        try {
            lecturerService.save(lecturers);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lecturers> getLecturersById(@PathVariable Long id) {
        Optional<Lecturers> lecturers = lecturerService.findById(id);
        if (lecturers.isPresent()) {
            return new ResponseEntity<>(lecturers.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lecturers> updateLecturer(@PathVariable Long id, @RequestBody Lecturers lecturers) {
        Optional<Lecturers> currentLecturer = lecturerService.findById(id);
        if (currentLecturer.isPresent()) {
            currentLecturer.get().setId(id);
            currentLecturer.get().setName(lecturers.getName());
            currentLecturer.get().setClazzes(lecturers.getClazzes());

            lecturerService.save(currentLecturer.get());

            return new ResponseEntity<Lecturers>(currentLecturer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Lecturers>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lecturers> deleteLecturer(@PathVariable Long id) {
        Optional<Lecturers> lecturers = lecturerService.findById(id);
        if (lecturers.isPresent()) {
            lecturerService.remote(id);
            return new ResponseEntity<Lecturers>(HttpStatus.OK);
        }
        return new ResponseEntity<Lecturers>(HttpStatus.NOT_FOUND);
    }

}

