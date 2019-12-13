package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Lecturers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    private Set<Clazz> clazzes;

    public Lecturers() {
    }

    public Lecturers(Long id, String name, Set<Clazz> clazzes) {
        this.id = id;
        this.name = name;
        this.clazzes = clazzes;
    }

    public Set<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(Set<Clazz> clazzes) {
        this.clazzes = clazzes;
    }

    public Lecturers(Set<Clazz> clazzes) {
        this.clazzes = clazzes;
    }

    public Lecturers(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
