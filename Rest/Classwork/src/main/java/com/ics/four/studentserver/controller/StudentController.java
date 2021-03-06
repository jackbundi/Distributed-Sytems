package com.ics.four.studentserver.controller;

import com.ics.four.studentserver.domain.Student;
import com.ics.four.studentserver.service.StudentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAllStudents();
    }

    @GetMapping(value = "{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PatchMapping
    public Student updateStudent(@Validated(Student.Update.class)
                                     @RequestBody Student student) {
        return studentService.updateStudent(student);
    }

//
//    @DeleteMapping
//    public void deleteStudent(@PathVariable Long id) {
//        Student student = studentsRepository.findById(id).get();
//        studentsRepository.delete(student);
//    }

    @DeleteMapping(value = "{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping(value = "search")
    public List<Student> search(@RequestParam String searchTerm){
        return studentService.search(searchTerm);
    }
}
