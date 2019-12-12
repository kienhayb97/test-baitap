package com.example.demo.controller;

import com.example.demo.model.Clazz;
import com.example.demo.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
}
