package com.example.demo.controller;

import com.example.demo.model.Clazz;
import com.example.demo.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/class")
public class ClazzController {
    @Autowired
    ClazzService clazzService;

    @GetMapping("home")
    public ResponseEntity<Iterable<Clazz>> showListClass(){
       Iterable<Clazz> clazzes = clazzService.findAllClazz();
      return new ResponseEntity<Iterable<Clazz>>(clazzes, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity addNewClazz(@Valid @RequestBody Clazz clazz){
       try {
           clazzService.save(clazz);
           return new ResponseEntity(HttpStatus.CREATED);
       }catch (Exception e){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Clazz> getClazzById(@PathVariable Long id){
        Optional<Clazz> clazz = clazzService.findById(id);
        if (clazz.isPresent()){
            return new ResponseEntity<>(clazz.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Clazz> updateClazz(@PathVariable Long id, @RequestBody Clazz clazz){
        Optional<Clazz> currentClazz = clazzService.findById(id);
        if (currentClazz.isPresent()){
            currentClazz.get().setId(id);
            currentClazz.get().setName(clazz.getName());
            currentClazz.get().setStudent(clazz.getStudent());

            clazzService.save(currentClazz.get());

            return new ResponseEntity<Clazz>(currentClazz.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Clazz>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Clazz> deleteClazz(@PathVariable Long id){
        Optional<Clazz> clazz = clazzService.findById(id);
        if (clazz.isPresent()){
            clazzService.remote(id);
            return new ResponseEntity<Clazz>(HttpStatus.OK);
        }
        return new ResponseEntity<Clazz>(HttpStatus.NOT_FOUND);
    }

}
