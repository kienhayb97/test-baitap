package com.example.demo.controller;

import com.example.demo.model.Module;
import com.example.demo.model.Module;
import com.example.demo.service.ModuleService;
import com.example.demo.service.impl.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    ModuleService moduleService;

    @GetMapping("home")
    public ResponseEntity<Iterable<Module>> showListModule() {
        Iterable<Module> modules = moduleService.findAllModule();
        return new ResponseEntity<Iterable<Module>>(modules, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addNewModule(@Valid @RequestBody Module module) {
        try {
            moduleService.save(module);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id) {
        Optional<Module> module = moduleService.findById(id);
        if (module.isPresent()) {
            return new ResponseEntity<>(module.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module module) {
        Optional<Module> currentModule = moduleService.findById(id);
        if (currentModule.isPresent()) {
            currentModule.get().setId(id);
            currentModule.get().setName(module.getName());
            currentModule.get().setStudentList(module.getStudentList());

            moduleService.save(currentModule.get());

            return new ResponseEntity<Module>(currentModule.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Module> deleteModule(@PathVariable Long id) {
        Optional<Module> module = moduleService.findById(id);
        if (module.isPresent()) {
            moduleService.remote(id);
            return new ResponseEntity<Module>(HttpStatus.OK);
        }
        return new ResponseEntity<Module>(HttpStatus.NOT_FOUND);
    }

}

