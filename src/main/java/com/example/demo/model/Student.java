package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private int age;
    private Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "clazz")
    private Clazz clazz;

    @ManyToMany
    @JoinColumn(name = "module")
    private Set<Module> module;

    public Student() {
    }

    public Student(Long id, String name, String address, int age, Date dateOfBirth, Clazz clazz, Set<Module> module) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.clazz = clazz;
        this.module = module;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Set<Module> getModule() {
        return module;
    }

    public void setModule(Set<Module> module) {
        this.module = module;
    }
}
