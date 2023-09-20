package com.skv.tms.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Database {
    private static List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        student.setId(UUID.randomUUID());
        students.add(student);
    }

    public void deleteStudent(UUID id){
        Optional<Student> first = students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
        first.ifPresent(student -> students.remove(student));
    }
    public List<Student> getByName(String name){
        if(name == null || name.isBlank()){
            return students;
        }
        return students.stream()
                .filter(student -> name.equals(student.getName()))
                .collect(Collectors.toList());
    }

}
