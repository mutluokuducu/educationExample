package com.education.service;

import com.education.repository.StudentRepository;
import com.education.repository.entity.Students;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  public void deleteStudentByIdAndName(Integer id,String name){
    studentRepository.deleteByIdAndFullName(id,name);
  }

  public void deleteStudentById(Integer id){
    studentRepository.deleteById(id);

  }
}
    /*
    if (!getStudent.isPresent()) {
      return null;
    }
    return ofNullable(getStudent.get());
  }
     */
