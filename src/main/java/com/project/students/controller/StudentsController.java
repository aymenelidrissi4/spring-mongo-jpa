package com.project.students.controller;

import com.project.students.exception.StudentNotFoundException;
import com.project.students.model.Student;
import com.project.students.repository.StudentMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentsController {

/*    @Autowired
    private StudentRepository studentRepository;*/
    @Autowired
    private StudentMongoRepository studentMongoRepository;



    @GetMapping("/all")
    public List<Student> getAllStudents() {
        //return studentRepository.findAll();
        return studentMongoRepository.findAll();
    }

    @GetMapping("/all/{id}")
    public Optional<Student> getStudent(@PathVariable String id) throws StudentNotFoundException {
        //return Optional.of(studentRepository.findById(id)).orElseThrow(() -> new StudentNotFoundException("student with id " + id + " not found"));
        return Optional.of(studentMongoRepository.findById(id)).orElseThrow(() -> new StudentNotFoundException("student with id " + id + " not found"));
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        //studentRepository.save(student);
        studentMongoRepository.save(student);
        return "Student with id : " + student.getId() + " added successfully";
    }

    @DeleteMapping("/remove/{id}")
    public String removeStudent(@PathVariable String id) {
        //studentRepository.deleteById(id);
        studentMongoRepository.deleteById(id);
        return "Strudent with id : " + id + " removed successfully";
    }
}
