package com.example.eurakeclienprovider.repository;

import com.example.eurakeclienprovider.entity.Student;

import java.util.Collection;

public interface StudentRepository {
    public Collection findAll();
    public Student findById(long id);
    public void saveOrUpdate(Student student);
    public void deleteById(long id);

}
