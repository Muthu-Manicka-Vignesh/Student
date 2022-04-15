package com.myprogramming.SpringApp.Manager;

import com.myprogramming.SpringApp.Model.Student;
import com.myprogramming.SpringApp.Records.Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Manager {

    @Autowired
    public Records records;

    @PostMapping("addStudent")
    public Student addStudent(@RequestBody Student student){
        return records.save(student);
    }
    @GetMapping("getAllStudents")
    public List<Student> getAllStudents(){
        return records.findAll();
    }
    @GetMapping("getStudent/{id}")
    public Optional<Student> getStudentById(@PathVariable int id){
        return records.findById(id);
    }
    @PostMapping("editStudent/{id}")
    public Student editStudent(@RequestBody Student student){
        return records.save(student);
    }
    @DeleteMapping("deleteStudent/{id}")
    public String deleteStudentById(@PathVariable int id){
        String result;
        records.deleteById(id);
        result="deleted";
        return result;
    }
}
