package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/home")
    public ResponseEntity<Iterable<Student>> showListStudent() {
        Iterable<Student> students = studentService.findAllStudent();
        return new ResponseEntity<Iterable<Student>>(students, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addNewStudent(@Valid @RequestBody Student student) {
        try {
            studentService.save(student);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        Optional<Student> currentStudent = studentService.findById(id);
        if (currentStudent.isPresent()){
            currentStudent.get().setId(id);
            currentStudent.get().setAddress(student.getAddress());
            currentStudent.get().setAge(student.getAge());
            currentStudent.get().setClazz(student.getClazz());
            currentStudent.get().setDateOfBirth(student.getDateOfBirth());
            currentStudent.get().setModule(student.getModule());
            currentStudent.get().setName(student.getName());

            studentService.save(currentStudent.get());

            return new ResponseEntity<Student>(currentStudent.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()){
            studentService.remote(id);
            return new ResponseEntity<Student>(HttpStatus.OK);
        }
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }


}
