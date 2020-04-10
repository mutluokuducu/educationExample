package com.education.controller;

import com.education.repository.entity.Students;
import com.education.service.StudentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  @Autowired
  private StudentService studentService;


  @RequestMapping(value = "/student", method = RequestMethod.GET)
  public List<Students> getAllStudent() {
    System.out.printf("test123");
    return studentService.getAllStudent();

  }

  @RequestMapping(value = "/student/{studentName}", method = RequestMethod.GET)
  public ResponseEntity<?> getStudent(@PathVariable String studentName) {
    Optional<Students> students = studentService.getStudent(studentName);
    if (studentName.isEmpty()) {
      return new ResponseEntity(students, HttpStatus.OK);

    } else {
      return new ResponseEntity(students, HttpStatus.NOT_FOUND);
    }
  }
}
/*
 @RequestMapping(value = "/student/{studentName}", method = RequestMethod.GET)
  public ResponseEntity<?> getStudent(@PathVariable String studentName) {
    Optional<Students> students= studentService.getStudent(studentName);
    return new ResponseEntity(students, HttpStatus.OK);

  }
 */