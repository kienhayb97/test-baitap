package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clazz")
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    @OneToMany(targetEntity = Student.class, fetch = FetchType.EAGER)
    private Set<Student> student;

    @ManyToMany
    private Set<Lecturers> lecturers;

    public Clazz() {

    }

    public Clazz(Long id, String name, Set<Student> student, Set<Lecturers> lecturers) {
        this.id = id;
        this.name = name;
        this.student = student;
        this.lecturers = lecturers;
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

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }
}
