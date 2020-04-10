package com.education.service;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

import com.education.repository.StudentRepository;
import com.education.repository.entity.Students;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Lists;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public List<Students> getAllStudent() {

    Iterable<Students> studentsList = studentRepository.findAll();
    return (List<Students>) studentsList;
  }

  public Optional<Students> getStudent(String name) {

    Optional<Students> getStudent = studentRepository.findByFullName(name);
    return getStudent.map(Optional::ofNullable).orElse(null);
  }
}
    /*
    if (!getStudent.isPresent()) {
      return null;
    }
    return ofNullable(getStudent.get());
  }
     */
